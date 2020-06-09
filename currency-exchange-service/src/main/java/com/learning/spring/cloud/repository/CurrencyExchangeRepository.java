package com.learning.spring.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.spring.cloud.model.ExchangeValue;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
	
	public ExchangeValue findByFrmAndTo(String frm, String to);

}
