package com.example.todolist.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.todolist.converter.OneZeroConverter;

import lombok.Data;

@Entity
@Table(name="tm_user")
@Data
public class UsermasterEdit {
	
	@Id
	@Column(name="user_id")
	private String user_id;
	@Column(name="user_name")
	private String user_name;
	@Column(name="bumon_id")
	private String bumon_id;
	@Column(name="buten_id")
	private String buten_id;
	@Column(name="group_id")
	private String group_id;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role01_flg")
	private Boolean role01_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role02_flg")
	private Boolean role02_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role03_flg")
	private Boolean role03_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role04_flg")
	private Boolean role04_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role05_flg")
	private Boolean role05_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role06_flg")
	private Boolean role06_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role07_flg")
	private Boolean role07_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role08_flg")
	private Boolean role08_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role09_flg")
	private Boolean role09_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role10_flg")
	private Boolean role10_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role11_flg")
	private Boolean role11_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role12_flg")
	private Boolean role12_flg;
	@Convert(converter = OneZeroConverter.class)
	@Column(name="role13_flg")
	private Boolean role13_flg;
	@Column(name="password_bk1")
	private String password_bk1;
	@Column(name="password_bk2")
	private String password_bk2;
	@Column(name="change_password_date")
	private LocalDate change_password_date;
	@Column(name="touroku_user_id")
	private String touroku_user_id;
	@Column(name="kenin_user_id")
	private String kenin_user_id;
	@Column(name="kenin_status")
	private Integer kenin_status;
	@Column(name="login_flg")
	private Integer login_flg;
	@Column(name="last_login_date")
	private LocalDate last_login_date;
	@Column(name="apply_start_date")
	private LocalDate apply_start_date;
	@Column(name="apply_end_date")
	private LocalDate apply_end_date;
	@Column(name="system_cd")
	private Integer system_cd;
	@Column(name="note")
	private String note;
	@Column(name="create_date")
	private LocalDate create_date;
	@Column(name="create_user")
	private String create_user;
	@Column(name="last_update_date")
	private LocalDate last_update_date;
	@Column(name="last_update_user")
	private String last_update_user;
	@Column(name="syain_no")
	private String syain_no;
	
	
}
