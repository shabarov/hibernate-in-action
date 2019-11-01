package ru.shabarov.hibernate.model.tableperclass.join;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class JoinCreditCard extends JoinBillingDetails {

    @NotNull
    protected String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
