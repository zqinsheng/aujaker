package org.zhouqinsheng.faceExam.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.zhouqinsheng.faceExam.model.UserInfo;
import org.zhouqinsheng.faceExam.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private IUserInfoService userInfoService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		UserInfo userInfo = new UserInfo();
		model.addAttribute("userInfo",userInfo);
		return "userInfo/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(UserInfo userInfo,Model model) {
		userInfoService.add(userInfo);
		return "redirect:/userInfo/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable String id,Model model) {
		UserInfo userInfo = userInfoService.load(id);
		model.addAttribute("userInfo", userInfo);
		return "userInfo/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		userInfoService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model) {
		UserInfo userInfo = userInfoService.load(id);
		model.addAttribute("userInfo",userInfo);
		return "userInfo/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable String id,UserInfo userInfo) {
		try {
			UserInfo tuserInfo = userInfoService.load(id);
			BeanUtils.copyProperties(tuserInfo, userInfo);
			userInfoService.update(tuserInfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/userInfo/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<UserInfo> userInfos = userInfoService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",userInfos);
		return "userInfo/list";
	}
}
