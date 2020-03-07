package com.example.webappdemo.repositories;

import com.example.webappdemo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
