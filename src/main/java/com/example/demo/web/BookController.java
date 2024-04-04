package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.CategoryRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BookController {


@Autowired
private BookRepository repository;

@Autowired
private CategoryRepository drepository;

@RequestMapping({"/", "/booklist"})
public String bookStoreList(Model model) {
    model.addAttribute("book", repository.findAll());
   
    return "booklist";
}

 @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {	
        return (List<Book>) repository.findAll();
    }    


 @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }      

@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model ) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }



@RequestMapping(value="/add")
    public String addBook(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("categories", drepository.findAll());
    return "addbook";
    
    }


@RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Book book) {
    repository.save(book);
    return "redirect:booklist";
    
    }
    
@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
    

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", drepository.findAll());
		return "editbook";
	}

}
