package com.demo.todo.service;

import java.util.List;

import com.demo.todo.domain.TodoTask;
import com.demo.todo.domain.UserTask;
import com.demo.todo.model.UserTaskModel;


public interface TodoTaskService {

	List<TodoTask> getTasksList();

	List<TodoTask> getTasksByUser(String userId);

	TodoTask saveTask(TodoTask task);
	
	TodoTask updateTask(TodoTask task);

	UserTask createUserTask(UserTaskModel userTask);

	UserTask updateUserTask(UserTaskModel userTask);

}
