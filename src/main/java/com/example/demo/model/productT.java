
package  com.example.demo.demo.model;

import jakarta.persistence.*;

@Entity
public class Product{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    //getter
    public Long getId() {return id;}
    public String getName() {return name;}
    public double getPrice(){return price;}
    //setter
    public void setId(Long id){this.id=id;}
    public void setName(String name){this.name= name;}
    public void setPrice(double price){this.price=price;}
}