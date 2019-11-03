package ru.shabarov.hibernate.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

    @Id
    @GeneratedValue
    protected long id;

    @NotNull
    protected String city;

//    @OneToOne(optional = false)
//    @PrimaryKeyJoinColumn
//    protected User user;

    public Address() {

    }

    public Address(@NotNull String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
