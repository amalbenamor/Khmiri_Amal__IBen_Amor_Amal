/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.web;

import com.ensi.ilsi.librarycommons.dto.DomainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ensi.ilsi.BookService.service.DomainService;

import static com.ensi.ilsi.librarycommons.utilis.Web.API;
import java.util.List;
/**
 *
 * @author amal
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/domains")
public class DomainResource {
     private final DomainService domainService;
     
     @GetMapping
    public List<DomainDto> findAll() {
        return this.domainService.findAll();
    }

    @GetMapping("/{id}")
    public DomainDto findById(@PathVariable Long id) {
        return this.domainService.findById(id);
    }
    
    @PostMapping
    public DomainDto create(DomainDto domainDto) {
        return this.domainService.create(domainDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.domainService.delete(id);
    }

}
