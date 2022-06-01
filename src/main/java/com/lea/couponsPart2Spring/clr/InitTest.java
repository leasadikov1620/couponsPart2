package com.lea.couponsPart2Spring.clr;

import com.lea.couponsPart2Spring.beans.Categories;
import com.lea.couponsPart2Spring.beans.Category;
import com.lea.couponsPart2Spring.repositories.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class InitTest implements CommandLineRunner {
    private final CategoryRepo categoryRepo;

    @Override
    public void run(String... args) throws Exception {
        addCategories();
    }

    private void addCategories() {
        categoryRepo.save(Category.builder().title(Categories.FOOD).build());
        categoryRepo.save(Category.builder().title(Categories.ELECTRICITY).build());
        categoryRepo.save(Category.builder().title(Categories.RESTAURANT).build());
        categoryRepo.save(Category.builder().title(Categories.VACATION).build());
    }

}
