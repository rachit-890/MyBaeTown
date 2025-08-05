package com.app.mybaetown.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class SellerReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Seller seller;

    private Long totalEarning=0L;

    private Long totalSales=0L;

    private Long totalRefunds=0L;

    private Long totalTax=0L;

    private Long netEarning=0L;

    private Integer totalOrder=0;

    private Integer cancelledOrder=0;

    private Integer totalTransactions=0;
}
