package com.esprit.agentms.entities;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agent {
    @Id
    @Indexed
            @Setter(AccessLevel.MODULE)
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private String phone;
    private String agency;

    public Agent(String fname,String lname,String agency, String email, String phone)
    {
        this.agency = agency;
        this.phone = phone;
        this.email = email;
        this.firstName = fname;
        this.lastName = lname;
    }
    @Override
    public String toString() {
        return "Agent{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
