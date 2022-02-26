import java.util.*;
public class RegularMember {
    private String firstName;
    private String lastName;
    private double totalSpending;
    private String payMethod; // pay method is new addition...
    private boolean isPremiumMember;
    private double bookstoreBalance = 0;


    public RegularMember(String firstName, String lastName, double totalSpending, String payMethod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSpending = totalSpending;
        this.payMethod = payMethod;
    }
    public RegularMember() {}
    public String getFirstName() { 
        return firstName; 
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getTotalSpending() {
        return totalSpending;
    }
    public void setTotalSpending(double totalSpending) {
        this.totalSpending = totalSpending;
    }
    public String getPayMethod() {
        return payMethod;
    }
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public void updateTotalSpent(double totalSpending) {
        this.totalSpending += totalSpending;
    }
    public void totalSpent(int booksBought, int CDsBought, int DVDsBought) {
        System.out.println("This member has spent a total of $" + totalSpending + " at the bookstore.");
    }
    public void receiptsTotal (int booksBought, int CDsBought, int DVDsBought) {
        System.out.println("The customer bought " + booksBought + " books for a total cost of $" + (7 * totalSpending));
        System.out.println("The customer bought " + CDsBought + " books for a total cost of $" + (12 * totalSpending));
        System.out.println("The customer bought " + DVDsBought + " books for a total cost of $" + (18 * totalSpending));
    }

    public boolean getIsPremiumMember() {
        return isPremiumMember;
    }
    public void setIsPremiumMember(boolean isPremium) {
        if (isPremium) {
            isPremiumMember = true;
        }
        else {
            isPremiumMember = false;
        }
    }

    public double getBookstoreBalance() {
        return bookstoreBalance;
    }
    public void setBookstoreBalance(double bookstoreProfit) {
        this.bookstoreBalance = bookstoreProfit + bookstoreBalance;
    }
}
