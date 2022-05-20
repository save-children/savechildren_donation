package com.supung.donation.controller;

import com.supung.donation.model.dto.DonationInputDTO;
import com.supung.donation.model.dto.DonationOutputDTO;
import com.supung.donation.service.DonationService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(final DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    @Timed(value = "save.time", description = "Time taken to add a donation")
    public ResponseEntity<DonationOutputDTO> save(@RequestBody DonationInputDTO donationInputDTO) {
        return ResponseEntity.ok(donationService.save(donationInputDTO));
    }

    @GetMapping
    @Timed(value = "findAll.time", description = "Time taken to get all donations")
    public ResponseEntity<List<DonationOutputDTO>> findAll() {
        return ResponseEntity.ok(donationService.findAll());
    }

    @GetMapping("{id}")
    @Timed(value = "findById.time", description = "Time taken to get a donation by id")
    public ResponseEntity<DonationOutputDTO> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(donationService.findById(id));
    }

    @GetMapping("findByRequirement/{requirementId}")
    @Timed(value = "findByRequirementId.time", description = "Time taken to get a donation by requirement id")
    public DonationOutputDTO findByRequirementId(@PathVariable("requirementId") long requirementId) {
        log.info("Finding Donations by requirementId: {}", requirementId);
        return donationService.findByRequirementId(requirementId);
    }
}
