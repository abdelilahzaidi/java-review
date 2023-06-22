package be.bruxelleformation.models.account;

import be.bruxelleformation.models.Person;

import java.time.LocalDateTime;

public class SavingAccount extends Account {
    private LocalDateTime lastWithDrawDate;

    public SavingAccount(String number, Person owner) {
        super(number, owner);
    }

    public SavingAccount(String number, Person owner, double amount) {
        super(number, owner, amount);
    }

    public LocalDateTime getLastWithDrawDate() {
        return lastWithDrawDate;
    }

    @Override
    public void withdrawal(double amount) {
        if (this.getAmount() - amount < 0) return;

        super.withdrawal(amount);
        this.lastWithDrawDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "lastWithDrawDate=" + lastWithDrawDate +
                "} " + super.toString();
    }
}
