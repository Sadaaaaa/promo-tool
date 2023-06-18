package com.example.promotool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @Column(name = "ship_to_code")
    private Integer shipToCode;
    @Column(name = "ship_to_name")
    private String shipToName;
    @Column(name = "chain_name")
    private String chain;


}
