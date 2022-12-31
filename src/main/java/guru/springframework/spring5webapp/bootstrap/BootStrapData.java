package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book test = new Book("Spring Guide", "123456");
        eric.getBooks().add(test);
        test.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(test);

        Author rod = new Author("Rod", "Johnson");
        Book two = new Book("Wowow", "55555");
        rod.getBooks().add(two);
        two.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(two);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
