/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BorrowService.web;

import com.ensi.ilsi.BorrowService.service.BorrowerService;
import com.ensi.ilsi.librarycommons.dto.BorrowerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.librarycommons.utilis.Web.API;

/**
 * @author amal
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/borrowers")
public class BorrowerResource {
    
    private final BorrowerService borowerService;

    @GetMapping
    public List<BorrowerDto> findAll() {
        return this.borowerService.findAll();
    }

    @GetMapping("/{id}")
    public BorrowerDto findById(@PathVariable Long id) {
        return this.borowerService.findById(id);
    }

    @PostMapping
    public BorrowerDto create(@RequestBody BorrowerDto borrowerDto) {
        return this.borowerService.create(borrowerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.borowerService.delete(id);
}
    
}
