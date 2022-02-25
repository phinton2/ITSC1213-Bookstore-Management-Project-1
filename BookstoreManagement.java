import java.util.*;
public class BookstoreManagement {
    public static void main(String[] args) {
        boolean isRunning = true;
        Inventory purchase = new Inventory();
        ArrayList<RegularMember> reg = new ArrayList<>();
        ArrayList<PremiumMember> prem = new ArrayList<>();
        RegularMember r = null;
        PremiumMember p = null;

        PremiumMember payment = new PremiumMember();

        while (isRunning) {
            Scanner scnr = new Scanner(System.in);
            // see what user wants to do
            System.out.println("What would you like to do now? \n");
            System.out.println("1) Take customer order");
            System.out.println("2) View customer info"); // will include payment method, membership status, total spent at bookstore
            System.out.println("3) Check store inventory");
            System.out.println("4) Check store balance");
            System.out.println("5) Exit program");


            boolean choiceComplete = false;
            int num = scnr.nextInt();
            while(num == 1 && !choiceComplete) {
                /*====================================
                         TAKE CUSTOMER ORDER
                ====================================*/
                System.out.println("What is the customer's first name?");
                String firstName = scnr.next();
                System.out.println("What is the customer's last name?");
                String lastName = scnr.next();
                System.out.println("Is the customer a premium member? y/n");
                char letter = scnr.next().charAt(0);
                boolean isPremium = false;
                boolean paidPremium = false;
                if (letter == 'Y' || letter == 'y') {
                    isPremium = true;
                    System.out.println("Has customer paid monthly premium? y/n");
                    char letter2 = scnr.next().charAt(0);
                    if (letter2 == 'Y' || letter2 == 'y') {
                        paidPremium = true;
                    }
                }
                // else if (letter == 'N' || letter == 'n') {
                System.out.println("What is the customer's preferred payment method for this purchase?");
                System.out.println("\n1) Credit card\n2) Debit card\n3) Cash");
                int payMethodNum = scnr.nextInt();
                String payMethod = "";
                if (payMethodNum == 1) {
                    payMethod = "Credit card";
                    payment.setPayMethod(payMethod);
                }
                
                else if (payMethodNum == 2) {
                    payMethod = "Debit card";
                    payment.setPayMethod(payMethod);
                }
                
                else if (payMethodNum == 3) {
                    payMethod = "Cash";
                    payment.setPayMethod(payMethod);
                }
            
                RegularMember regMem = new RegularMember(firstName, lastName, 0, payMethod);
                PremiumMember premMem = new PremiumMember(firstName, lastName, 0, payMethod);
                reg.add(regMem);
                r = regMem;
                prem.add(premMem);
                p = premMem;
                r.setIsPremiumMember(isPremium);
                p.setIsPremiumMember(isPremium);


                System.out.println("Here's the customer's information: ");

                // is a premium member
                int lastIndex = 0;
                if (letter == 'Y' || letter == 'y') {
                        System.out.println("\nCustomer name: " + p.getFirstName() + " " + p.getLastName() + "\nPremium member? " + p.getIsPremiumMember() + "\nTotal spent at bookstore: " + "$" + p.getTotalSpending() + "\nPreferred Payment Method: " + p.getPayMethod() + "\n");              
                }
                // if regular member
                else if (letter == 'N' || letter == 'n') {
                        System.out.println("\nCustomer name: " + r.getFirstName() + " " + r.getLastName() + "\nPremium member? " + r.getIsPremiumMember() + "\nTotal spent at bookstore: " + "$" + r.getTotalSpending() + "\nPreferred Payment Method: " + r.getPayMethod() + "\n");
                }    

                // code below correctly loops through premium and regular member lists
                /*
                if (letter == 'Y' || letter == 'y') {
                    for (int i = 0; i < prem.size(); i++) {
                        System.out.println(prem.get(i).getFirstName());
                    }
                }
                if (letter == 'N' || letter == 'n') {
                    for (int i = 0; i < reg.size(); i++) {
                        System.out.println(reg.get(i).getFirstName());
                    }
                }*/
                choiceComplete = true;
            }


            while (num == 2 && !choiceComplete) {
                System.out.println("=====================================");
                System.out.println("        BOOKSTORE'S MEMBERS");
                System.out.println("=====================================");
                for (int i = 0; i < prem.size(); i++) {
                    System.out.println("\nCustomer name: " + prem.get(i).getFirstName() + " " + prem.get(i).getLastName() + "\nMembership Status: " + prem.get(i).getIsPremiumMember() + "\nTotal spent at bookstore: " + "$" + prem.get(i).getTotalSpending() + "\nPreferred Payment Method: " + prem.get(i).getPayMethod() + "\n");
                }

                choiceComplete = true;

            }


            while (num == 3 && !choiceComplete) {
                choiceComplete = true;

            }


            while (num == 4 && !choiceComplete) {
                choiceComplete = true;

            }


            while (num == 5 && !choiceComplete) {
                System.exit(0);
                choiceComplete = true;
            }
        }
    }
}
