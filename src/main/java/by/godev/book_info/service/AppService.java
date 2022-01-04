package by.godev.book_info.service;

import by.godev.book_info.entity.Book;

import java.util.List;

public interface AppService {
    List<Book> getAllBook();
    Book getBook(int id);
    void saveNewEmployee(Book book);
    void deleteBook(int id);
}
