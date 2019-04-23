package org.konghao.aujaker.controller;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.konghao.reposiotry.kit.SimplePageBuilder;
import org.konghao.aujaker.model.Special;
import org.konghao.aujaker.service.ISpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/special")
public class SpecialController {

	@Autowired
	private ISpecialService specialService;

	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		Special special = new Special();
		model.addAttribute("special",special);
		return "special/add";
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Special special,Model model) {
		specialService.add(special);
		return "redirect:/special/list";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable String id,Model model) {
		Special special = specialService.load(id);
		model.addAttribute("special", special);
		return "special/show";
	}

	@RequestMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable String id) {
		specialService.delete(id);
		return "1";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id,Model model) {
		Special special = specialService.load(id);
		model.addAttribute("special",special);
		return "special/update";
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable String id,Special special) {
		try {
			Special tspecial = specialService.load(id);
			BeanUtils.copyProperties(tspecial, special);
			specialService.update(tspecial);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return "redirect:/special/list";
	}

	@RequestMapping("/list")
	public String find(Model model,Integer page,HttpServletRequest request) {
		Page<Special> specials = specialService.find(SimplePageBuilder.generate(page));
		model.addAttribute("datas",specials);
		return "special/list";
	}
}
