package com.example.spring5webapplication.bootstrap;

import com.example.spring5webapplication.domain.Author;
import com.example.spring5webapplication.domain.Book;
import com.example.spring5webapplication.repositories.AuthorRepository;
import com.example.spring5webapplication.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author rowling = new Author("JK","Rowling");
        Book harryPotter = new Book("Harry Potter","123123");
        rowling.getBooks().add(harryPotter);
        harryPotter.getAuthors().add(rowling);

        authorRepository.save(rowling);
        bookRepository.save(harryPotter);

        Author creanga = new Author("Ion","Creanga");
        Book amintiri = new Book("Amintiri din Copilarie","222222");

        authorRepository.save(creanga);
        bookRepository.save(amintiri);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
