package ru.shabarov.hibernate.model.singletable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BD_TYPE")
public abstract class SingleBillingDetails {

    @Id
    @GeneratedValue
    protected long id;

    @NotNull
    @Column(nullable = false)
    protected String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SingleBillingDetails{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
