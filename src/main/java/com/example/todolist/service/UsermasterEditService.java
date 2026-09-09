package com.example.todolist.service;

import org.springframework.stereotype.Service;

import com.example.todolist.entity.UsermasterEdit;
import com.example.todolist.repository.UsermasterEditRepository;

@Service

public class UsermasterEditService {
	private final UsermasterEditRepository usermasterEditRepository;
	public UsermasterEditService (UsermasterEditRepository usermasterEditRepository) {
		this.usermasterEditRepository = usermasterEditRepository;
	}
	public UsermasterEdit findByUser_id (String user_id) {
		
		return usermasterEditRepository.findById(user_id).orElse(null);
	}
	

}
