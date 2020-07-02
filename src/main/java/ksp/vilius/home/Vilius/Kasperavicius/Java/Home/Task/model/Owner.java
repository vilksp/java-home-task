package ksp.vilius.home.Vilius.Kasperavicius.Java.Home.Task.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner extends BaseEntity {

    private String firstName;
    private String lastName;

    @OneToOne
    private Building building;


}
