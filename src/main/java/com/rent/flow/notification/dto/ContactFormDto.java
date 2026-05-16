package com.rent.flow.notification.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ContactFormDto {
    private String name;
    private String company;
    private String email;
    private String engagementType;
    private String practiceArea;
    private String timeline;
    private String message;
}
