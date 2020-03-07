package com.example.webappdemo.repositories;

import com.example.webappdemo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
