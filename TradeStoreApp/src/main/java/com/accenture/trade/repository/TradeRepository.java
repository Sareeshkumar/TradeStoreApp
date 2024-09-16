package com.accenture.trade.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accenture.trade.entity.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, String> {
	
	@Query(value = "select trade_seq.nextval from dual", nativeQuery = true)
	Integer getSequenceVlaue();

	//Optional<Trade> findByTradeId(String string);
}
