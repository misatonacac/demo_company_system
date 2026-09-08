package com.example.todolist.controller;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.todolist.entity.UsermasterEdit;
import com.example.todolist.form.UsermasterData;
import com.example.todolist.repository.UsermasterEditRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor

public class UsermasterEditController {
	
	private final UsermasterEditRepository usermasterEditRepository;
	//private final UsermasterEditService usermasterEditService;
	@GetMapping("/edit")
	public ModelAndView usermasterEdit(ModelAndView mv) {
		mv.setViewName("usermasterEdit");
		mv.addObject("usermasterData",new UsermasterData());
		List<UsermasterEdit> usermasterEdit = usermasterEditRepository.findAll();
		
	
		mv.addObject("usermasterEdit",usermasterEdit);
		return mv;
	}
	
	@PostMapping("/edit")
	public ModelAndView createUsermaster(@ModelAttribute @Validated UsermasterData usermasterData,
			BindingResult result,ModelAndView mv) {
		
		//バリデーションエラー時は画面を再表示
		if(result.hasErrors()) {
			mv.setViewName("usermasterEdit");
			mv.addObject("usermasterData",usermasterData);
			List<UsermasterEdit> usermasterEditList=usermasterEditRepository.findAll();
			mv.addObject("usermasterEdit",usermasterEditList);
			return mv;
			
		}
		String  user_id = usermasterData.getUser_id();
		Optional<UsermasterEdit>opt =usermasterEditRepository.findById(user_id);
		
		if(opt.isPresent()) {
			//更新
			UsermasterEdit entity =opt.get();
			
			entity.setUser_name(usermasterData.getUser_name());
			entity.setBumon_id(usermasterData.getBumon_id());
			entity.setButen_id(usermasterData.getButen_id());
			entity.setGroup_id(usermasterData.getGroup_id());
			entity.setRole02_flg(usermasterData.getRole02_flg());
			entity.setRole03_flg(usermasterData.getRole03_flg());
			entity.setRole04_flg(usermasterData.getRole04_flg());
			entity.setRole05_flg(usermasterData.getRole05_flg());
			entity.setRole06_flg(usermasterData.getRole06_flg());
			entity.setRole07_flg(usermasterData.getRole07_flg());
			entity.setRole08_flg(usermasterData.getRole08_flg());
			entity.setRole09_flg(usermasterData.getRole09_flg());
			entity.setRole11_flg(usermasterData.getRole11_flg());
			entity.setRole12_flg(usermasterData.getRole12_flg());
			entity.setRole13_flg(usermasterData.getRole13_flg());
			entity.setRole13_flg(usermasterData.getRole13_flg());
			entity.setTouroku_user_id(usermasterData.getTouroku_user_id());
			entity.setKenin_user_id(usermasterData.getKenin_user_id());
			entity.setKenin_status(usermasterData.getKenin_status());
			entity.setApply_start_date(LocalDate.parse(usermasterData.getApply_start_date()));
			entity.setApply_end_date(LocalDate.parse(usermasterData.getApply_end_date()));
			
			
			
			usermasterEditRepository.save(entity);
			mv.setViewName("redirect:/edit");	
			
			
		}else {
			//新規登録処理
			UsermasterEdit usermasterEdit = usermasterData.toEntity();
			usermasterEditRepository.saveAndFlush(usermasterEdit);
			//登録後はリダイレクト
			mv.setViewName("redirect:/edit");		
			
		}return mv;
	}

}
