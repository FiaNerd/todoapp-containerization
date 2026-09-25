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

	@GetMapping("/{id}")
	public Todo getItemById(@PathVariable Long id){
		return todoService.getTodoById(id);
	}

	@PatchMapping("/{id}")
	public Todo updateItemById(@RequestBody Todo todo,@PathVariable Long id){
		return todoService.updateTodoById(todo, id);
	}

	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable Long id){
		todoService.deleteItem(id);
	}
 }