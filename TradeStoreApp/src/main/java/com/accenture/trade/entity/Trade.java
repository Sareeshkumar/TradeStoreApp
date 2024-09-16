package com.accenture.trade.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="trade")
@Data
public class Trade {
	
	@Id
	@Column(name="TRADE_ID")
	private String tradeId;
	
	@Column(name="VERSION_NUMBER")
	private Integer versionNumber;
	
	@Column(name="COUNTER_PARTY_ID")
	private String CounterPartyId;
	
	@Column(name="BOOK_ID")
	private String BookId;
	
	@Column(name="MATURITY_DATE")
	private Date MaturityDate;
	
	@Column(name="CREATED_DATE")
	private Date CreatedDate;
	
	@Column(name="EXPIRED")
	private String Expired;


	public String getTradeId() {
		return tradeId;
	}


	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}


	public Integer getVersionNumber() {
		return versionNumber;
	}


	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}


	public String getCounterPartyId() {
		return CounterPartyId;
	}


	public void setCounterPartyId(String counterPartyId) {
		CounterPartyId = counterPartyId;
	}


	public String getBookId() {
		return BookId;
	}


	public void setBookId(String bookId) {
		BookId = bookId;
	}


	public Date getMaturityDate() {
		return MaturityDate;
	}


	public void setMaturityDate(Date maturityDate) {
		MaturityDate = maturityDate;
	}


	public Date getCreatedDate() {
		return CreatedDate;
	}


	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}


	public String getExpired() {
		return Expired;
	}


	public void setExpired(String expired) {
		Expired = expired;
	}



	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", versionNumber=" + versionNumber + ", CounterPartyId=" + CounterPartyId
				+ ", BookId=" + BookId + ", MaturityDate=" + MaturityDate + ", CreatedDate=" + CreatedDate
				+ ", Expired=" + Expired + "]";
	}



	
	
	

}
