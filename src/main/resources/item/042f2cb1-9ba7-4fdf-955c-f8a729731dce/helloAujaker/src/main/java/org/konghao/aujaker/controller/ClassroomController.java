package org.konghao.aujaker.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.konghao.aujaker.model.Classroom;
import org.konghao.aujaker.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/classroom")
public class ClassroomController {

	@Autowired
	private IClassroomService classroomService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		Classroom classroom = new Classroom();
		model.addAttribute("classroom",classroom);
		return "classroom/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Classroom classroom,Model model) {
		classroomService.add(classroom);
		return "redirect:/classroom/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable int id,Model model) {
		Classroom classroom = classroomService.load(id);
		model.addAttribute("classroom", classroom);
		return "classroom/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		classroomService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		Classroom classroom = classroomService.load(id);
		model.addAttribute("classroom",classroom);
		return "classroom/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,Classroom classroom) {
		try {
			Classroom tclassroom = classroomService.load(id);
			BeanUtils.copyProperties(tclassroom, classroom);
			classroomService.update(tclassroom);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/classroom/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<Classroom> classrooms = classroomService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",classrooms);
		return "classroom/list";
	}
}
