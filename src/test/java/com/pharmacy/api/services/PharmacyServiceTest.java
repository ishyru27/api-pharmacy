package com.pharmacy.api.services;

import com.pharmacy.api.entities.Pharmacy;
import com.pharmacy.api.repositories.PharmacyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class PharmacyServiceTest {

    @Mock
    private PharmacyRepository pharmacyRepository;

    @InjectMocks
    private PharmacyService pharmacyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePharmacy() {
        // Arrange
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName("Pharmacy create test");

        when(pharmacyRepository.save(any())).thenReturn(pharmacy);

        // Act
        Pharmacy createdPharmacy = pharmacyService.createPharmacy(pharmacy);

        // Assert
        assertEquals(pharmacy.getName(), createdPharmacy.getName());
    }
    @Test
    public void testCreatePharmacyFailure() {
        // Arrange
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName("");

        when(pharmacyRepository.save(any(Pharmacy.class))).thenReturn(null);

        // Act
        Pharmacy createdPharmacy = pharmacyService.createPharmacy(pharmacy);

        // Assert
        assertNull(createdPharmacy);
    }

    @Test
    public void testGetPharmacyForId() {
        // Arrange
        Long pharmacyId = 1L;
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(pharmacyId);
        pharmacy.setName("Pharmacy 1");

        when(pharmacyRepository.findById(anyLong())).thenReturn(Optional.of(pharmacy));

        // Act
        Pharmacy foundPharmacy = pharmacyService.getPharmacyForId(pharmacyId);

        // Assert
        assertEquals(pharmacyId, foundPharmacy.getId());
        assertEquals(pharmacy.getName(), foundPharmacy.getName());
    }

    @Test
    public void testGetNearestPharmacy() {
        // Arrange
        double latitud = 10.0;
        double longitud = 20.0;
        Pharmacy nearestPharmacy = new Pharmacy();
        nearestPharmacy.setName("Nearest Pharmacy");

        when(pharmacyRepository.findNearestPharmacy(anyDouble(), anyDouble())).thenReturn(Collections.singletonList(nearestPharmacy));

        // Act
        Pharmacy foundNearestPharmacy = pharmacyService.getNearestPharmacy(latitud, longitud);

        // Assert
        assertEquals(nearestPharmacy.getName(), foundNearestPharmacy.getName());
    }
}
