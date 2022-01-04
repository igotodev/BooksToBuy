package by.godev.book_info.service;

import by.godev.book_info.entity.Book;
import by.godev.book_info.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    private BookDAO bookDAO;

    @Autowired
    public AppServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAllBook() {
        return bookDAO.getAllBook();
    }

    @Override
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    public void saveNewEmployee(Book book) {
        bookDAO.saveNewEmployee(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
