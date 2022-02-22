package com.demo.todo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.todo.domain.TodoTask;
import com.demo.todo.domain.UserTask;
import com.demo.todo.model.UserTaskModel;
import com.demo.todo.repository.TodoTaskRepository;
import com.demo.todo.repository.TodoUserRepository;
import com.demo.todo.repository.UserTaskRepository;

@Service
public class TodoTaskServiceImpl implements TodoTaskService {

	@Autowired
	TodoTaskRepository taskRepository;

	@Autowired
	TodoUserRepository userRepository;

	@Autowired
	UserTaskRepository userTaskRepository;

	@Override
	public TodoTask getTaskbyId(Long taskId) {
		return taskRepository.findById(taskId).orElse(null);
	}

	@Override
	public List<TodoTask> getTasksList() {
		return taskRepository.findAll();
	}

	@Override
	public List<TodoTask> getTasksByUser(String userId) {
		List<TodoTask> tasks = taskRepository.findTasksByUserId(Long.valueOf(userId));
		// List<TodoTask> tasks =
		// userTaskList.stream().map(UserTask::getTask).collect(Collectors.toList());
		return tasks;
	}

	@Override
	public TodoTask saveTask(TodoTask task) {
		task.setCreatedDate(LocalDateTime.now());
		return taskRepository.save(task);
	}

	@Override
	public TodoTask updateTask(TodoTask todoTask) {
		TodoTask task = taskRepository.findById(todoTask.getId()).orElse(null);
		task.setUpdatedDate(LocalDateTime.now());
		return taskRepository.save(task);
	}
	
	@Override
	public void deleteTask(TodoTask todoTask) {
		TodoTask task = taskRepository.findById(todoTask.getId()).orElse(null);
		taskRepository.delete(task);
	}

	@Override
	public UserTask createUserTask(UserTaskModel userTaskModel) {
		UserTask userTask = new UserTask();
		TodoTask task = taskRepository.findById(Long.valueOf(userTaskModel.getTaskId())).orElse(null);
		userTask.setTask(task);
		userTask.setUser(userRepository.findById(Long.valueOf(userTaskModel.getUserId())).orElse(null));
		return userTaskRepository.save(userTask);
	}

	@Override
	public UserTask updateUserTask(UserTaskModel userTaskModel) {
		UserTask userTask = new UserTask();
		TodoTask task = taskRepository.getById(Long.valueOf(userTaskModel.getTaskId()));
		userTask.setTask(task);
		userTask.setUser(userRepository.getById(Long.valueOf(userTaskModel.getUserId())));
		userTask = userTaskRepository.save(userTask);

		// update todo task
		task.setUpdatedDate(LocalDateTime.now());
		return userTask;
	}

	@Override
	public void deleteUserTask(UserTaskModel userTaskModel) {
		UserTask userTask = userTaskRepository.findByUserTaskId(Long.valueOf(userTaskModel.getTaskId()),
				Long.valueOf(userTaskModel.getUserId()));
		userTaskRepository.delete(userTask);
	}

}
