package com.demo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.todo.domain.TodoTask;
import com.demo.todo.domain.UserTask;
import com.demo.todo.model.UserTaskModel;
import com.demo.todo.service.TodoTaskService;

@RestController
public class TaskController {

	@Autowired
	private TodoTaskService taskService;

	@GetMapping("/taskList")
	public List<TodoTask> todoTasks() {

		return taskService.getTasksList();
	}
	
	@GetMapping("/task/{taskId}")
	public TodoTask todoTask(@PathVariable Long taskId) {

		return taskService.getTaskbyId(taskId);
	}

	@GetMapping("/taskListByUser/{userId}")
	public List<TodoTask> getTasksbyUser(@PathVariable String userId) {

		return taskService.getTasksByUser(userId);
	}

	@PostMapping(value = "/task/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TodoTask> createTask(@RequestBody TodoTask task) {
		task = taskService.saveTask(task);
		return new ResponseEntity<TodoTask>(task, HttpStatus.CREATED);
	}

	@PutMapping(value = "/task/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TodoTask> updateTask(@RequestBody TodoTask task) {
		task = taskService.updateTask(task);
		return new ResponseEntity<TodoTask>(task, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/task/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTask(@RequestBody TodoTask task) {
		taskService.deleteTask(task);
	}
	
	@PostMapping(value = "/userTask/create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserTask> createUserTask(@RequestBody UserTaskModel userTaskModel) {
		UserTask userTask = taskService.createUserTask(userTaskModel);
		return new ResponseEntity<UserTask>(userTask, HttpStatus.CREATED);
	}

	@PutMapping(value = "/userTask/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserTask> updateUserTask(@RequestBody UserTaskModel userTaskModel) {
		UserTask userTask = taskService.updateUserTask(userTaskModel);
		return new ResponseEntity<UserTask>(userTask, HttpStatus.CREATED);
	}

	@DeleteMapping(value="/userTask/Delete")
	public void deleteUserTask(@RequestBody UserTaskModel userTaskModel) {
		taskService.deleteUserTask(userTaskModel);
	}
}
