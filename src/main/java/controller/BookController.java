package controller;

import domain.Book;
import domain.Category;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookServie;
import validator.BookValidator;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookServie bookService;

    private static final Log logger = LogFactory.getLog(BookController.class);

    @RequestMapping("/input-book")
    public String inputBook(Model model) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "BookAddForm";
    }

    @RequestMapping("/edit-book/{id}")
    public String editBook(Model model, @PathVariable long id) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "BookEditForm";
    }

    @RequestMapping("/save-book")
    public String saveBook(@ModelAttribute Book book, BindingResult bindingResult,Model model) {
        BookValidator bookValidator = new BookValidator();
        bookValidator.validate(book,bindingResult);
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.debug("Code: " + fieldError.getCode() + ", field: " + fieldError.getField());
            List<Category> categories = bookService.getAllCategories();
            model.addAttribute("categories", categories);
            return "BookEditForm";
        }
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/list-book";
    }

    @RequestMapping("/update-book")
    public String updateBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/list-book";
    }

    @RequestMapping("/list-book")
    public String listBooks(Model model) {
        logger.info("listBooks");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "BookList";
    }
}
