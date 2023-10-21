package org.fiserv.dojo.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Customer extends PanacheEntity {
    public String FirstName;
    public String LastName;
    public String Address;
}
