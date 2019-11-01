package ru.shabarov.hibernate.model.singletable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CC")
public class SingleCreditCard extends SingleBillingDetails {

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
