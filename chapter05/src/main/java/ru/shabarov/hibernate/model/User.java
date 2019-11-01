package ru.shabarov.hibernate.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    protected long id;

    protected Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "billing_city"))
    })
    protected Address billingAddress;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", address=" + address +
                ", billingAddress=" + billingAddress +
                '}';
    }
}
