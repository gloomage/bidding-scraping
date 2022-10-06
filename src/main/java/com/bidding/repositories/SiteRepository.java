package com.bidding.repositories;

import com.bidding.models.SiteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SiteRepository extends JpaRepository<SiteModel, UUID> {
}
