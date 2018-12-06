/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ensi.ilsi.librarycommons.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ensi.ilsi.BookService.service.BookService;

import static com.ensi.ilsi.librarycommons.utilis.Web.API;
import java.util.List;

/**
 *
 * @author amal
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/books")
public class BookResource {
    private final BookService bookService;
    
    @GetMapping
    public List<BookDto> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable Long id) {
        return this.bookService.findById(id);
    }
    
    @PostMapping
    public BookDto create(@RequestBody BookDto bookDto) {
        return this.bookService.create(bookDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.bookService.delete(id);
    }
    
}
