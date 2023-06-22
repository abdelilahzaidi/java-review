package be.bruxelleformation.models;

import be.bruxelleformation.models.account.Account;

import java.util.HashMap;
import java.util.Objects;
import java.util.StringJoiner;

public class Bank {
    private final String name;
    private HashMap<String, Account> accounts = new HashMap<>();

    private Bank(String name) {
        this.name = name;
    }

    public Bank(Bank bank) {
        this.name = bank.name;
        this.accounts = new HashMap(bank.accounts); //Deep copy
//        this.accounts = bank.accounts; //Shallow Copy
    }

    public static Bank creator() {
        Bank bank = new Bank("PicsouBank");
        //Lecture du fichier pour initialiser la bank
        return bank;
    }

    public String getName() {
        return name;
    }

    public Account get(String number) {
        return accounts.get(number);
    }

    public void addAccount(Account account) {
        if (accounts.containsKey(account.getNumber())) return;

        accounts.put(account.getNumber(), account);
    }

    public void removeAccount(String number) {
        if (!accounts.containsKey(number)) return;

        accounts.remove(number);
    }

    public void totalAmount(Person owner) {
//        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
//
//        for (CurrentAccount account : this.accounts.values()) {
//            if (account.getOwner().equals(owner)) {
//                sum = account.plus(sum);
//            }
//        }
//
//        System.out.println("Total: " + sum);
        double sum = this.accounts.values().stream()
                .filter(it -> it.getOwner().equals(owner))
                .mapToDouble(Account::getAmount)
                .filter(it -> it > 0)
                .sum();

        System.out.println("Total: " + sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return name.equals(bank.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bank.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }

    public int getLength() {
        return this.accounts.size();
    }
}
