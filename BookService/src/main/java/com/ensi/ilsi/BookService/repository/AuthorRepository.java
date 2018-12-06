package com.ensi.ilsi.BookService.repository;

import com.ensi.ilsi.BookService.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amal
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
