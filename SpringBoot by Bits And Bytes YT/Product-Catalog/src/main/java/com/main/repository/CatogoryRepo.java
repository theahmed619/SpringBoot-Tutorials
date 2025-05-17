package com.main.repository;

import com.main.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatogoryRepo extends JpaRepository<Category, Long> {
}
