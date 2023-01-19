package com.drones.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * @author Romeo Jerenyama
 * @created 18/01/2023 - 11:41
 */
@Data
@Entity
@Builder
@Table(name = "medication")
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private Double weight;
    private String code;
    private String image;
}
