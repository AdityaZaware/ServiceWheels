package com.ben.repo;

import com.ben.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepo extends JpaRepository<Shop, Long> {
    Optional<Shop> findByOwnerEmail(String email);

    List<Shop> findByVehicleType(String vehicleType);
}
