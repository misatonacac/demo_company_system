package com.example.todolist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.todolist.entity.BumonSelect;
import com.example.todolist.form.BumonForm;
import com.example.todolist.repository.BumonSelectRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor

public class BumonSelctController {
	private final BumonSelectRepository bumonSelectRepository;

	@GetMapping("/edit/bumonSelect")
	public ModelAndView bumonSelect(ModelAndView mv) {
		System.err.println("### 部門選択コントローラ開始 ###");
		mv.setViewName("bumonSelect");
		mv.addObject("bumonForm", new BumonForm());
		List<BumonSelect> bumonSelect = bumonSelectRepository.findAll();

		mv.addObject("bumonSelect", bumonSelect);

		return mv;

	}

	@PostMapping("/edit/bumonSelect")
	public ModelAndView bumonSelect(@RequestParam(value = "bumon_id") String bumon_id,
			ModelAndView mv) {
		if (bumon_id == null || bumon_id.isBlank()) {

			mv.setViewName("redirect:/edit");
			return mv;

		}
		mv.setViewName("redirect:/edit?bumon_id=" + bumon_id);
		return mv;

	}

}
