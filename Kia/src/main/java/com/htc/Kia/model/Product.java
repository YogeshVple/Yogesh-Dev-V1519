package com.htc.Kia.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(unique = true)
	private String productName;
	private String productCategory;
	private String productType;
	private float productLength;
	private float productDia;
	private float productDrive;
	private int productQuantity;
	private float productVolume;
	private String productFile;
	private String productDesc;
	private String productImage;
	
	public Product() {}

	public Product(int productId, String productName, String productCategory, String productType, float productLength,
			float productDia, float productDrive, int productQuantity, float productVolume, String productFile,
			String productDesc, String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productType = productType;
		this.productLength = productLength;
		this.productDia = productDia;
		this.productDrive = productDrive;
		this.productQuantity = productQuantity;
		this.productVolume = productVolume;
		this.productFile = productFile;
		this.productDesc = productDesc;
		this.productImage = productImage; 
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public float getProductLength() {
		return productLength;
	}

	public void setProductLength(float productLength) {
		this.productLength = productLength;
	}

	public float getProductDia() {
		return productDia;
	}

	public void setProductDia(float productDia) {
		this.productDia = productDia;
	}

	public float getProductDrive() {
		return productDrive;
	}

	public void setProductDrive(float productDrive) {
		this.productDrive = productDrive;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public float getProductVolume() {
		return productVolume;
	}

	public void setProductVolume(float productVolume) {
		this.productVolume = productVolume;
	}

	public String getProductFile() {
		return productFile;
	}

	public void setProductFile(String productFile) {
		this.productFile = productFile;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productType=" + productType + ", productLength=" + productLength
				+ ", productDia=" + productDia + ", productDrive=" + productDrive + ", productQuantity="
				+ productQuantity + ", productVolume=" + productVolume + ", productFile=" + productFile
				+ ", productDesc=" + productDesc + ", productImage=" + productImage + "]";
	}
	
	
}