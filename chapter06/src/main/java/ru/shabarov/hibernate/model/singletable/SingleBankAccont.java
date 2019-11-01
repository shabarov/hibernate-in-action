package ru.shabarov.hibernate.model.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("BA")
public class SingleBankAccont extends SingleBillingDetails {

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
