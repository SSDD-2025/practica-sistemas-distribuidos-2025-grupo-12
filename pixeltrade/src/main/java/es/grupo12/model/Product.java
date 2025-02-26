package es.grupo12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	private String descr;
    private double price;
    private String img;

	@ManyToOne
	private User buyer;

	@ManyToOne
	private User seller;

	
	

	public Product() {
		// Used by JPA
	}

	public Product(String title, String desc, double price, String img, User buyer, User seller) {
		this.title = title;
		this.descr = desc;
        this.price = price;
        this.img = img;
		this.buyer = buyer;
		this.seller = seller;

	}

    public long getId() {
        return this.id;
    }

	public String getTitle() {
		return this.title;
	}

	public String getDesc() {
		return this.descr;
	}

    public double getPrice() {
        return this.price;
    }

    public String getImg() {
        return this.img;
    }

	public User getBuyer(){
		return this.buyer;
	}

	public User getSeller(){
		return this.seller;
	}



	@Override
	public String toString() {
		return String.format("Product[id=%d, title='%s', desc='%s', price='%f']",
				id, title, descr, price);
	}
}