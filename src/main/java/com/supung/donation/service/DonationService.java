package com.supung.donation.service;

import com.supung.donation.model.dto.DonationInputDTO;
import com.supung.donation.model.dto.DonationOutputDTO;

import java.util.List;

public interface DonationService {
    DonationOutputDTO save(DonationInputDTO donationInputDTO);

    List<DonationOutputDTO> findAll();

    DonationOutputDTO findById(long id);

    DonationOutputDTO findByRequirementId(long requirementId);
}
