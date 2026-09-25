package com.example.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
	private final TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> getAllTodos(){
		return todoRepository.findAll();
	}

	// Se till att namnet matchar det du anropar i controllern!
	public void addTodo(Todo todo) {
		todoRepository.save(todo);
	}
}