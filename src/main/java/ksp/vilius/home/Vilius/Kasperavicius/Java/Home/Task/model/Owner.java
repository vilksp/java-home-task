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
@Table(name = "owner")
public class Owner extends BaseEntity {

    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "owner")
    @JsonIgnore
    private Building building;

}
