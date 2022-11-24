package com.fronchak.api.mapper;

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
}
