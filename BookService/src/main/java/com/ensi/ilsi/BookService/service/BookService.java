/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.service;

import com.ensi.ilsi.BookService.domain.Book;
import com.ensi.ilsi.BookService.repository.AuthorRepository;
import com.ensi.ilsi.BookService.repository.BookRepository;
import com.ensi.ilsi.BookService.repository.DomainRepository;
import com.ensi.ilsi.librarycommons.dto.BookDto;
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
public class BookService {
    private final BookRepository bookRepository;
    private final DomainRepository domainRepository;
    private final AuthorRepository authorRepository;

    public List<BookDto> findAll() {
        log.debug("Request to get all Books");
        return this.bookRepository.findAll()
                .stream()
                .map(BookService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BookDto findById(Long id) {
        log.debug("Request to get Book : {}", id);
        return this.bookRepository.findById(id).map(BookService::mapToDto).orElse(null);
    }
    public BookDto create(BookDto bookDto) {
        log.debug("Request to create Book : {}", bookDto);

        return mapToDto(this.bookRepository.save(
                new Book(
                        bookDto.getISBN(),
                        bookDto.getTitle(),
                        bookDto.getLanguage(),
                        bookDto.getYear(),
                        bookDto.getNb_pages(),
                        domainRepository.findById(bookDto.getId()).orElse(null),
                        authorRepository.findById(bookDto.getId()).orElse(null)
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        this.bookRepository.deleteById(id);
    }

    public static BookDto mapToDto(Book book) {
        if (book != null) {
            return new BookDto(
                    book.getId(),
                    book.getISBN(),
                    book.getTitle(),
                    book.getLanguage(),
                    book.getYear(),
                    book.getNb_pages(),
                    book.getCopys().stream().map(CopyService::mapToDto).collect(Collectors.toSet()),
                    DomainService.mapToDto(book.getDomain()),
                    AuthorService.mapToDto(book.getAuthor())
            );
        }
        return null;
    }
}
