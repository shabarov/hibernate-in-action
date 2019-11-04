package ru.shabarov.hibernate.model;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Check(constraints = "AUCTIONSTART < AUCTIONEND")
@Table(
        name = "USERS",
        indexes = {
                @Index(
                        name = "IDX_USERNAME",
                        columnList = "USERNAME"
                ),
                @Index(
                        name = "IDX_USERNAME_EMAIL",
                        columnList = "USERNAME, EMAIL"
                )
        }
)
public class User {

    @Id
//    @Column(
//            columnDefinition = "varchar(15) not null unique check (not substring(lower(USERNAME), 0, 5) = `admin`"
//    )
    protected String username;

    @Column(
            nullable = false,
            unique = true,
            columnDefinition = "EMAIL_ADDRESS(255)"
    )
    protected String email;

    @NotNull
    protected Date auctionStart;

    @NotNull
    protected Date auctionEnd;

    protected User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String email, @NotNull Date auctionStart, @NotNull Date auctionEnd) {
        this.username = username;
        this.email = email;
        this.auctionStart = auctionStart;
        this.auctionEnd = auctionEnd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(Date auctionStart) {
        this.auctionStart = auctionStart;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }
}
