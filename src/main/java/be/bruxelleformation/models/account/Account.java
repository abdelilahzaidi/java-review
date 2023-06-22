package be.bruxelleformation.models.account;

import be.bruxelleformation.models.Person;

import java.util.Objects;
import java.util.StringJoiner;

public class Account {
    private String number;
    private double amount;
    private Person owner;

    public Account(String number, Person owner) {
        this.setNumber(number);
        this.setOwner(owner);
        this.amount = 0;
    }

    public Account(String number, Person owner, double amount) {
        this(number, owner);
        this.amount = amount;
    }

    public String getNumber() {
        return this.number;
    }

    private void setNumber(String number) {
        if (number == null) return;
        if (number.length() != 19) return;

        this.number = number;
    }

    public double getAmount() {
        return this.amount;
    }

    public Person getOwner() {
        return new Person(this.owner);
    }

    private void setOwner(Person owner) {
        if (owner == null) return;

        this.owner = owner;
    }

    /**
     * @param amount double > 0
     */
    public void deposit(double amount) {
        if (amount <= 0) return;

        this.amount += amount;
    }

    public void withdrawal(double amount) {
        if (amount <= 0) return;

        this.amount -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("number='" + number + "'")
                .add("amount=" + amount)
                .add("owner=" + owner)
                .toString();
    }

    public double plus(double amount) {
        return amount + (this.amount > 0 ? this.amount : 0);
    }
}
