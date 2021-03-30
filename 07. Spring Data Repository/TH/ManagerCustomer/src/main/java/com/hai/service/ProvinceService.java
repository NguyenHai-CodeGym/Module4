package com.hai.service;


import com.hai.model.Province;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
