package by.godev.book_info.controller;

import by.godev.book_info.entity.Book;
import by.godev.book_info.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {

    private AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping("/")
    public String getAllBooks(Model model) {

        List<Book> bookList = appService.getAllBook();

        model.addAttribute("allBook", bookList);

        return "all-books";
    }

    @RequestMapping("/add-book")
    public String addNewBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-book";
        }

        appService.saveNewEmployee(book);

        return "redirect:/";
    }

    @RequestMapping("/delete-book")
    public String deleteBook(@RequestParam("bookId") int id) {

        appService.deleteBook(id);

        return "redirect:/";
    }

}
