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
@Table(name = "borrowing")
public class Borrowing extends AbstractEntity {
    
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    
  @NotNull
  @Column(name = "start_date", nullable = false)
    private Date start_date;
    
  @NotNull
  @Column(name = "end_date", nullable = false)
    private Date end_date;
  
  @NotNull
  @Column(name = "delivered", nullable = false)
    private boolean delivered;
  
  private Long bookId;
  
  @ManyToOne
    private Borrower borrower;
    public Borrowing(){
      
  }

  public Borrowing(@NotNull Date start_date, @NotNull Date end_date, @NotNull boolean delivered, Borrower borrower, Long bookId) {
       this.start_date = start_date;
        this.end_date = end_date;
        this.delivered = delivered;
        this.borrower = borrower;
        this.bookId = bookId;
    }
    
}
