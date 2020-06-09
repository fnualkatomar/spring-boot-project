package com.learning.spring.cloud.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ExchangeValue {
	
	@Id
	private Long id;
	private String frm;
	private String to;
	private BigDecimal conversionMultiple;
	@Transient
	private int port;
	public ExchangeValue() {}
	
	public ExchangeValue(Long id, String frm, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.frm = frm;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
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

	public void setFrom(String from) {
		this.frm = from;
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
	
	
	

}
