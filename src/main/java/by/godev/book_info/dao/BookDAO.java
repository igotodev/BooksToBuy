package by.godev.book_info.dao;

import by.godev.book_info.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAllBook();
    Book getBook(int id);
    void saveNewEmployee(Book book);
    void deleteBook(int id);
}
