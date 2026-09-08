package com.example.todolist.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.validation.constraints.NotBlank;

import com.example.todolist.entity.UsermasterEdit;

import lombok.Data;
@Data
public class UsermasterData {
	
	@NotBlank(message = "ユーザーIDを入力してください。")
	private String user_id;
	@NotBlank(message = "ユーザー名を入力してください。")
	private String user_name;
	
	private String apply_start_date;
	private String apply_end_date;
	private String bumon_id;
	private String buten_id;
	private String group_id;
	private String kenin_user_id;
	private Integer kenin_status;
	private String touroku_user_id;
	private String note;
	private Boolean role02_flg;
	private Boolean role08_flg;
	private Boolean role09_flg;
	private Boolean role12_flg;
	private Boolean role03_flg;
	private Boolean role04_flg;
	private Boolean role05_flg;
	private Boolean role06_flg;
	private Boolean role07_flg;
	private Boolean role11_flg;
	private Boolean role13_flg;
	
	
	
	public UsermasterEdit toEntity() {
		UsermasterEdit usermasterEdit = new UsermasterEdit();
		usermasterEdit.setUser_id(user_id);
		usermasterEdit.setUser_name(user_name);
		usermasterEdit.setBumon_id(bumon_id);
		usermasterEdit.setButen_id(buten_id);
		usermasterEdit.setGroup_id(group_id);
		
		usermasterEdit.setKenin_user_id(kenin_user_id);
		usermasterEdit.setKenin_status(kenin_status);
		usermasterEdit.setTouroku_user_id(touroku_user_id);
		usermasterEdit.setRole02_flg(role02_flg);
		usermasterEdit.setRole08_flg(role08_flg);
		usermasterEdit.setRole09_flg(role09_flg);
		usermasterEdit.setRole12_flg(role12_flg);
		usermasterEdit.setRole03_flg(role03_flg);
		usermasterEdit.setRole04_flg(role04_flg);
		usermasterEdit.setRole05_flg(role05_flg);
		usermasterEdit.setRole06_flg(role06_flg);
		usermasterEdit.setRole07_flg(role07_flg);
		usermasterEdit.setRole11_flg(role11_flg);
		usermasterEdit.setRole12_flg(role12_flg);
		usermasterEdit.setRole13_flg(role13_flg);
		usermasterEdit.setNote(note);
		
		
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		if (apply_start_date == null || apply_start_date.isBlank()) {
		    usermasterEdit.setApply_start_date(null);
		} else {
		    try {
		        usermasterEdit.setApply_start_date(LocalDate.parse(apply_start_date, formatter));
		    } catch (DateTimeParseException e) {
		        usermasterEdit.setApply_start_date(null);
		    }
		}

		if (apply_end_date == null || apply_end_date.isBlank()) {
		    usermasterEdit.setApply_end_date(null);
		} else {
		    try {
		        usermasterEdit.setApply_end_date(LocalDate.parse(apply_end_date, formatter));
		    } catch (DateTimeParseException e) {
		        usermasterEdit.setApply_end_date(null);
		    }
		}
		
		return usermasterEdit;
	}

}
