package com.example.todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@GetMapping
 public List<Todo> getTodos(){
	return List.of( new Todo(1L, "Buy Milk", "Shop", "Get the light version", false),
		 new Todo(2L, "Buy Chees", "Shop", "Gouda", false),
		 new Todo(3L, "Buy Meat", "Shop", "Chicken", true),
		 new Todo(3L, "Make the dishes", "Home", "Fix in the kitchen", false)
	);
 }
}