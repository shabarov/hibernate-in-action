package ru.shabarov.hibernate.model.tableperclass.join;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class JoinBillingDetails {

    @Id
    @GeneratedValue
    protected long id;

    @NotNull
    protected String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BillingDetails{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
