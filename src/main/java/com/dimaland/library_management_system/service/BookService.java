package com.dimaland.library_management_system.service;

import com.dimaland.library_management_system.entity.Author;
import com.dimaland.library_management_system.entity.Book;
import com.dimaland.library_management_system.entity.Publisher;
import com.dimaland.library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService, PublisherService publisherService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String title, Integer categoryId) {
        List<Book> books;

        if (categoryId != null) {
            books = this.findByTitleAndCategory(title, categoryId);
        } else {
            books = this.findByTitleContaining(title);
        }

        return books;
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void saveBook(Book book, List<String> authorNames, String publisherName) {
        Publisher publisher = publisherService.getByName(publisherName);
        if (publisher == null) {
            publisher = new Publisher();
            publisher.setName(publisherName);
            publisherService.savePublisher(publisher);
        }
        book.setPublisher(publisher);

        Set<Author> authors = new HashSet<>();
        for (String name : authorNames) {
            if (!name.trim().isEmpty()) {
                Author author = authorService.getByName(name);
                if (author == null) {
                    author = new Author();
                    author.setName(name);
                    authorService.saveAuthor(author);
                }
                authors.add(author);
            }
        }
        book.setAuthors(authors);

        this.saveBook(book);
    }

    public void updateBook(Book book, List<String> authorNames, String publisherName, int id) {

        Book existingBook = this.getBookById(id);

        existingBook.setTitle(book.getTitle());
        existingBook.setPublicationYear(book.getPublicationYear());
        existingBook.setPages(book.getPages());
        existingBook.setCategories(book.getCategories());

        this.saveBook(existingBook, authorNames, publisherName);
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByTitleContaining(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findByCategoryId(Integer categoryId) {
        return bookRepository.findByCategoriesId(categoryId);
    }

    public List<Book> findByTitleAndCategory(String title, int categoryId) {
        return bookRepository.findByTitleContainingIgnoreCaseAndCategoriesId(title, categoryId);
    }
}
