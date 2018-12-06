/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BorrowService;

import com.ensi.ilsi.librarycommons.dto.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author amal
 */
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final RestTemplate restTemplate;

    public DataLoader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... strings) throws Exception {
        ResponseEntity<BookDto> bookResponseEntity
                = this.restTemplate.getForEntity(
                        "http://BookService/api/books/{id}",
                        BookDto.class,
                        2
                );

        log.error("############  " + bookResponseEntity.getBody().toString() + "   ###############");
    }
}