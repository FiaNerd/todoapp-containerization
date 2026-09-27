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

	public Todo addTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	public Todo getTodoById(Long id) {
		return todoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(id + " not found"));
	}

	public Todo updateTodoById(Todo newTodoData, Long id) {
		Todo existingTodo = getTodoById(id);

		if (newTodoData.getTitle() != null) {
			existingTodo.setTitle(newTodoData.getTitle());
		}

		existingTodo.setCompleted(newTodoData.isCompleted());

		return todoRepository.save(existingTodo);
	}
	public void deleteItem(Long id){
		Todo todoItem = todoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(id + " not found"));

		todoRepository.delete(todoItem);
	}
}