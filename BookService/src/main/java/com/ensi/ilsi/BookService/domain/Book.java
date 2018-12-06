/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.domain;


import com.ensi.ilsi.librarycommons.domain.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A Book.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "book")
public class Book extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ISBN", nullable = false)
    private String ISBN;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "language", nullable = false)
    private String language;
    
    @NotNull
    @Column(name = "year")
    private Integer year;
    
    @NotNull
    @Column(name = "nb_pages")
    private Integer nb_pages;

    @OneToMany
    @JsonIgnore
    private Set<Copy> copys = new HashSet<>();;

    @ManyToOne
    private Domain domain;
    
    @ManyToOne
    private Author author;
    
     public Book() {
        
    }

    public Book(String ISBN, String title, String language, Integer year, Integer nb_pages,Domain domain, Author author) {
        this.ISBN = ISBN;
        this.title = title;
        this.language = language;
        this.year = year;
        this.nb_pages = nb_pages;
        this.domain = domain;
        this.author = author;
    }

}