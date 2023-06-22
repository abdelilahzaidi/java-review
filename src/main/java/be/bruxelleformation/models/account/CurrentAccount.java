package be.bruxelleformation.models.account;

import be.bruxelleformation.models.Person;

public class CurrentAccount extends Account {
    private double creditLine;

    public CurrentAccount(String number, Person owner) {
        super(number, owner);
        this.creditLine = 0;
    }

    public CurrentAccount(String number, Person owner, double amount) {
        super(number, owner, amount);
        this.creditLine = 0;
    }

    public CurrentAccount(String number, Person owner, double amount, double creditLine) {
        super(number, owner, amount);
        this.creditLine = creditLine;
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }

    @Override
    public void withdrawal(double amount) {
        if (this.getAmount() - amount < -this.creditLine) return;

        super.withdrawal(amount);
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "creditLine=" + creditLine +
                "} " + super.toString();
    }
}
