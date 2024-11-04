package com.dimaland.library_management_system.controller;

import com.dimaland.library_management_system.entity.Book;
import com.dimaland.library_management_system.service.BookService;
import com.dimaland.library_management_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("selectedCategoryId", null);
        return "book/books";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam("title") String title,
                              @RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Model model) {

        model.addAttribute("books", bookService.searchBooks(title, categoryId));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("search", title);
        model.addAttribute("selectedCategoryId", categoryId);
        return "book/books";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "book/details";
    }

    @GetMapping("/new")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/book_add_form";
    }

    @PostMapping("/new")
    public String createBook(Book book, @RequestParam("authorNames") List<String> authorNames,
                             @RequestParam("publisherName") String publisherName) {

        bookService.saveBook(book, authorNames, publisherName);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/edit";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, Book book,
                             @RequestParam("authorNames") List<String> authorNames,
                             @RequestParam("publisher.name") String publisherName) {

        bookService.updateBook(book, authorNames, publisherName, id);
        return "redirect:/books/" + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

}
