package com.example.todo;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
 public List<Todo> getAllTodos(){
	return todoService.getAllTodos();
 }

	 @PostMapping
	 public void addNewItem(@RequestBody Todo todo) {
			todoService.addTodo(todo);
	 }
 }