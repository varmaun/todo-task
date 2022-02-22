package com.demo.todo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.todo.domain.TodoTask;

@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, Serializable>{

	@Query("SELECT DISTINCT task FROM TodoTask task JOIN task.userTasks ut WHERE ut.task.id = task.id AND ut.user.id = ?1")
	List<TodoTask> findTasksByUserId(Long userId);

}
