package by.godev.book_info.dao;

import by.godev.book_info.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public BookDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Book> getAllBook() {
        Session session = sessionFactory.getCurrentSession();

        Query<Book> query = session.createQuery("from Book", Book.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Book getBook(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Book.class, id);
    }

    @Override
    @Transactional
    public void saveNewEmployee(Book book) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Book> query = session.createQuery("delete from Book where id=:bookId");
        query.setParameter("bookId", id);

        query.executeUpdate();
    }
}
