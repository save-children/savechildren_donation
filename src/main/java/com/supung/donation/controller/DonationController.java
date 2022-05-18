package com.supung.donation.controller;

import com.supung.donation.model.dto.DonationInputDTO;
import com.supung.donation.model.dto.DonationOutputDTO;
import com.supung.donation.service.DonationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(final DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    public ResponseEntity<DonationOutputDTO> save(@RequestBody DonationInputDTO donationInputDTO) {
        return ResponseEntity.ok(donationService.save(donationInputDTO));
    }

    @GetMapping
    public ResponseEntity<List<DonationOutputDTO>> findAll() {
        return ResponseEntity.ok(donationService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<DonationOutputDTO> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(donationService.findById(id));
    }

    @GetMapping("findByRequirement/{requirementId}")
    public DonationOutputDTO findByRequirementId(@PathVariable("requirementId") long requirementId) {
        return donationService.findByRequirementId(requirementId);
    }
}
