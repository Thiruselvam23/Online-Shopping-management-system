package com.onlineShopping.EprojectRepo;

import com.onlineShopping.EprojectModel.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendorRepo extends JpaRepository<Vendor, String> {
}
