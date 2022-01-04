package by.godev.book_info.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 2, max = 255, message = "Field name must be between 2 and 100 characters")
    @Column(name = "name")
    private String name;

    @Size(min = 2, max = 255, message = "Field author must be between 2 and 100 characters")
    @Column(name = "author")
    private String author;

    @Pattern(regexp = "[0-9]{3}[-][0-9][-][0-9]{2}[-][0-9]{6}[-][0-9]", message = "IBSN code must be XXX-X-XX-XXXXXX-X")
    @Column(name = "isbn")
    private String isbn;

    @Size(min = 2, max = 255, message = "Field publisher must be between 2 and 255 characters")
    @Column(name = "publisher")
    private String publisher;

    @Size(min = 2, max = 255, message = "Field genre must be between 2 and 255characters")
    @Column(name = "genre")
    private String genre;

    @Min(value = 0, message = "Min year is 0")
    @Max(value = 2050, message = "Max year is 2050")
    @Column(name = "year_of_publication")
    private int yearOfPublication;

    @Min(value = 1, message = "Min pages is 1")
    @Max(value = 50000, message = "Max pages is 50000")
    @Column(name = "pages")
    private int pages;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, isbn);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", pages=" + pages +
                '}';
    }
}
