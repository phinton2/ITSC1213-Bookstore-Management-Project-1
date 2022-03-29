/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagementproject1;


/**
 *
 * @author Paydreanne E. Hinton
 * instructor Professor Van Custodio
 * courseSection ITSC1213-106-27949
 * Bookstore Management Project 1
 * Subclass for Membership - Regular Member
 */
public class Regular extends Membership implements displayzz {
    public Regular() {
        super();
    }
    public Regular(String firstName, String lastName, double totalSpending, String payMethod, boolean isPremiumMember, boolean hasPaidPremium) {
        super(firstName, lastName, totalSpending, payMethod, false, false);
    }

    @Override
    public void display() {
        String nameInfo = "Customer Name: " + this.getFirstName() + " " + this.getLastName() + "\n";
        String payInfo = "Total spent: $" + this.getTotalSpending() + "\nPay Method: " + this.getPayMethod() + "\n";
        String memberInfo = "Is a premium member?   " + this.getIsPremiumMember() +"\nHas paid premium fee?     " + this.getHasPaidPremium() + "\n";
        System.out.println(nameInfo + payInfo + memberInfo);
    }
}

