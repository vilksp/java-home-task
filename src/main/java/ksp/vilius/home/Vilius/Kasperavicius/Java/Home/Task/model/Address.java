package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    private String city;
    private String street;
    private int number;

    @OneToOne
    private  Building building;

}
