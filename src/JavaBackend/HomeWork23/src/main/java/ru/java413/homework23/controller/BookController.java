package ru.java413.homework23.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.java413.homework23.DTO.BookDto;
import ru.java413.homework23.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(@RequestParam(defaultValue = "default") String sort, Model model) {
        List<BookDto> books;

        switch (sort) {
            case "title":
                books = bookService.getBooksSortedByTitle();
                break;
            case "author":
                books = bookService.getBooksSortedByAuthor();
                break;
            case "read":
                books = bookService.getBooksSortedByReadStatus();
                break;
            default:
                books = bookService.getAllBooks();
        }

        model.addAttribute("books", books);
        model.addAttribute("bookDto", new BookDto());
        model.addAttribute("currentSort", sort);
        return "index";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute BookDto bookDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("books", bookService.getAllBooks());
            model.addAttribute("currentSort", "default");
            return "index";
        }

        bookService.createBook(bookDto);
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @PostMapping("/{id}/toggle-read")
    public String toggleReadStatus(@PathVariable Long id) {
        bookService.toggleReadStatus(id);
        return "redirect:/books";
    }
}
