package com.accenture.trade.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.trade.dto.TradeRequest;
import com.accenture.trade.entity.Trade;
import com.accenture.trade.exception.TradeNotFoundException;
import com.accenture.trade.repository.TradeRepository;
import com.accenture.trade.service.ITradeService;

@Service
public class TradeServiceImpl implements ITradeService {

	@Autowired
	private TradeRepository tradeRepository;

	@Override
	public Trade savetrade(TradeRequest tradeRequest) {
		
		Integer versionNumber = tradeRequest.getVersionNumber();
		String bookId = tradeRequest.getBookId();
		String cunterPartyId = tradeRequest.getCounterPartyId();
		Date maturityDate = tradeRequest.getMaturityDate();
		Integer sequenceNumber = tradeRepository.getSequenceVlaue();
		String tradeId = "T" + sequenceNumber;
		Date createdDate = new Date();
		
		Trade trade = new Trade();
		trade.setTradeId(tradeId);
		trade.setVersionNumber(versionNumber);
		trade.setBookId(bookId);
		trade.setCounterPartyId(cunterPartyId);
		trade.setMaturityDate(maturityDate);
		trade.setCreatedDate(createdDate);
		trade.setExpired("N");

		return tradeRepository.save(trade);
	}

	@Override
	public List<Trade> findAllTrades() {
	
		return tradeRepository.findAll();
	}

	@Override
	public Trade findByTradeId(String tradeId) {
		Optional<Trade> opt = tradeRepository.findById(tradeId.toString());
		if (opt.isPresent()) {
		return opt.get();
	} else {
			throw new TradeNotFoundException(tradeId + "- not found");
	}
	   }  

	// If given Id should not be null and ID exist in DB

	
	/*
	 * 
	 * @Override public void updateTrade(TradeRequest tradeRequest) { if (null ==
	 * tradeRequest.getTradeId() ||
	 * !tradeRepository.existsById(tradeRequest.getTradeId())) { throw new
	 * TradeNotFoundException(tradeRequest.getTradeId() + " - not found"); } else {
	 * tradeRepository.save(tradeRequest); } }
	 */
	  
	  @Override 
	  public void deleteTrade(String id) {
	  tradeRepository.delete(findByTradeId(id));
	  }
	 
}
