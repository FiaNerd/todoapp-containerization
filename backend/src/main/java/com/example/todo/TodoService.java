package com.example.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

	public Todo getTodoById(Long id) {
		return todoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(id + "not found"));
	}

	public Todo updateTodoById(Todo todo, Long id) {
		Todo todoItem = todoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(id + "not found"));

		todoItem.setName(todo.getName());
		todoItem.setCategory(todo.getCategory());
		todoItem.setDescription(todo.getDescription());
		todoItem.setCompleted(todo.isCompleted());

		return todoRepository.save(todoItem);
	}

	public void deleteItem(Long id){
		Todo todoItem = todoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(id + "not found"));

		todoRepository.delete(todoItem);
	}
}