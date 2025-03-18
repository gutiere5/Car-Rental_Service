package com.noel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.noel.Constants.AppConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 50)
    private String id;

    @Column(length = 15)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 30)
    private String owner;

    @NotBlank(message = AppConstants.MODEL_MANDATORY)
    @Column(length = 50)
    private String model;

    @NotBlank(message = AppConstants.BRAND_MANDATORY)
    @Column(length = 50)
    private String brand;

    @NotBlank(message = AppConstants.LICENSE_PLATE_NUMBER_MANDATORY)
    @JsonProperty("license_number")
    @Column(length = 50)
    private String licensePlateNumber;

    @JsonProperty("associated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 30)
    private Date associatedDate;
}
