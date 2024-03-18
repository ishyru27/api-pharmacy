package com.pharmacy.api.repositories;


import com.pharmacy.api.entities.Pharmacy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PharmacyRepositoryTest {

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Test
    public void testFindNearestPharmacy() {
        // Arrange
        double latitud = 10.0;
        double longitud = 20.0;

        // Act
        List<Pharmacy> nearestPharmacies = pharmacyRepository.findNearestPharmacy(latitud, longitud);

        // Assert
        // Verificamos que la lista de farmacias no esté vacía
        assertEquals(1, nearestPharmacies.size());
        // Realizamos aserciones adicionales sobre la farmacia más cercana encontrada
        // Por ejemplo, podríamos verificar el nombre de la farmacia
        Pharmacy nearestPharmacy = nearestPharmacies.get(0);
        assertEquals("Nombre de la Farmacia", nearestPharmacy.getName());
        // También podríamos verificar la latitud y longitud de la farmacia, según sea necesario
        assertEquals(10.0, nearestPharmacy.getLatitud());
        assertEquals(20.0, nearestPharmacy.getLongitud());
    }
}