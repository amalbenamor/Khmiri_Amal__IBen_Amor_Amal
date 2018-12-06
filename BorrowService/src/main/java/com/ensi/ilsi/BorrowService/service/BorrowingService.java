/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BorrowService.service;

import com.ensi.ilsi.BorrowService.domain.Borrower;
import com.ensi.ilsi.BorrowService.domain.Borrowing;
import com.ensi.ilsi.librarycommons.dto.BorrowingDto;
import com.ensi.ilsi.BorrowService.repository.BorrowingRepository;
import com.ensi.ilsi.BorrowService.repository.BorrowerRepository;
import com.ensi.ilsi.librarycommons.dto.BookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author amal
 */

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;
    private final BorrowerRepository borrowerRepository;
     private final RestTemplate restTemplate;
    
    public List<BorrowingDto> findAll() {
        log.debug("Request to get all Borrowings");
        return this.borrowingRepository.findAll()
                .stream()
                .map(BorrowingService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BorrowingDto findById(Long id) {
        log.debug("Request to get Borrowing : {}", id);
        return this.borrowingRepository.findById(id).map(BorrowingService::mapToDto).orElse(null);
    }

    public BorrowingDto create(BorrowingDto borrowingDto) {
        log.debug("Request to create Borrowing : {}", borrowingDto);

         Borrower borrower = this.borrowerRepository
                .findById(borrowingDto.getBorrowerId())
                .orElseThrow(
                        () -> new IllegalStateException("The Order does not exist!")
                );

        ResponseEntity<BookDto> bookResponseEntity
                = this.restTemplate.getForEntity(
                        "http://BookService/api/books/{id}",
                        BookDto.class,
                        borrowingDto.getBookId()
                );

        return mapToDto(
                this.borrowingRepository.save(
                        new Borrowing(
                                borrowingDto.getStart_date(),
                                borrowingDto.getEnd_date(),
                                borrowingDto.isDelivered(),
                                borrower,
                                bookResponseEntity.getBody().getId()
                                
)));
    }
    
    public void delete(Long id) {
        log.debug("Request to delete Borrowing : {}", id);
        this.borrowingRepository.deleteById(id);
    }

    public static BorrowingDto mapToDto(Borrowing borrowing) {
        if (borrowing != null) {
            return new BorrowingDto(
                    borrowing.getId(),
                    borrowing.getStart_date(),
                    borrowing.getEnd_date(),
                    borrowing.isDelivered(), 
                    borrowing.getBookId(),
                    borrowing.getBorrower().getId()
            );
        }
        return null;
    }
    
}
