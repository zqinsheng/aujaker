package org.zhouqinsheng.faceExam.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.zhouqinsheng.faceExam.model.ExamPerson;
import org.zhouqinsheng.faceExam.service.IExamPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/examPerson")
public class ExamPersonController {

	@Autowired
	private IExamPersonService examPersonService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		ExamPerson examPerson = new ExamPerson();
		model.addAttribute("examPerson",examPerson);
		return "examPerson/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(ExamPerson examPerson,Model model) {
		examPersonService.add(examPerson);
		return "redirect:/examPerson/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable String id,Model model) {
		ExamPerson examPerson = examPersonService.load(id);
		model.addAttribute("examPerson", examPerson);
		return "examPerson/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		examPersonService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model) {
		ExamPerson examPerson = examPersonService.load(id);
		model.addAttribute("examPerson",examPerson);
		return "examPerson/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable String id,ExamPerson examPerson) {
		try {
			ExamPerson texamPerson = examPersonService.load(id);
			BeanUtils.copyProperties(texamPerson, examPerson);
			examPersonService.update(texamPerson);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/examPerson/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<ExamPerson> examPersons = examPersonService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",examPersons);
		return "examPerson/list";
	}
}
