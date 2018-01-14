package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryBookService {
    private Map<Long, Book> list;

    public MemoryBookService() {
        list = new HashMap<Long, Book>();
        list.put(1l, new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.put(2l, new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.put(3L, new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public Map<Long, Book> getList() {
        return list;
    }

    public void setList(Map<Long, Book> list) {
        this.list = list;
    }

    public Book getBook(long id) {
        if (id > 0 && list.size() >= id) {
            return list.get(id);
        }
        return null;
    }

    public void editBook(Book book) {
        if (book != null && book.getId() > 0) {
            if (list.get(book.getId()) != null) {
                list.replace(book.getId(), book);
            }
        }
    }

    public void deleteBook(long id) {
        if (id > 0 && list.get(id) != null) {
            list.remove(id);
        }
    }
}
