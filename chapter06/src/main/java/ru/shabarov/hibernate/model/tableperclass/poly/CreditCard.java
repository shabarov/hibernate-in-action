package ru.shabarov.hibernate.model.tableperclass.poly;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AttributeOverride(
        name = "owner",
        column = @Column(name = "CC_OWNER", nullable = false)
)
public class CreditCard extends BillingDetails {

    @Id
    @GeneratedValue
    protected long id;

    @NotNull
    protected String cardNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
