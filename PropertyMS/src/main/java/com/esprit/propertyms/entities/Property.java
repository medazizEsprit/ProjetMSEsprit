package com.esprit.propertyms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String address;

    private Double price;

    private String agentEmail; // Id de l'agent (référence à Agent Service)

    public Property(String title, String address, Double price, String agentId) {
        this.title = title;
        this.address = address;
        this.price = price;
        this.agentEmail = agentId;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", agentEmail='" + agentEmail + '\'' +
                '}';
    }
}
