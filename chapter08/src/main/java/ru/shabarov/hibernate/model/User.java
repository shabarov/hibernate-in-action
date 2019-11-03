package ru.shabarov.hibernate.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    protected long id;

    protected String username;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
//            cascade = CascadeType.PERSIST
    )
    @PrimaryKeyJoinColumn
//    @JoinColumn(unique = true)
    protected Address address;

    public User() {
    }

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address=" + address +
                '}';
    }
}
