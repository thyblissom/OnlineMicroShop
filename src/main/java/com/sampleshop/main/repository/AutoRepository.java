package com.sampleshop.main.repository;

import com.sampleshop.main.model.MusicSample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository
        extends JpaRepository<MusicSample, Long> {
}
