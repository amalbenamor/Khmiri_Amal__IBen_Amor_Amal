/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.service;


import com.ensi.ilsi.BookService.domain.Domain;
import com.ensi.ilsi.BookService.repository.DomainRepository;
import com.ensi.ilsi.librarycommons.dto.DomainDto;
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
public class DomainService {

  private final DomainRepository domainRepository;
   
  

    public List<DomainDto> findAll() {
        log.debug("Request to get all Domains");
        return this.domainRepository.findAll()
                .stream()
                .map(DomainService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DomainDto findById(Long id) {
        log.debug("Request to get Domain : {}", id);
        return this.domainRepository.findById(id).map(DomainService::mapToDto).orElseThrow(IllegalStateException::new);
    }

    public DomainDto create(DomainDto domainDto) {
        log.debug("Request to create Domain : {}", domainDto);

        return mapToDto(this.domainRepository.save(
                new Domain(
                          domainDto.getName()
                       
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Domain : {}", id);
        this.domainRepository.deleteById(id);
    }

    public static DomainDto mapToDto(Domain domain) {
        if (domain != null) {
            return new DomainDto(
                    domain.getId(),
                    domain.getName()
            );
        }
        return null;
    }  
}

