package com.fronchak.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fronchak.domain.entities.Category;
import com.fronchak.domain.exceptions.ResourceNotFoundException;
import com.fronchak.domain.exceptions.ValidationException;
import com.fronchak.domain.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category save(Category category) {
		validateThatThereIsNoOtherCategoryWithTheSameNameSaved(category);
		return repository.save(category);
	}
	
	private void validateThatThereIsNoOtherCategoryWithTheSameNameSaved(Category category) {
		if(thereIsAnotherCategoryWithTheSameName(category)) {
			throw new ValidationException("Already exist one category saved with the same name");
		}
	}
	
	private boolean thereIsAnotherCategoryWithTheSameName(Category category) {
		List<Category> categories = findAll();
		return categories.stream().anyMatch((entity) -> categoriesNameAreTheSame(entity, category));
	}
	
	private boolean categoriesNameAreTheSame(Category source, Category target) {
		return source.getName().equals(target.getName());
	}
	
	private boolean categoriesNameAreNotTheSame(Category source, Category target) {
		return !categoriesNameAreTheSame(source, target);
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("There is no category saved with this ID: " + id));
	}
	
	public Category update(Category category) {
		Category entity = findById(category.getId());
		if(categoriesNameAreNotTheSame(entity, category)) {
			validateThatThereIsNoOtherCategoryWithTheSameNameSaved(category);
		}
		return repository.save(category);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
