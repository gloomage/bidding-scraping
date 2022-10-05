package com.webscraping.repositories;

import com.webscraping.models.LiciModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LiciRepository extends JpaRepository<LiciModel, UUID> {
}
