package be.bruxelleformation;

import be.bruxelleformation.models.Bank;
import be.bruxelleformation.models.Person;
import be.bruxelleformation.models.account.CurrentAccount;
import be.bruxelleformation.models.account.SavingAccount;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person owner = new Person("Ovyn", "Flavian", LocalDate.of(1991, 7, 19));

        CurrentAccount ca = new CurrentAccount("BE12 1234 1234 1234", owner, 50, 50);
        SavingAccount sa = new SavingAccount("BE12 1234 1234 1235", owner, 50);

        Bank bank = Bank.creator();
        bank.addAccount(ca);
        bank.addAccount(sa);

        //Se connecter au sytème bancaire









        System.out.println("Possedz-vous un compte : oui/non ?");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
    boolean end=false;
   while (!choix.equals("q") && end ==false){
            switch (choix) {

                case "oui": connected();
                    break;
                case "non":register();

                    break;
                case "q":  end =true;
                    System.out.println("Session quittée !!");
                    break;
                default:
                    System.out.println("Choix indefinis!!!");
                    break;
                }

             //System.out.println("Faites un choix");

            choix = sc.nextLine();
         }
        System.out.println("Fin du processus");


    }
    static void connected(){
        Person owner = new Person("Ovyn", "Flavian", LocalDate.of(1991, 7, 19));
        CurrentAccount ca = new CurrentAccount("BE12 1234 1234 1234", owner, 50, 50);
        SavingAccount sa = new SavingAccount("BE12 1234 1234 1235", owner, 50);

        Bank bank = Bank.creator();
        bank.addAccount(ca);
        bank.addAccount(sa);




        //ouiSystem.out.println("connected"+bank.addAccount(ca));
    }
    static void register(){
        System.out.println("Register");
    }



}

