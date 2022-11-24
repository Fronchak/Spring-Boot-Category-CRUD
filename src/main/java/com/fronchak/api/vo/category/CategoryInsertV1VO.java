package com.fronchak.api.vo.category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryInsertV1VO {

	@NotBlank(message = "Category's name cannot be empty")
	@Size(max = 30, message = "Category's name should have less than 30 characters")
	private String name;
	
	@NotBlank(message = "Category's description cannot be empty")
	@Size(max = 30, message = "Category's description cannot have more than 255 characters")
	private String description;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
