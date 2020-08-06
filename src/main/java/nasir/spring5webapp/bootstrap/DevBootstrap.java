package nasir.spring5webapp.bootstrap;

import nasir.spring5webapp.model.Author;
import nasir.spring5webapp.model.Book;
import nasir.spring5webapp.model.Publisher;
import nasir.spring5webapp.repositories.AuthorRepository;
import nasir.spring5webapp.repositories.BookRepository;
import nasir.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

// add a spring component to save this and makes it a spring bean
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData(){
        Author eric = new Author("Eric", "Evans");
        Publisher publisher = new Publisher();
        publisher.setName("Hillary");
        publisher.setAddress("HighWaters");
        publisherRepository.save(publisher);
        Book ddd = new Book("Domain Driven Design","1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher publisher1 = new Publisher();
        publisher1.setName("William");
        publisher1.setAddress("HighWaters");
        publisherRepository.save(publisher1);
        Book noEJB = new Book("Java without EJB","1233434", publisher1);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
