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

import com.fronchak.api.mapper.CategoryMapper;
import com.fronchak.api.vo.category.CategoryInsertV1VO;
import com.fronchak.api.vo.category.CategoryV1VO;
import com.fronchak.domain.entities.Category;
import com.fronchak.domain.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@Autowired
	private CategoryMapper mapper;
	
	@PostMapping(value = "/v1")
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryV1VO save(@RequestBody CategoryInsertV1VO insertV1VO) {
		Category category = mapper.convertInsertVOToEntity(insertV1VO);
		Category entity = service.save(category);
		CategoryV1VO vo = mapper.convertEntityToVO(entity);
		return vo;
	}
	
	@GetMapping(value = "/v1/{id}")
	public CategoryV1VO findById(@PathVariable(name = "id") Long id) {
		Category entity = service.findById(id);
		CategoryV1VO vo = mapper.convertEntityToVO(entity);
		return vo;
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
