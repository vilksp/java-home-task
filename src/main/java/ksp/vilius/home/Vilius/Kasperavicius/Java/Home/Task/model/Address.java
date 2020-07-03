package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    private String city;
    private String street;
    private int number;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Building building;


}
