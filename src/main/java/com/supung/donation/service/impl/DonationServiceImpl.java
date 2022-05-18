package com.supung.donation.service.impl;

import com.supung.donation.exception.ResourceNotFoundException;
import com.supung.donation.model.domain.Donation;
import com.supung.donation.model.dto.DonationInputDTO;
import com.supung.donation.model.dto.DonationOutputDTO;
import com.supung.donation.repository.DonationRepository;
import com.supung.donation.service.DonationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(final DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public DonationOutputDTO save(DonationInputDTO donationInputDTO) {
        return donationRepository.save(donationInputDTO.viewAsDonation())
                .viewAsDonationOutputDTO();
    }

    @Override
    public List<DonationOutputDTO> findAll() {
        return donationRepository.findAll().stream()
                .map(Donation::viewAsDonationOutputDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DonationOutputDTO findById(long id) {
        return donationRepository.findById(id)
                .map(Donation::viewAsDonationOutputDTO)
                .orElseThrow(() -> new ResourceNotFoundException("No donation found"));
    }

    @Override
    public DonationOutputDTO findByRequirementId(long requirementId) {
        return donationRepository.findByRequirementId(requirementId)
                .map(Donation::viewAsDonationOutputDTO)
                .orElseThrow(() -> new ResourceNotFoundException("No donation found"));
    }
}
