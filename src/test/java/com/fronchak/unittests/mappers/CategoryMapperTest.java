package com.fronchak.unittests.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fronchak.api.mapper.CategoryMapper;
import com.fronchak.api.vo.category.CategoryInsertV1VO;
import com.fronchak.api.vo.category.CategoryV1VO;
import com.fronchak.domain.entities.Category;
import com.fronchak.unittests.mocks.CategoryMock;

public class CategoryMapperTest {

	private CategoryMock mockFactory;
	private CategoryMapper mapper;
	
	@BeforeEach
	public void setUp() {
		mockFactory = new CategoryMock();
		mapper = new CategoryMapper();
	}
	
	@Test
	void testConvertInsertV1VOTOEntity() {
		CategoryInsertV1VO insertVO = mockFactory.mockInsertV1VO();
		Category result = mapper.convertInsertVOToEntity(insertVO);
		
		assertNull(result.getId());
		assertEquals("Name Test 0", result.getName());
		assertEquals("Description Test 0", result.getDescription());
	}
	
	@Test
	void testConvertEntityToV1VO() {
		Category entity = mockFactory.mockCategory();
		CategoryV1VO result = mapper.convertEntityToVO(entity);
		
		assertEquals(0, result.getId());
		assertEquals("Name Test 0", result.getName());
		assertEquals("Description Test 0", result.getDescription());
	}
}
