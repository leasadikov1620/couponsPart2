package com.lea.couponsPart2Spring.repositories;

import com.lea.couponsPart2Spring.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
