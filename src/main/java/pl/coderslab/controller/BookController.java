package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") long id) {
        return memoryBookService.getBook(id);
    }

    /*
    request body for postman:
    {"id":1,"isbn":"1234567891123", "title":"title11", "author":"author11", "publisher":"publisher11", "type":"type11"}
    */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void addBook(@RequestBody(required = true) Book book) {
        memoryBookService.addBook(book);
    }

    /* // another addBook method
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void addBook(@RequestParam(name = "isbn", required = false) String isbn,
                        @RequestParam(name = "title", required = false) String title,
                        @RequestParam(name = "author", required = false) String author,
                        @RequestParam(name = "publisher", required = false) String publisher,
                        @RequestParam(name = "type", required = false) String type) {
        memoryBookService.addBook(isbn, title, author, publisher, type);
    }
    */
}
