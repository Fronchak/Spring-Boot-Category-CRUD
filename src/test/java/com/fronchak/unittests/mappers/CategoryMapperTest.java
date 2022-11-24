package com.fronchak.unittests.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

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
	
	@Test
	void testConvertV1VOToEntity() {
		CategoryV1VO vo = mockFactory.mockCategoryV1VO();
		Category result = mapper.convertV1VOToEntity(vo);
		
		assertEquals(0L, result.getId());
		assertEquals("Name Test 0", result.getName());
		assertEquals("Description Test 0", result.getDescription());
	}
	
	@Test
	void testConvertEntityListToV1VOList() {
		List<Category> entities = mockFactory.mockCategoryList();
		List<CategoryV1VO> voList = mapper.convertEntityListToV1VOList(entities);
		
		CategoryV1VO result0 = voList.get(0);
		assertEquals(0L, result0.getId());
		assertEquals("Name Test 0", result0.getName());
		assertEquals("Description Test 0", result0.getDescription());
		
		CategoryV1VO result1 = voList.get(1);
		assertEquals(1L, result1.getId());
		assertEquals("Name Test 1", result1.getName());
		assertEquals("Description Test 1", result1.getDescription());
		
		CategoryV1VO result4 = voList.get(4);
		assertEquals(4L, result4.getId());
		assertEquals("Name Test 4", result4.getName());
		assertEquals("Description Test 4", result4.getDescription());
	}
}
