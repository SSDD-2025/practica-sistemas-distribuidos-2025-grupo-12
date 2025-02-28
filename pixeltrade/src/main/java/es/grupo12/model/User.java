package es.grupo12.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    // @OneToMany(cascade = CascadeType.ALL)
    // private List<Review> sentReviews;
    
    // @OneToMany(cascade = CascadeType.ALL)
    // private List<Review> receivedReviews;


    
    public User(){
        
    }

    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        // sentReviews = new ArrayList<>();
        // receivedReviews = new ArrayList<>();
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

    // public List<Review> getReceivedReviews() {
    //     return receivedReviews;
    // }

    // public List<Review> getSentReviews() {
    //     return sentReviews;
    // }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", mail=" + mail + ", password=" + password;
                
    }
    
}
