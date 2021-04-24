package com.example.biddingsystem.repository;

import org.springframework.stereotype.Repository;

import com.example.biddingsystem.pojo.BiddingAssigned;
import com.example.biddingsystem.pojo.BiddingAssignedIds;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BiddingAssignedRepository extends JpaRepository<BiddingAssigned, BiddingAssignedIds> {

}
