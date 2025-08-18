package com.onlineShopping.EprojectModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder 
@Table(name = "address")
public class Address {
    @Id
    private String userId;

    @Column(nullable = false)
    private String doorNo;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private String phonenumber;

    @Column(nullable = false)
    private String name;

    
}
