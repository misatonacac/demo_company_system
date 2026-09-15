package com.example.todolist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		mv.addObject("bumonForm",new BumonForm());
		List<BumonSelect> bumonSelect = bumonSelectRepository.findAll();
		
	
		mv.addObject("bumonSelect",bumonSelect);

		return mv;

	}

}
