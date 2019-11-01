package ru.shabarov.hibernate.model.joined;

import javax.persistence.Entity;

@Entity
public class JoinedBankAccont extends JoinedBillingDetails {

    protected String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "SingleBankAccont{" +
                "account='" + account + '\'' +
                ", id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
