package com.example.spring5webapplication.repositories;

import com.example.spring5webapplication.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
