package com.fronchak.api.vo.category;

import javax.validation.constraints.NotNull;

public class CategoryV1VO extends CategoryInsertV1VO {

	@NotNull(message = "Category ID cannot be null")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
