package com.example.biddingsystem.repository;

import org.springframework.stereotype.Repository;

import com.example.biddingsystem.pojo.Vendor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
	
	Optional<Vendor> findById(String vendorId);
	

}
