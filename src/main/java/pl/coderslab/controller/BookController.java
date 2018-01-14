package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public Map<Long, Book> getList() {
        return memoryBookService.getList();
    }
}
