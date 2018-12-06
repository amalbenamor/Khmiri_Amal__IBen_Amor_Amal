/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.web;

import com.ensi.ilsi.librarycommons.dto.CopyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ensi.ilsi.BookService.service.CopyService;

import static com.ensi.ilsi.librarycommons.utilis.Web.API;
import java.util.List;
/**
 *
 * @author amal
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/copys")
public class CopyResource {
    private final CopyService copyService;
    
     @GetMapping
    public List<CopyDto> findAll() {
        return this.copyService.findAll();
    }

    @GetMapping("/{id}")
    public CopyDto findById(@PathVariable Long id) {
        return this.copyService.findById(id);
    }
    

    @PostMapping
    public CopyDto create(CopyDto copyDto) {
        return this.copyService.create(copyDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.copyService.delete(id);
    }
    
    
}
