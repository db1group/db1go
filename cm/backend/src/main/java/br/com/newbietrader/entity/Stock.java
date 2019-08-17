package br.com.newbietrader.entity;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public class Stock {

	private ObjectId id;

	private String name;

	private LocalDate date;

	private StockValue value;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public StockValue getValue() {
		return value;
	}

	public void setValue(StockValue value) {
		this.value = value;
	}


}
