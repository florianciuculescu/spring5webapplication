package com.example.spring5webapplication.repositories;

import com.example.spring5webapplication.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
