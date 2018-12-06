/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.librarycommons.dto;


import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author amal
 */
@Data
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String ISBN;
    private String title;
    private String language;
    private Integer year;
    private Integer nb_pages;
    private Set<CopyDto> copys;
    private DomainDto domain;
    private AuthorDto author;

}
  