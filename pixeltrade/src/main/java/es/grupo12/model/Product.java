package es.grupo12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	private String descr;
    private double price;
    private String img;

	
	

	public Product() {
		// Used by JPA
	}

	public Product(String title, String desc, double price, String img) {
		this.title = title;
		this.descr = desc;
        this.price = price;
        this.img = img;
		
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



	@Override
	public String toString() {
		return String.format("Product[id=%d, title='%s', desc='%s', price='%f']",
				id, title, descr, price);
	}
}