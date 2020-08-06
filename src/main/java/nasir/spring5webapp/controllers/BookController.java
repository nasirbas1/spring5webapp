package nasir.spring5webapp.controllers;

import nasir.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// telling that its a spring bean and hence managed by spring
@Controller
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // model is an interface, spring will pass its implementation at runtime
    @RequestMapping("/books")
    // A model gets passed by the spring MVC
    public String getBooks(Model model){
        // the model that is passed in, we are adding an attribute called books
        // and it will contains all the books coming out of the repository
        // Spring JPA gets the list of books which is the model
        // passed as POJOs to the controller which will pass them to the view.
        model.addAttribute("books", bookRepository.findAll());
        // we are returning the view name (thymleaf view name here)
        return "books";
    }
}
