/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.web;

import com.ensi.ilsi.librarycommons.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ensi.ilsi.BookService.service.AuthorService;

import static com.ensi.ilsi.librarycommons.utilis.Web.API;
import java.util.List;
/**
 *
 * @author amal
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/authors")
public class AuthorResource {
    private final AuthorService authorService;
    
    @GetMapping
    public List<AuthorDto> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public AuthorDto findById(@PathVariable Long id) {
        return this.authorService.findById(id);
    }

    @PostMapping
    public AuthorDto create(@RequestBody AuthorDto authorDto) {
        return this.authorService.create(authorDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.authorService.delete(id);
    }
}
