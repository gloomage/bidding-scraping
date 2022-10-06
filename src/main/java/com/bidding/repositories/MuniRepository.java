package com.bidding.repositories;

import com.bidding.models.MuniModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MuniRepository extends JpaRepository<MuniModel, UUID> {
}
