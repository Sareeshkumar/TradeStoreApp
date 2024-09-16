package com.accenture.trade.service;

import java.util.List;
import java.util.Optional;

import com.accenture.trade.dto.TradeRequest;
import com.accenture.trade.entity.Trade;

public interface ITradeService {
     
	Trade savetrade(TradeRequest tradeRequest);
	List<Trade> findAllTrades();
	Trade findByTradeId(String tradeId);
	//void updateTrade(TradeRequest trade);
	void deleteTrade(String tradeId);
	
}
