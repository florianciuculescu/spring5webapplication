package com.example.spring5webapplication.bootstrap;

import com.example.spring5webapplication.domain.Author;
import com.example.spring5webapplication.domain.Book;
import com.example.spring5webapplication.domain.Publisher;
import com.example.spring5webapplication.repositories.AuthorRepository;
import com.example.spring5webapplication.repositories.BookRepository;
import com.example.spring5webapplication.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher("Arion","Zambilelor","Bucuresti","Romania","123221");
        publisherRepository.save(publisher);
        System.out.println("Number of Publishers: " + publisherRepository.count());

        Author rowling = new Author("JK","Rowling");
        Book harryPotter = new Book("Harry Potter","123123");
        rowling.getBooks().add(harryPotter);
        harryPotter.getAuthors().add(rowling);

        harryPotter.setPublisher(publisher);
        publisher.getBooks().add(harryPotter);

        authorRepository.save(rowling);
        bookRepository.save(harryPotter);

        Author creanga = new Author("Ion","Creanga");
        Book amintiri = new Book("Amintiri din Copilarie","222222");

        amintiri.setPublisher(publisher);
        publisher.getBooks().add(amintiri);

        authorRepository.save(creanga);
        bookRepository.save(amintiri);



        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
