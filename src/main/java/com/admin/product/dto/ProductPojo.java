package com.admin.product.dto;

public class ProductPojo {
	
	private Integer id;
	private String productName;
	private String sku;
	private Float price;
	private String description;
	private Integer stockLevel;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(Integer stockLevel) {
		this.stockLevel = stockLevel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ProductPojo [id=" + id + ", productName=" + productName + ", sku=" + sku + ", price=" + price
				+ ", description=" + description + ", stockLevel=" + stockLevel + ", email=" + email + "]";
	}

}
