package com.batuhanozdamar.eproductionTest.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class product  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name", length = 200)
    private String productName;

    @Column(name = "product_code", length = 100)
    private String productCode;

    @Column(name = "product_category", length = 100)
    private String productCategory;

    @Column(name = "product_price", length = 4)
    private double productPrice;

    @JoinColumn(name = "company_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User company;

}
