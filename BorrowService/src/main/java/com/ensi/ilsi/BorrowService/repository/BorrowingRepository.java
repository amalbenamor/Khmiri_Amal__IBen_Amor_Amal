/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BorrowService.repository;

import com.ensi.ilsi.BorrowService.domain.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author amal
 */
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    
}
