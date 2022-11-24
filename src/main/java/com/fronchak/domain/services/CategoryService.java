package com.fronchak.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fronchak.domain.entities.Category;
import com.fronchak.domain.exceptions.ResourceNotFoundException;
import com.fronchak.domain.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category save(Category category) {
		return repository.save(category);
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("There is no category saved with this ID: " + id));
	}
	
	public Category update(Category category) {
		return repository.save(category);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
