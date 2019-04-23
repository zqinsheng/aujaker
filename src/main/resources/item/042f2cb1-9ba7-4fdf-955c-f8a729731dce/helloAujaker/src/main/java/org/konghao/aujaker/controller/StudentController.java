package org.konghao.aujaker.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.konghao.aujaker.model.Student;
import org.konghao.aujaker.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "student/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Student student,Model model) {
		studentService.add(student);
		return "redirect:/student/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable int id,Model model) {
		Student student = studentService.load(id);
		model.addAttribute("student", student);
		return "student/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		studentService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		Student student = studentService.load(id);
		model.addAttribute("student",student);
		return "student/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,Student student) {
		try {
			Student tstudent = studentService.load(id);
			BeanUtils.copyProperties(tstudent, student);
			studentService.update(tstudent);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/student/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<Student> students = studentService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",students);
		return "student/list";
	}
}
