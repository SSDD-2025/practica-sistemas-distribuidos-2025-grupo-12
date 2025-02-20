package es.grupo12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	private String desc;
    private double price;
    private String img;

	@OneToOne
	private User vendor;
	@OneToOne
	private User buyer;
	

	public Product() {
		// Used by JPA
	}

	public Product(String title, String desc, double price, String img, User vendor, User buyer) {
		this.title = title;
		this.desc = desc;
        this.price = price;
        this.img = img;
		this.vendor = vendor;
		this.buyer = buyer;
	}

    public long getId() {
        return this.id;
    }

	public String getTitle() {
		return this.title;
	}

	public String getDesc() {
		return this.desc;
	}

    public double getPrice() {
        return this.price;
    }

    public String getImg() {
        return this.img;
    }

	public User getVendor() {
		return this.vendor;
	}

	public User getBuyer() {
		return this.buyer;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, title='%s', desc='%s', price='%f']",
				id, title, desc, price);
	}
}