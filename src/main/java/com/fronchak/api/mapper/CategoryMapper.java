package com.fronchak.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fronchak.api.vo.category.CategoryInsertV1VO;
import com.fronchak.api.vo.category.CategoryV1VO;
import com.fronchak.domain.entities.Category;

@Service
public class CategoryMapper {

	public Category convertInsertVOToEntity(CategoryInsertV1VO insertVO) {
		Category entity = new Category();
		entity.setName(insertVO.getName());
		entity.setDescription(insertVO.getDescription());
		return entity;
	}
	
	public CategoryV1VO convertEntityToVO(Category entity) {
		CategoryV1VO vo = new CategoryV1VO();
		vo.setId(entity.getId());
		vo.setName(entity.getName());
		vo.setDescription(entity.getDescription());
		return vo;
	}
	
	public Category convertV1VOToEntity(CategoryV1VO vo) {
		Category entity = new Category();
		entity.setId(vo.getId());
		entity.setName(vo.getName());
		entity.setDescription(vo.getDescription());
		return entity;
	}
	
	public List<CategoryV1VO> convertEntityListToV1VOList(List<Category> entities) {
		return entities.stream()
				.map((entity) -> convertEntityToVO(entity))
				.collect(Collectors.toList());
	}
}
