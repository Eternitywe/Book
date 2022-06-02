package com.qiu.repository;

import com.qiu.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void test(){
        bookRepository.findAll().forEach(System.out::println);
    }

    @Test
    void save(){
        Book book = new Book();
        book.setName("Java");
        book.setAuthor("张三");
        book.setPublish("李四出版社");
        book.setPrice(200.0F);
        book.setPages(200);
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }
}