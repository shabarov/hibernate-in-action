package ru.shabarov.hibernate.model.joined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "CREDITCARD_ID")
public class JoinedCreditCard extends JoinedBillingDetails {

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
        return "SingleCreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}
