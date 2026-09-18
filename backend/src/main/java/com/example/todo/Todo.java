package com.example.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

public class Todo {

	private Long id;

	private String name;
	private String category;
	private String description;
	private boolean completed;

	public Todo() {
	}

	public Todo(Long id, String name, String category, String description, boolean completed) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Todo todo = (Todo) object;
		return completed == todo.completed
				&& Objects.equals(id, todo.id)
				&& Objects.equals(name, todo.name)
				&& Objects.equals(category, todo.category)
				&& Objects.equals(description, todo.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, category, description, completed);
	}
}