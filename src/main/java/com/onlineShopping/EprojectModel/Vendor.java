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
@Table(name = "vendors")
public class Vendor {
    
    @Id
    private String   vendorid;
;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String phoneNumber;


}
