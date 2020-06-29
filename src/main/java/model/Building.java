package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Building extends BaseEntity {

    private Address address;

    private Owner owner;

    private double size;

    private double marketVal;

    private PropertyType propertyType;
}
