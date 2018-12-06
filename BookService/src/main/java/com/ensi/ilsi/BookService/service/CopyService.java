/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensi.ilsi.BookService.service;

import com.ensi.ilsi.BookService.domain.Copy;
import com.ensi.ilsi.BookService.repository.CopyRepository;
import com.ensi.ilsi.librarycommons.dto.CopyDto;
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
public class CopyService {
    private final CopyRepository copyRepository;
   

    public List<CopyDto> findAll() {
        log.debug("Request to get all Copys");
        return this.copyRepository.findAll()
                .stream()
                .map(CopyService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CopyDto findById(Long id) {
        log.debug("Request to get Copy : {}", id);
        return this.copyRepository.findById(id).map(CopyService::mapToDto).orElse(null);
    }
   


    public CopyDto create(CopyDto copyDto) {
        log.debug("Request to create Copy : {}", copyDto);

        return mapToDto(this.copyRepository.save(
                new Copy(
                        )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Copy : {}", id);
        this.copyRepository.deleteById(id);
    }

    public static CopyDto mapToDto(Copy copy) {
        if (copy != null) {
            return new CopyDto(
                   copy.getId()
            );
        }
        return null;
    }
}
