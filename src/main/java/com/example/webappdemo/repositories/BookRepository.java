package com.example.webappdemo.repositories;

import com.example.webappdemo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
