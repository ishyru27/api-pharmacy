package com.pharmacy.api.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PharmacyTest {

    @Test
    public void testPharmacyEntity() {
        // Arrange
        Long id = 1L;
        String name = "Farmacia Ejemplo";
        double latitud = 40.0;
        double longitud = -74.0;

        // Act
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setId(id);
        pharmacy.setName(name);
        pharmacy.setLatitud(latitud);
        pharmacy.setLongitud(longitud);

        // Assert
        assertEquals(id, pharmacy.getId());
        assertEquals(name, pharmacy.getName());
        assertEquals(latitud, pharmacy.getLatitud());
        assertEquals(longitud, pharmacy.getLongitud());
    }
}
