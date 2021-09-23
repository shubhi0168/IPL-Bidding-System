package app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private int accno;
    private int balance;

    public Account() {
    }

    public Account(int accno, int balance) {
        this.accno = accno;
        this.balance = balance;
    }


    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accno=" + accno +
                ", balance=" + balance +
                '}';
    }

}
