package org.zhouqinsheng.faceExam.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.zhouqinsheng.faceExam.model.ExamRoom;
import org.zhouqinsheng.faceExam.service.IExamRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/examRoom")
public class ExamRoomController {

	@Autowired
	private IExamRoomService examRoomService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		ExamRoom examRoom = new ExamRoom();
		model.addAttribute("examRoom",examRoom);
		return "examRoom/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(ExamRoom examRoom,Model model) {
		examRoomService.add(examRoom);
		return "redirect:/examRoom/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable String id,Model model) {
		ExamRoom examRoom = examRoomService.load(id);
		model.addAttribute("examRoom", examRoom);
		return "examRoom/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		examRoomService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model) {
		ExamRoom examRoom = examRoomService.load(id);
		model.addAttribute("examRoom",examRoom);
		return "examRoom/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable String id,ExamRoom examRoom) {
		try {
			ExamRoom texamRoom = examRoomService.load(id);
			BeanUtils.copyProperties(texamRoom, examRoom);
			examRoomService.update(texamRoom);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/examRoom/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<ExamRoom> examRooms = examRoomService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",examRooms);
		return "examRoom/list";
	}
}
