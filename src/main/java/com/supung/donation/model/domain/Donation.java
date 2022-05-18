package com.supung.donation.model.domain;

import com.supung.donation.model.dto.DonationOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long requirementId;
    private Long donarId;

    public DonationOutputDTO viewAsDonationOutputDTO() {
        return DonationOutputDTO.builder()
                .id(id).requirementId(requirementId).donarId(donarId)
                .build();
    }
}
