package com.wealthswaysoft.agencybankingapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnquiryRequest {
    private String accountNumber;
}