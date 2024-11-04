package com.dimaland.library_management_system.initializer;

import com.dimaland.library_management_system.entity.Category;
import com.dimaland.library_management_system.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final CategoryRepository categoryRepository;

    @Autowired
    public DataInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {
        if (categoryRepository.count() == 0) {
            categoryRepository.saveAll(List.of(
                    new Category("Fiction"),
                    new Category("Non-Fiction"),
                    new Category("Science Fiction"),
                    new Category("Fantasy"),
                    new Category("Mystery"),
                    new Category("Biography")
            ));
        }
    }
}