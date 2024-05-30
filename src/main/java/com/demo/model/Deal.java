package com.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "deal")
//@Data
public class Deal {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	@Column(name = "from_currency_code", nullable = false)
	private String fromCurrencyCode;

	@Column(name = "to_currency_code", nullable = false)
	private String toCurrencyCode;

	@Column(name = "timestamp", nullable = false)
	private LocalDateTime timestamp;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}

	public String getToCurrencyCode() {
		return toCurrencyCode;
	}

	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
}
