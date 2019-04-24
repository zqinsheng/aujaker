package org.zhouqinsheng.faceExam.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.zhouqinsheng.faceExam.model.TeacherInfo;
import org.zhouqinsheng.faceExam.service.ITeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/teacherInfo")
public class TeacherInfoController {

	@Autowired
	private ITeacherInfoService teacherInfoService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		TeacherInfo teacherInfo = new TeacherInfo();
		model.addAttribute("teacherInfo",teacherInfo);
		return "teacherInfo/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(TeacherInfo teacherInfo,Model model) {
		teacherInfoService.add(teacherInfo);
		return "redirect:/teacherInfo/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable String id,Model model) {
		TeacherInfo teacherInfo = teacherInfoService.load(id);
		model.addAttribute("teacherInfo", teacherInfo);
		return "teacherInfo/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		teacherInfoService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model) {
		TeacherInfo teacherInfo = teacherInfoService.load(id);
		model.addAttribute("teacherInfo",teacherInfo);
		return "teacherInfo/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable String id,TeacherInfo teacherInfo) {
		try {
			TeacherInfo tteacherInfo = teacherInfoService.load(id);
			BeanUtils.copyProperties(tteacherInfo, teacherInfo);
			teacherInfoService.update(tteacherInfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/teacherInfo/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<TeacherInfo> teacherInfos = teacherInfoService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",teacherInfos);
		return "teacherInfo/list";
	}
}
