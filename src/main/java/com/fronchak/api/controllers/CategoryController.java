package com.fronchak.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fronchak.domain.entities.Category;
import com.fronchak.domain.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping(value = "/v1")
	@ResponseStatus(HttpStatus.CREATED)
	public Category save(@RequestBody Category category) {
		return service.save(category);
	}
	
	@GetMapping(value = "/v1/{id}")
	public Category findById(@PathVariable(name = "id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping(value = "/v1")
	public List<Category> findAll() {
		return service.findAll();
	}
	
	@PutMapping(value = "/v1")
	public Category update(@RequestBody Category category) {
		return service.update(category);
	}
	
	@DeleteMapping(value = "/v1/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
	}
	
}
