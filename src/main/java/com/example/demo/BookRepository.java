package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

    Iterable findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);
}
