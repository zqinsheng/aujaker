package org.zhouqinsheng.faceExam.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.zhouqinsheng.faceExam.model.ExamInfo;
import org.zhouqinsheng.faceExam.service.IExamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/examInfo")
public class ExamInfoController {

	@Autowired
	private IExamInfoService examInfoService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		ExamInfo examInfo = new ExamInfo();
		model.addAttribute("examInfo",examInfo);
		return "examInfo/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(ExamInfo examInfo,Model model) {
		examInfoService.add(examInfo);
		return "redirect:/examInfo/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable String id,Model model) {
		ExamInfo examInfo = examInfoService.load(id);
		model.addAttribute("examInfo", examInfo);
		return "examInfo/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		examInfoService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model) {
		ExamInfo examInfo = examInfoService.load(id);
		model.addAttribute("examInfo",examInfo);
		return "examInfo/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable String id,ExamInfo examInfo) {
		try {
			ExamInfo texamInfo = examInfoService.load(id);
			BeanUtils.copyProperties(texamInfo, examInfo);
			examInfoService.update(texamInfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/examInfo/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<ExamInfo> examInfos = examInfoService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",examInfos);
		return "examInfo/list";
	}
}
