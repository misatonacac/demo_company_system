package com.example.todolist.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.example.todolist.entity.BumonSelect;

import lombok.Data;

@Data
public class BumonForm {
	private String bumon_id;
	private String bumon_name;
	private Long display_order;
	private String apply_start_date;
	private String apply_end_date;
	private String create_date;
	private String create_user;
	private String last_update_date;
	private String last_update_user;

	
	
	public BumonSelect toEntity() {
		BumonSelect bumonSelect = new BumonSelect();
		bumonSelect.setBumon_id(bumon_id);
		bumonSelect.setBumon_name(bumon_name);
		bumonSelect.setDisplay_order(display_order);
		bumonSelect.setCreate_user(create_user);
		bumonSelect.setLast_update_user(last_update_user);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd");

		if (apply_start_date == null || apply_start_date.isBlank()) {
			bumonSelect.setApply_start_date(null);
		} else {
			try {
				bumonSelect.setApply_start_date(LocalDate.parse(apply_start_date, formatter));
			} catch (DateTimeParseException e) {
				bumonSelect.setApply_start_date(null);
			}
		}

		if (apply_end_date == null || apply_end_date.isBlank()) {
			bumonSelect.setApply_end_date(null);
		} else {
			try {
				bumonSelect.setApply_end_date(LocalDate.parse(apply_end_date, formatter));
			} catch (DateTimeParseException e) {
				bumonSelect.setApply_end_date(null);
			}
		}
		if (create_date == null || create_date.isBlank()) {
			bumonSelect.setApply_end_date(null);
		} else {
			try {
				bumonSelect.setCreate_date(LocalDate.parse(create_date, formatter));
			} catch (DateTimeParseException e) {
				bumonSelect.setCreate_date(null);
			}
		}
		if (last_update_date == null || last_update_date.isBlank()) {
			bumonSelect.setApply_end_date(null);
		} else {
			try {
				bumonSelect.setLast_update_date(LocalDate.parse(last_update_date, formatter));
			} catch (DateTimeParseException e) {
				bumonSelect.setLast_update_date(null);
			}
		}
		
		

		return bumonSelect;
	}

}
