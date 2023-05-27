package com.example.revenda.entities;

import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String model;
	private String assembler;
	private String color;
	private Integer yearModel;
	private Double price;
	
	public Vehicle () {}

	public Vehicle(Long id, String model, String assembler, String color, Integer yearModel, Double price) {
		super();
		this.id = id;
		this.model = model;
		this.assembler = assembler;
		this.color = color;
		this.yearModel = yearModel;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAssembler() {
		return assembler;
	}

	public void setAssembler(String assembler) {
		this.assembler = assembler;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getYearModel() {
		return yearModel;
	}

	public void setYearModel(Integer yearModel) {
		this.yearModel = yearModel;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(id, other.id) && Objects.equals(price, other.price);
	}
	
	
	

}
