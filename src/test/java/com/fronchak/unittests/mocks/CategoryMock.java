package com.fronchak.unittests.mocks;

import com.fronchak.api.vo.category.CategoryInsertV1VO;
import com.fronchak.api.vo.category.CategoryV1VO;
import com.fronchak.domain.entities.Category;

public class CategoryMock {

	public Category mockCategory() {
		return mockCategory(0);
	}
	
	public Category mockCategory(int number) {
		Category category = new Category();
		category.setId(mockId(number));
		category.setName(mockName(number));
		category.setDescription(mockDescription(number));
		return category;
	}
	
	private Long mockId(int number) {
		return number + 0L;
	}
	
	private String mockName(int number) {
		return "Name Test " + number;
	}
	
	private String mockDescription(int number) {
		return "Description Test " + number;
	}
	
	public CategoryInsertV1VO mockInsertV1VO() {
		return mockInsertV1VO(0);
	}
	
	public CategoryInsertV1VO mockInsertV1VO(int number) {
		CategoryInsertV1VO insertVO = new CategoryInsertV1VO();
		insertVO.setName(mockName(number));
		insertVO.setDescription(mockDescription(number));
		return insertVO;
	}
	
	public CategoryV1VO mockCategoryV1VO() {
		return mockCategoryV1VO(0);
	}
	
	public CategoryV1VO mockCategoryV1VO(int number) {
		CategoryV1VO vo = new CategoryV1VO();
		vo.setId(mockId(number));
		vo.setName(mockName(number));
		vo.setDescription(mockDescription(number));
		return vo;
	}
}
