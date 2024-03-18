package com.pharmacy.api.repositories;

import com.pharmacy.api.entities.Pharmacy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface PharmacyRepository extends PagingAndSortingRepository<Pharmacy, Long> {
    @Query(value = "SELECT * FROM pharmacy p ORDER BY SQRT(POWER(p.latitud - :latitud, 2) + POWER(p.longitud - :longitud, 2)) ASC LIMIT 1", nativeQuery = true)
    List<Pharmacy> findNearestPharmacy(@Param("latitud") double latitud, @Param("longitud") double longitud);
}
