package ru.shabarov.hibernate.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;

@Entity
@FilterDef(name = "limitByUserRank",
        parameters = {
                @ParamDef(name = "maxUserRank", type = "int")
        })
@Filter(
        name = "limitByUserRank",
        condition = "RANK > :maxUserRank"
)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @Column(name = "RANK")
    private int rank;

//    Collection filter:
//    @Filter()
//    private Set<Bid> bids = new HashSet<>();

    protected User() {
    }

    @PostPersist
//    @PostUpdate
//    @PostLoad
//    @PostRemove
    public void logPersist() {
        Logger logger = LoggerFactory.getLogger(User.class);
        logger.info("User with username '{}' has been saved", this.getUsername());
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, int rank) {
        this.username = username;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return rank == user.rank &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, rank);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", rank=" + rank +
                '}';
    }
}
