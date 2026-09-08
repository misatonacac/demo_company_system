package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.entity.UsermasterEdit;


@Repository
public interface UsermasterEditRepository extends JpaRepository<UsermasterEdit, String> {

}
