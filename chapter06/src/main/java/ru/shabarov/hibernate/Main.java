package ru.shabarov.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shabarov.hibernate.model.joined.JoinedBankAccont;
import ru.shabarov.hibernate.model.joined.JoinedCreditCard;
import ru.shabarov.hibernate.model.singletable.SingleBankAccont;
import ru.shabarov.hibernate.model.singletable.SingleCreditCard;
import ru.shabarov.hibernate.model.tableperclass.join.JoinBankAccont;
import ru.shabarov.hibernate.model.tableperclass.join.JoinCreditCard;
import ru.shabarov.hibernate.model.tableperclass.poly.BankAccont;
import ru.shabarov.hibernate.model.tableperclass.poly.CreditCard;
import ru.shabarov.hibernate.util.HibernateUtils;

import java.util.List;

public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String [] args) {

        HibernateUtils.doTransactional((em) -> {
            CreditCard creditCard = new CreditCard();
            creditCard.setCardNumber("123");
            creditCard.setOwner("John");

            BankAccont bankAccont = new BankAccont();
            bankAccont.setAccount("account");
            bankAccont.setOwner("Mike");

            em.persist(creditCard);
            em.persist(bankAccont);

            JoinCreditCard joinCreditCard = new JoinCreditCard();
            joinCreditCard.setCardNumber("123");
            joinCreditCard.setOwner("John");

            JoinBankAccont joinBankAccont = new JoinBankAccont();
            joinBankAccont.setAccount("account");
            joinBankAccont.setOwner("Mike");

            em.persist(joinCreditCard);
            em.persist(joinBankAccont);

            SingleBankAccont singleBankAccont = new SingleBankAccont();
            singleBankAccont.setAccount("account");
            singleBankAccont.setOwner("John");

            SingleCreditCard singleCreditCard = new SingleCreditCard();
            singleCreditCard.setCardNumber("1234");
            singleCreditCard.setOwner("Mike");

            em.persist(singleBankAccont);
            em.persist(singleCreditCard);

            JoinedBankAccont joinedBankAccont = new JoinedBankAccont();
            joinedBankAccont.setAccount("account");
            joinedBankAccont.setOwner("Mike");

            JoinedCreditCard joinedCreditCard = new JoinedCreditCard();
            joinedCreditCard.setCardNumber("12345");
            joinedCreditCard.setOwner("John");

            em.persist(joinedCreditCard);
            em.persist(joinedBankAccont);
            em.flush();

            List bds = em.createQuery("select bd from JoinBillingDetails bd").getResultList();
            bds = em.createQuery("select bd from SingleBillingDetails bd").getResultList();
            bds = em.createQuery("select bd from JoinedBillingDetails bd").getResultList();
        });

    }
}