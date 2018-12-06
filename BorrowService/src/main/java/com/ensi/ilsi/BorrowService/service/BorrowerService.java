/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BorrowService.service;

import com.ensi.ilsi.BorrowService.domain.Borrower;
import com.ensi.ilsi.librarycommons.dto.BorrowerDto;
import com.ensi.ilsi.BorrowService.repository.BorrowerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author amal
 */

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class BorrowerService {
    private final BorrowerRepository borrowerRepository;
   

    public List<BorrowerDto> findAll() {
        log.debug("Request to get all Borrowers");
        return this.borrowerRepository.findAll()
                .stream()
                .map(BorrowerService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BorrowerDto findById(Long id) {
        log.debug("Request to get Borrower : {}", id);
        return this.borrowerRepository.findById(id).map(BorrowerService::mapToDto).orElse(null);
    }

    public BorrowerDto create(BorrowerDto borrowerDto) {
        log.debug("Request to create Borrower : {}", borrowerDto);

        return mapToDto(this.borrowerRepository.save(
                new Borrower(
                        borrowerDto.getFirstName(),
                        borrowerDto.getLastName(),
                        borrowerDto.getBirthdate(),
                        Collections.emptySet()
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Borrower : {}", id);
        this.borrowerRepository.deleteById(id);
    }

    public static BorrowerDto mapToDto(Borrower borrower) {
        if (borrower != null) {
            return new BorrowerDto(
                    borrower.getId(),
                    borrower.getFirstName(),
                    borrower.getLastName(),
                    borrower.getBirthdate()
            );
        }
        return null;
    }
    
}
