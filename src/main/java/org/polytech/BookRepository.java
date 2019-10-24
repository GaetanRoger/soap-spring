package org.polytech;

import io.spring.guides.gs_producing_web_service.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class BookRepository {
    private static final Map<Integer, Book> books = new HashMap<>();

    @PostConstruct
    public void initData() {
        Book first = new Book();
        first.setId(1);
        first.setName("A Game of Thrones");
        first.setNumberOfPages(647);
        first.setPublisher("Bantam Books");
        books.put(1, first);

        Book second = new Book();
        second.setId(2);
        second.setName("A Clash of Kings");
        first.setPublisher("Bantam Books");
        second.setNumberOfPages(768);
        books.put(2, second);

        Book third = new Book();
        third.setId(3);
        third.setName("A Storm of Swords");
        first.setPublisher("Bantam Books");
        third.setNumberOfPages(992);
        books.put(3, third);
    }

    public Book findBook(int id) {

        final Book book = books.get(id);

        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        return book;
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
