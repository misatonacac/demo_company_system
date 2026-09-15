package com.example.todolist.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;


@Entity
@Table(name="tm_bumon")
@Data

public class BumonSelect {

	
	@Id
	@Column(name="bumon_id")
	private String bumon_id;
	@Column(name="bumon_name")
	private String bumon_name;
	@Column(name="display_order")
	private Long display_order;
	@Column(name="apply_start_date")
	private LocalDate apply_start_date;
	@Column(name="apply_end_date")
	private LocalDate apply_end_date;
	@Column(name="create_date")
	private LocalDate create_date;
	@Column(name="create_user")
	private String create_user;
	@Column(name="last_update_date")
	private LocalDate last_update_date;
	@Column(name="last_update_user")
	private String last_update_user;

}
