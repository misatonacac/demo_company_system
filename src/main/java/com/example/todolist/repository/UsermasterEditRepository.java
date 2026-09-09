package com.example.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.todolist.entity.UsermasterEdit;


@Repository
public interface UsermasterEditRepository extends JpaRepository<UsermasterEdit, String> {
	@Query("SELECT u FROM  UsermasterEdit u WHERE u.user_id = :user_id")
    List<UsermasterEdit> findByUser_id(@Param("user_id") String user_id);

	
}


