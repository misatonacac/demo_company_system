package com.example.todolist.service;

import java.util.List;

import com.example.todolist.entity.BumonSelect;
import com.example.todolist.repository.BumonSelectRepository;

public class BumonSelectService {
	private final BumonSelectRepository bumonSelectRepository;
	public BumonSelectService (BumonSelectRepository bumonSelectRepository) {
		this.bumonSelectRepository = bumonSelectRepository;
	}
	public List<BumonSelect> findAll () {
		
		return bumonSelectRepository.findAll();
	}
	
	

}

