package com.pharmacy.api.services;

import com.pharmacy.api.entities.Pharmacy;
import com.pharmacy.api.repositories.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService {
    @Autowired
    private PharmacyRepository pharmacyRepository;

    public Pharmacy createPharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    public Pharmacy getPharmacyForId(Long id) {
        return pharmacyRepository.findById(id).orElse(null);
    }

    public Pharmacy getNearestPharmacy(double latitud, double longitud) {
        List<Pharmacy> nearestPharmacy = pharmacyRepository.findNearestPharmacy(latitud, longitud);
        return nearestPharmacy.isEmpty() ? null : nearestPharmacy.get(0);
    }
}
