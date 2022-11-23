package com.fronchak.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fronchak.domain.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}
