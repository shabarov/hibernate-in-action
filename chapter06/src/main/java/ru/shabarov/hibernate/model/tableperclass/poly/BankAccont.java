package ru.shabarov.hibernate.model.tableperclass.poly;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class BankAccont extends BillingDetails {

    @Id
    @GeneratedValue
    protected long id;

    protected String account;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "BankAccont{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
