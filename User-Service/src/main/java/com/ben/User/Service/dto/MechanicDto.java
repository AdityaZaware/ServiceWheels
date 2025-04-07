package com.ben.User.Service.dto;

import com.ben.User.Service.enums.Role;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MechanicDto {

    private Long id;

    private String username;
    private String email;
    private String contact;
    private ShopDto shopDto;
}
