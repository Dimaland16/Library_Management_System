package com.dimaland.library_management_system.controller;

import com.dimaland.library_management_system.service.BookService;
import com.dimaland.library_management_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public CategoryController(CategoryService categoryService, BookService bookService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @GetMapping("/{categoryId}")
    public String showBooksByCategory(@PathVariable int categoryId, Model model) {
        model.addAttribute("books", bookService.findByCategoryId(categoryId));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("selectedCategoryId", categoryId);
        return "book/books";
    }

}
