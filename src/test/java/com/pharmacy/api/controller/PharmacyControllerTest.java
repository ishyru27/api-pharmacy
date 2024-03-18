package com.pharmacy.api.controller;
import com.pharmacy.api.entities.Pharmacy;
import com.pharmacy.api.services.PharmacyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PharmacyControllerTest {

    @Mock
    private PharmacyService pharmacyService;

    @InjectMocks
    private PharmacyController pharmacyController;

    @BeforeEach
    public void setup() {
        reset(pharmacyService);
    }

    @Test
    public void testCreatePharmacy() {
        // Arrange
        Pharmacy pharmacyToCreate = new Pharmacy();
        pharmacyToCreate.setName("Farmacia de Prueba");
        pharmacyToCreate.setLatitud(10.0);
        pharmacyToCreate.setLongitud(20.0);

        Pharmacy createdPharmacy = new Pharmacy();
        createdPharmacy.setId(1L);
        createdPharmacy.setName("Farmacia de Prueba");
        createdPharmacy.setLatitud(10.0);
        createdPharmacy.setLongitud(20.0);

        when(pharmacyService.createPharmacy(pharmacyToCreate)).thenReturn(createdPharmacy);

        // Act
        Pharmacy result = pharmacyController.createPharmacy(pharmacyToCreate);

        // Assert
        verify(pharmacyService).createPharmacy(pharmacyToCreate);
        assertEquals(createdPharmacy, result);
    }

    @Test
    public void testGetPharmacyForId() {
        // Arrange
        Long id = 1L;
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(id);
        pharmacy.setName("Farmacia de Prueba");
        pharmacy.setLatitud(10.0);
        pharmacy.setLongitud(20.0);

        when(pharmacyService.getPharmacyForId(id)).thenReturn(pharmacy);

        // Act
        Pharmacy result = pharmacyController.getPharmacyForId(id);

        // Assert
        verify(pharmacyService).getPharmacyForId(id);
        assertEquals(pharmacy, result);
    }

    @Test
    public void testGetNearestPharmacy() {
        // Arrange
        double latitud = 10.0;
        double longitud = 20.0;
        Pharmacy nearestPharmacy = new Pharmacy();
        nearestPharmacy.setId(1L);
        nearestPharmacy.setName("Farmacia de Prueba");
        nearestPharmacy.setLatitud(latitud);
        nearestPharmacy.setLongitud(longitud);

        when(pharmacyService.getNearestPharmacy(latitud, longitud)).thenReturn(nearestPharmacy);

        // Act
        ResponseEntity<Pharmacy> result = pharmacyController.getNearestPharmacy(latitud, longitud);

        // Assert
        verify(pharmacyService).getNearestPharmacy(latitud, longitud);
        assertEquals(nearestPharmacy, result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}