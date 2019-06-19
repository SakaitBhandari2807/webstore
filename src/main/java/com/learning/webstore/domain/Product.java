package com.learning.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{
	private String productId;
	private String productName;
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private long unitsInOrder;
	private boolean discontinued;
	private String condition;
	private BigDecimal unitPrice;
	
	public Product() {
		super();
	}

	public Product(String productId, String productName, BigDecimal unitPrice) {
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) 
			return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Product other = (Product)obj;
		if(!productId.equals(other.productId)) return false;
		return true;
	}
	
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime*result+(productId==null?0:productId.hashCode());
		return result;
	}

}
