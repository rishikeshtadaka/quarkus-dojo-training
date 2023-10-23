package org.fiserv.dojo.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Customer extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name="customer_seq",sequenceName="customer_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    public Long id;
    @Column(length = 100)
    public String FirstName;
    @Column(length = 100)
    public String LastName;
    public String Address;
}
