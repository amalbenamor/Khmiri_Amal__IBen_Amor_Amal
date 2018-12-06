/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.service;

import com.ensi.ilsi.BookService.domain.Author;
import com.ensi.ilsi.BookService.repository.AuthorRepository;
import com.ensi.ilsi.librarycommons.dto.AuthorDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amal
 */
@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class AuthorService {
     private final AuthorRepository authorRepository;

    public List<AuthorDto> findAll() {
        log.debug("Request to get all Authors");
        return this.authorRepository.findAll()
                .stream()
                .map(AuthorService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AuthorDto findById(Long id) {
        log.debug("Request to get Author : {}", id);
        return this.authorRepository.findById(id).map(AuthorService::mapToDto).orElse(null);
    }

    public AuthorDto create(AuthorDto authorDto) {
        log.debug("Request to create Author : {}", authorDto);

        return mapToDto(this.authorRepository.save(
                new Author(
                        authorDto.getFirstName(),
                        authorDto.getLastName(),
                        authorDto.getNationality()
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Author : {}", id);
        this.authorRepository.deleteById(id);
    }

    public static AuthorDto mapToDto(Author author) {
        if (author != null) {
            return new AuthorDto(
                    author.getId(),
                    author.getFirstName(),
                    author.getLastName(),
                    author.getNationality()
            );
        }
        return null;
    }
    
}
