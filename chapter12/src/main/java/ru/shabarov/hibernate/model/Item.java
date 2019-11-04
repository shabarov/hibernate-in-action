package ru.shabarov.hibernate.model;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    protected Long id;

    @OneToOne(fetch = FetchType.LAZY)
    protected User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
