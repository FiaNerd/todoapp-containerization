package com.example.todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class TodoController {
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	 public List<Todo> getAllTodos(){
		return todoService.getAllTodos();
	 }

	@GetMapping("/{id}")
	public ResponseEntity<?> getItemById(@PathVariable Long id){
		try {
			Todo todo = todoService.getTodoById(id);
			return ResponseEntity.ok(todo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> addNewItem(@RequestBody Todo todo) {
		try {
			Todo savedTodo = todoService.addTodo(todo);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
		} catch (Exception e) {
			// Om något går fel vid sparandet (t.ex. dubblett eller ogiltig data)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> updateItemById(@RequestBody Todo todo, @PathVariable Long id){
		try {
			Todo updatedTodo = todoService.updateTodoById(todo, id);
			return ResponseEntity.ok(updatedTodo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable Long id){
		try {
			todoService.deleteItem(id);
			return ResponseEntity.ok("Deleted!"); // 200 OK
		} catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // 404 Not Found
		}
	}
 }