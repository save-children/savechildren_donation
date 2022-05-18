package com.supung.donation.model.dto;

import com.supung.donation.model.domain.Donation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationInputDTO {
    private Long requirementId;
    private Long donarId;

    public Donation viewAsDonation() {
        return Donation.builder()
                .requirementId(requirementId).donarId(donarId)
                .build();
    }
}
