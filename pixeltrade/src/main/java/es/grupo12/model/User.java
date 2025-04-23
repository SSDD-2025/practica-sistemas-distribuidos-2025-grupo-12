package es.grupo12.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column (unique = true)
    private String username;

    @Column (unique = true)
    private String mail;
    private String password;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Product> products;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Review> sentReviews;
    
    @OneToMany( mappedBy ="seller",cascade =CascadeType.REMOVE, orphanRemoval = true)
    private List<Review> receivedReviews;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Message> sentMessages;
    
    @OneToMany( mappedBy ="receiver",cascade =CascadeType.REMOVE)
    private List<Message> receivedMessages;

    @ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;


    
    public User(){
        
    }

    public User(String username, String mail, String password, String... roles) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        sentReviews = new ArrayList<>();
        receivedReviews = new ArrayList<>();
        this.roles = List.of(roles);
    }

    public String getUsername(){
        return this.username;
    }


    public String getEmail() {
        return this.mail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public List<Review> getReceivedReviews() {
        return receivedReviews;
    }

    public List<Review> getSentReviews() {
        return sentReviews;
    }
    public List<Product> getProducts() {
        return products;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", mail=" + mail + ", password=" + password;
                
    }

    public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

    
    
}
