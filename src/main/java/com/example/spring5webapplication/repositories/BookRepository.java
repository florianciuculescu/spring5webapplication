package com.example.spring5webapplication.repositories;

import com.example.spring5webapplication.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
