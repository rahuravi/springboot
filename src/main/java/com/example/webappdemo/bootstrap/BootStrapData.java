package com.example.webappdemo.bootstrap;

import com.example.webappdemo.domain.Author;
import com.example.webappdemo.domain.Book;
import com.example.webappdemo.domain.Publisher;
import com.example.webappdemo.repositories.AuthorRepository;
import com.example.webappdemo.repositories.BookRepository;
import com.example.webappdemo.repositories.PublisherRepository;
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

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book bbb = new Book("DSA", "12345657");
        eric.getBooks().add(bbb);
        bbb.getAuthors().add(eric);

        bbb.setPublisher(publisher);
        publisher.getBooks().add(bbb);

        authorRepository.save(eric);
        bookRepository.save(bbb);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book bk = new Book("Learn Spring Boot", "9876543");
        rod.getBooks().add(bk);
        bk.getAuthors().add(rod);

        bk.setPublisher(publisher);
        publisher.getBooks().add(bk);

        authorRepository.save(rod);
        bookRepository.save(bk);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Publishre Number of books: " + publisher.getBooks().size());
    }
}
