package com.example.biddingsystem.repository;

import org.springframework.stereotype.Repository;

import com.example.biddingsystem.pojo.BiddingDetails;
import com.example.biddingsystem.pojo.BiddingDetailsIds;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface BiddingDetailsRepository extends JpaRepository<BiddingDetails, BiddingDetailsIds> {
	@Query(value="SELECT * FROM BiddingDetails  where productId=:productId and bidPrice =(select max(bidPrice) from BiddingDetails)",nativeQuery = true)
	List<BiddingDetails> findMaxBidPrice(@Param("productId") String productId);
	Optional<BiddingDetails> findByUserIdAndProductId(String userId,String productId);
}
