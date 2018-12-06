package com.ensi.ilsi.BookService.repository;

import com.ensi.ilsi.BookService.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amal
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
