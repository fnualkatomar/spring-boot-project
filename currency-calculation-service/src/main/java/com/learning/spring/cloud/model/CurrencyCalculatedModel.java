package com.learning.spring.cloud.model;

import java.math.BigDecimal;

public class CurrencyCalculatedModel {
	private Long id;
	private String frm;
	private String to;
	private BigDecimal conversionMultiple;
	private int port;
	private BigDecimal quantity;
	private BigDecimal totalBalance;
	
	public CurrencyCalculatedModel() {}
	
	public CurrencyCalculatedModel(Long id, String frm, String to, BigDecimal conversionMultiple, int port,
			BigDecimal quantity, BigDecimal totalBalance) {
		super();
		this.id = id;
		this.frm = frm;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
		this.quantity = quantity;
		this.totalBalance = totalBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrm() {
		return frm;
	}

	public void setFrm(String frm) {
		this.frm = frm;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	
	
}
