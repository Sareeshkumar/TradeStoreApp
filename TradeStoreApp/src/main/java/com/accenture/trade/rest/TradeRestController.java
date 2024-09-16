package com.accenture.trade.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.accenture.trade.dto.TradeRequest;
import com.accenture.trade.entity.Trade;
import com.accenture.trade.exception.TradeNotFoundException;
import com.accenture.trade.service.ITradeService;


@RequestMapping("/tradestore")
@RestController
@EnableWebMvc
public class TradeRestController {

  	Logger log = LoggerFactory.getLogger(TradeRestController.class);

	@Autowired
	private ITradeService tradeService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@PostMapping("/save")
	public ResponseEntity<String> createTrade(@RequestBody TradeRequest request) {
		log.info("save() method called:");

		ResponseEntity<String> resp = null;
		String id = tradeService.savetrade(request).getTradeId();
		resp = new ResponseEntity<String>("Trade '"+id+"' created", HttpStatus.CREATED);
		log.info("save() method completed:");

		return resp;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Trade>> findAllTrades() {
		List<Trade> tradeList = tradeService.findAllTrades();
		return new ResponseEntity<List<Trade>>(tradeList, HttpStatus.OK);
	}


	@GetMapping("/find/{id}")
	public ResponseEntity<?> findByTradeId(@PathVariable String id) {
		ResponseEntity<?> resp = null;  
		try { 
			Trade trade = tradeService.findByTradeId(id);
			resp = new ResponseEntity<Trade>(trade, HttpStatus.OK); } 
		catch(TradeNotFoundException e) {
			e.printStackTrace();
			resp = new  ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	return resp;
	
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteTradeById(@PathVariable String id) {
		ResponseEntity<String> resp = null;
		try {
			tradeService.deleteTrade(id);
			resp = new ResponseEntity<String>("Trade " +id+ " is Deleted",HttpStatus.OK);

		}catch(TradeNotFoundException e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}


	/*
	 * public ResponseEntity<String> updatetrade(@RequestBody Trade trade) {
	 * 
	 * ResponseEntity<String> resp = null; try { tradeService.updateTrade(trade);
	 * return resp = new ResponseEntity<String>("Trade Updated!", HttpStatus.OK);
	 *
	 * } catch (TradeNotFoundException e) { e.printStackTrace(); return resp = new
	 * ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 *
	 */
}
