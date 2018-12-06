/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BorrowService.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ensi.ilsi.librarycommons.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author amal
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "borrowers")
public class Borrower extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    
     @NotNull
  @Column(name = "firstName", nullable = false)
    private String firstName;
    
  @NotNull
  @Column(name = "lastName", nullable = false)
    private String lastName;
  
  @NotNull
  @Column(name = "birthdate", nullable = false)
    private Date birthdate;
  
  @OneToMany(mappedBy = "borrower")
  @JsonIgnore
    private Set<Borrowing> borrowings;
  
  public Borrower(){
      
    }

    public Borrower(String firstName, String lastName, Date birthdate, Set<Borrowing> borrowings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.borrowings = borrowings;
    }
    
}
