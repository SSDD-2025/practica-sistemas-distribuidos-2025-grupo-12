package es.grupo12.model;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;



@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	private String descr;
    private double price;
	@Lob
    private Blob img;

	@ManyToOne
	private User buyer;

	@ManyToOne
	private User seller;

	
	

	

	public Product(String title, String descr, double price, User buyer, User seller) {
		this.title = title;
		this.descr = descr;
		this.price = price;
		this.buyer = buyer;
		this.seller = seller;
	}



	public Product() {
		// Used by JPA
	}

    public long getId() {
        return this.id;
    }

	public String getTitle() {
		return this.title;
	}


    public double getPrice() {
        return this.price;
    }
    
	public User getBuyer(){
		return this.buyer;
	}

	public User getSeller(){
		return this.seller;
	}

	public Blob getImg() {
		return img;
	}

	public String getDescr() {
		return descr;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, title='%s', desc='%s', price='%f']",
				id, title, descr, price);
	}

	public void setImg(Blob img) {
		this.img = img;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setDescr(String descr) {
		this.descr = descr;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}



	public void setSeller(User seller) {
		this.seller = seller;
	}

	

	

	
}