package com.example.promotool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "price")
@IdClass(PricePK.class)
public class Price {
    @Id
    @Column(name = "chain_name")
    private String chainName;
    @Id
    @Column(name = "material_no")
    private Integer materialId;
    @Column(name = "regular_price")
    private Double price;

//    @ManyToOne
//    @JoinColumn(name = "material_no", referencedColumnName = "material_id", insertable=false, updatable=false)
//    private Products product;
}
