package com.dimaland.library_management_system.repository;

import com.dimaland.library_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByCategoriesId(Integer categoryId);
    List<Book> findByTitleContainingIgnoreCaseAndCategoriesId(String title, Integer categoryId);
}
