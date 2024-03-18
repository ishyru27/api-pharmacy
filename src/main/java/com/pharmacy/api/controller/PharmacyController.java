package com.pharmacy.api.controller;


import com.pharmacy.api.entities.Pharmacy;
import com.pharmacy.api.services.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farmacia")
public class PharmacyController {
    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping
    public Pharmacy createPharmacy(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.createPharmacy(pharmacy);
    }

    @GetMapping("/{id}")
    public Pharmacy getPharmacyForId(@PathVariable Long id) {
        return pharmacyService.getPharmacyForId(id);
    }

    @GetMapping("/cercana")
    public ResponseEntity<Pharmacy> getNearestPharmacy(@RequestParam double lat, @RequestParam double lon) {
        Pharmacy nearestPharmacy = pharmacyService.getNearestPharmacy(lat, lon);
        if (nearestPharmacy != null) {
            return new ResponseEntity<>(nearestPharmacy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
