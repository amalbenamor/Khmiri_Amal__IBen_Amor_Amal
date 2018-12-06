/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.repository;

import com.ensi.ilsi.BookService.domain.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author amal
 */
public interface CopyRepository extends JpaRepository<Copy, Long> {
  
}
