package com.app.mybaetown.model;

import com.app.mybaetown.enums.OrderStatus;
import com.app.mybaetown.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private Long sellerId;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> orderItems=new ArrayList<>();

    @ManyToOne
    private Address shippingAddress;

    @Embedded
    private PaymentDetails paymentDetails=new PaymentDetails();

    private Double totalMrpPrice;

    private Double totalSellingPrice;

    private Integer discount;

    private OrderStatus orderStatus;

    private int totalItem;

    @ManyToOne
    @JoinColumn(name = "payment_order_id")
    private PaymentOrder paymentOrder;

    private PaymentStatus paymentStatus=PaymentStatus.PENDING;

    private LocalDateTime orderDate=LocalDateTime.now();
    private LocalDateTime deliveryDate=LocalDateTime.now().plusDays(7);
}
