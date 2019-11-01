package ru.shabarov.hibernate.model.tableperclass.poly;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BillingDetails {

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
                "owner='" + owner + '\'' +
                '}';
    }
}
