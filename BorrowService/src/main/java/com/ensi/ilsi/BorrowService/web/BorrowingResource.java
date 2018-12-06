/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BorrowService.web;

import com.ensi.ilsi.BorrowService.service.BorrowingService;
import com.ensi.ilsi.librarycommons.dto.BorrowingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.librarycommons.utilis.Web.API;

/**
 * @author amal
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/borrowings")
public class BorrowingResource {
    
    private final BorrowingService borowingService;

    @GetMapping
    public List<BorrowingDto> findAll() {
        return this.borowingService.findAll();
    }

    @GetMapping("/{id}")
    public BorrowingDto findById(@PathVariable Long id) {
        return this.borowingService.findById(id);
    }

    @PostMapping
    public BorrowingDto create(@RequestBody BorrowingDto borrowingDto) {
        return this.borowingService.create(borrowingDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.borowingService.delete(id);
}
}
