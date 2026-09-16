package com.example.todolist.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.todolist.entity.BumonSelect;
import com.example.todolist.entity.UsermasterEdit;
import com.example.todolist.form.BumonForm;
import com.example.todolist.form.UsermasterData;
import com.example.todolist.repository.BumonSelectRepository;
import com.example.todolist.repository.UsermasterEditRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor

public class UsermasterEditController {

	private final UsermasterEditRepository usermasterEditRepository;
	private final BumonSelectRepository bumonSelectRepository;
	//private final UsermasterEditService usermasterEditService;

	@GetMapping("/edit")
	public ModelAndView usermasterEdit(@RequestParam(value = "bumon_id", required = false) String bumon_id,
			@RequestParam(value = "user_id", required = false) String user_id, ModelAndView mv) {

		System.err.println("### コントローラ開始 ###");
		
		mv.setViewName("bumonSelect");
		if (bumon_id == null || bumon_id.isBlank()) {
			//新規登録
			mv.addObject("bumon", new BumonForm());

		} else {
			BumonSelect bumon = bumonSelectRepository
					.findById(bumon_id)
					.orElseThrow(() -> new IllegalArgumentException(
							"ユーザーが見つかりません: " + user_id));

			mv.addObject("bumon", bumon);


		}
		mv.setViewName("usermasterEdit");
		if (user_id == null || user_id.isBlank()) {
			//新規登録
			mv.addObject("user", new UsermasterData());

		} else {
			UsermasterEdit user = usermasterEditRepository
					.findById(user_id)
					.orElseThrow(() -> new IllegalArgumentException(
							"ユーザーが見つかりません: " + user_id));

			mv.addObject("user", user);

		}
		return mv;

	}

	@PostMapping("/edit")
	public ModelAndView createUsermaster(@ModelAttribute @Validated UsermasterData usermasterData,
			BindingResult result, ModelAndView mv) {
		System.err.println("### POST /edit 開始 ###");
		System.err.println(
				"apply_start_date=[" +
						usermasterData.getApply_start_date() + "]");
		System.err.println(
				"apply_end_date=[" +
						usermasterData.getApply_end_date() + "]");

		//バリデーションエラー時は画面を再表示
		if (result.hasErrors()) {
			mv.setViewName("usermasterEdit");
			mv.addObject("usermasterData", usermasterData);

			return mv;

		}
		String user_id = usermasterData.getUser_id();
		if (user_id == null || user_id.isBlank()) {
			// user_idがない場合は新規登録
			UsermasterEdit entity = usermasterData.toEntity();
			usermasterEditRepository.save(entity);
			mv.setViewName("redirect:/edit?user_id=" + entity.getUser_id());
			return mv;
		}
		Optional<UsermasterEdit> optionalUser = usermasterEditRepository.findById(user_id);

		if (optionalUser.isPresent()) {
			//更新
			UsermasterEdit entity = optionalUser.get();

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
			entity.setNote(usermasterData.getNote());

			entity.setTouroku_user_id(usermasterData.getTouroku_user_id());
			entity.setKenin_user_id(usermasterData.getKenin_user_id());
			entity.setKenin_status(usermasterData.getKenin_status());

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd");

			entity.setApply_start_date(
					LocalDate.parse(
							usermasterData.getApply_start_date(),
							formatter));

			entity.setApply_end_date(
					LocalDate.parse(
							usermasterData.getApply_end_date(),
							formatter));

			usermasterEditRepository.save(entity);
			mv.setViewName("redirect:/edit?user_id=" + user_id);
			return mv;

		} // 指定されたuser_idが存在しない場合
		mv.setViewName("usermasterEdit");
		mv.addObject("user", usermasterData);
		mv.addObject("errorMessage", "指定されたユーザーが見つかりません。");
		return mv;

	}

}
