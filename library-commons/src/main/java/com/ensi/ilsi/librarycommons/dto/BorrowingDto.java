/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.librarycommons.dto;


import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author amal
 */
@Data
@AllArgsConstructor
public class BorrowingDto {
    
    private Long id;
    private Date start_date;
    private Date end_date;
    private boolean delivered;
    private Long bookId;
    private Long borrowerId;
    
    
}
