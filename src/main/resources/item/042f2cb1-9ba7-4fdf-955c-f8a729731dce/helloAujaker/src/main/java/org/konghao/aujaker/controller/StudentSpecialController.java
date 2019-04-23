package org.konghao.aujaker.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.konghao.aujaker.model.StudentSpecial;
import org.konghao.aujaker.service.IStudentSpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/studentSpecial")
public class StudentSpecialController {

	@Autowired
	private IStudentSpecialService studentSpecialService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		StudentSpecial studentSpecial = new StudentSpecial();
		model.addAttribute("studentSpecial",studentSpecial);
		return "studentSpecial/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(StudentSpecial studentSpecial,Model model) {
		studentSpecialService.add(studentSpecial);
		return "redirect:/studentSpecial/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable String id,Model model) {
		StudentSpecial studentSpecial = studentSpecialService.load(id);
		model.addAttribute("studentSpecial", studentSpecial);
		return "studentSpecial/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		studentSpecialService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model) {
		StudentSpecial studentSpecial = studentSpecialService.load(id);
		model.addAttribute("studentSpecial",studentSpecial);
		return "studentSpecial/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable String id,StudentSpecial studentSpecial) {
		try {
			StudentSpecial tstudentSpecial = studentSpecialService.load(id);
			BeanUtils.copyProperties(tstudentSpecial, studentSpecial);
			studentSpecialService.update(tstudentSpecial);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/studentSpecial/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<StudentSpecial> studentSpecials = studentSpecialService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",studentSpecials);
		return "studentSpecial/list";
	}
}
