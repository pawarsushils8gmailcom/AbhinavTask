package com.admin.product.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_info")
public class Product implements Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private Integer id;
	
	 @Column(name="product_name", nullable=false)
	 private String productName;
	 @Column(name="sku", nullable=false)
	 private String sku;
	 @Column(name="description", nullable=false)
	 private String description;
	 
	 @Column(name="price", nullable=false)
	 private Float price;
	 @Column(name="stock_level", nullable=false)
	 private Integer stockLevel;
	 
	 @Column(name="email")
	 private String email;
	 @Column(name="status")
	 private String status;
	 
	 @Column(name="create_date")
	 private LocalDate createDate;
	 @Column(name="update_date")
	 private LocalDate updateDate;
	 
	 @Column(name="create_time")
	 private LocalTime createTime;
	 @Column(name="update_time")
	 private LocalTime updateTime;
	 
	 

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
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
		return "Product [id=" + id + ", productName=" + productName + ", sku=" + sku + ", description=" + description
				+ ", price=" + price + ", stockLevel=" + stockLevel + ", email=" + email + "]";
	}

	public boolean equals(Object arg0) {
		return description.equals(arg0);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public LocalTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalTime createTime) {
		this.createTime = createTime;
	}

	public LocalTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalTime updateTime) {
		this.updateTime = updateTime;
	}
	 
	 
	 
	 
	

}
