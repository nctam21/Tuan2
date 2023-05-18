package com.example.Tuan2.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Product> getProducts() {
//        List< Book> books = new ArrayList<>();
//
//        Book book1 =new Book();
//        book1.setId(1L);
//        book1.setTitle("Crypto Say");
//        book1.setAuthor("Nguyễn Huy Hải");
//        book1.setPrice(10.99);
//        book1.setCategory("Tài chính");
//        books.add(book1);
//
//        Book book2 =new Book();
//        book2.setId(2L);
//        book2.setTitle("Think Big");
//        book2.setAuthor("Nguyễn Chí Tâm");
//        book2.setPrice(12.99);
//        book2.setCategory("Tài chính");
//        books.add(book2);
//
//        Book book3 =new Book();
//        book3.setId(3L);
//        book3.setTitle("Lập trình web trên macbook");
//        book3.setAuthor("Nguyễn Chí Tâm");
//        book3.setPrice(9.99);
//        book3.setCategory("Công nghệ thông tin");
//        books.add(book3);
//        return books;

        List< Product> products = new ArrayList<>();
        Product product1 =new Product();
        product1.setId(1);
        product1.setName("Quang");
        product1.setImage("1.jpg");
        product1.setPrice(10);
        products.add(product1);

        Product product2 =new Product();
        product2.setId(2);
        product2.setName("Tam");
        product2.setImage("2.jpg");
        product2.setPrice(8);
        products.add(product2);
        return products;
    }
}