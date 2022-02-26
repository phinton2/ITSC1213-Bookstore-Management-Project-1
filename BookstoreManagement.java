import java.util.*;
public class BookstoreManagement {
    public static void main(String[] args) {
        boolean isRunning = true;
        boolean paidPremium = false;
        Scanner scnr = new Scanner(System.in);
        Inventory purchase = new Inventory();
        ArrayList<RegularMember> reg = new ArrayList<>();
        ArrayList<PremiumMember> prem = new ArrayList<>();
        List<Double> balance = new ArrayList<>();
        RegularMember r = null;
        PremiumMember p = null;

        PremiumMember payment = new PremiumMember();
        RegularMember receipt = new RegularMember();

        Inventory book = new Inventory();
        Inventory cd = new Inventory();
        Inventory dvd = new Inventory();
        Inventory finalOrder = new Inventory();

        double bookstoreBalance = 0;
        book.setStockSize((int)(5 + Math.random() * 15));
        cd.setStockSize((int)(5 + Math.random() * 15));
        dvd.setStockSize((int)(5 + Math.random() * 15));

        // displays welcome
        System.out.println("*******************************************");
        System.out.println("Welcome to the Bookstore Management System!");
        System.out.println("*******************************************");

        while (isRunning) {
            // see what user wants to do
            System.out.println("\nWhat would you like to do now? \n");
            System.out.println("1) Take customer order");
            System.out.println("2) View customer info"); // will include payment method, membership status, total spent at bookstore
            System.out.println("3) Check store inventory");
            System.out.println("4) Check store balance");
            System.out.println("5) Exit program");


            boolean choiceComplete = false;
            int num = scnr.nextInt();

            // takes customer order
            while(num == 1 && !choiceComplete) {
                /*====================================
                         TAKE CUSTOMER ORDER
                ====================================*/
                System.out.println("What is the customer's first name?");
                String firstName = scnr.next();
                System.out.println("What is the customer's last name?");
                String lastName = scnr.next();
                System.out.println("Is the customer a premium member? (y/n)");
                char letter = scnr.next().charAt(0);
                char letter2;
                boolean isPremium = false;
                paidPremium = false;
                if (letter == 'Y' || letter == 'y') {
                    isPremium = true;
                    System.out.println("Has customer paid $25 monthly premium fee? (y/n)");
                    letter2 = scnr.next().charAt(0);
                    if (letter2 == 'Y' || letter2 == 'y') {
                        paidPremium = true;
                        finalOrder.setBookstoreBalance(25);
                    }
                }

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
                // if premium member
                if (letter == 'Y' || letter == 'y') {
                        System.out.println("\nCustomer name: " + p.getFirstName() + " " + p.getLastName() + "\nPremium member? " + p.getIsPremiumMember() + "\nPaid monthly premium? " + paidPremium + "\nTotal spent at bookstore: " + "$" + p.getTotalSpending() + "\nPreferred Payment Method: " + p.getPayMethod() + "\n");              
                }
                // if regular member
                else if (letter == 'N' || letter == 'n') {
                        System.out.println("\nCustomer name: " + r.getFirstName() + " " + r.getLastName() + "\nPremium member? " + r.getIsPremiumMember() + "\nPaid monthly premium? " + paidPremium + "\nTotal spent at bookstore: " + "$" + r.getTotalSpending() + "\nPreferred Payment Method: " + r.getPayMethod() + "\n");
                }    

                // Display what store has on sale
                System.out.println("What the bookstore has on sale now: ");
                System.out.println("1) The Art of War - $5.99 (Book)");
                System.out.println("2) Studio Ghibli Soundtrack - $19.99 (CD)");
                System.out.println("3) Up - $7.99 (DVD)");

                int booksPurchased = 0;
                int cdsPurchased = 0;
                int dvdsPurchased = 0;

                // BOOKS
                if (book.getStockSize() > 0) {
                    System.out.println("\nWould the customer like to purchase the book \"The Art of War\"? (y/n)");
                    char confirmBookPurchase = scnr.next().charAt(0);
                    if (confirmBookPurchase == 'Y' || confirmBookPurchase == 'y') { 
                        System.out.println("How many books does the customer want to purchase?");
                        booksPurchased = scnr.nextInt();
                        if (booksPurchased > book.getStockSize()) {
                            System.out.println("We only have " + book.getStockSize() + " copies of \"The Art of War\" available. Would you like to purchase the remaining copies? (y/n)");
                            char purchaseRemainingBooks = scnr.next().charAt(0);
                            if (purchaseRemainingBooks == 'Y' || purchaseRemainingBooks == 'y') {
                                booksPurchased = book.getStockSize();
                                book.setStockSize(0);
                            }
                            else if (book.getStockSize() == 0) {
                                booksPurchased = book.getStockSize();
                            }
                            else if (purchaseRemainingBooks == 'N' || purchaseRemainingBooks == 'n') {
                                book.setStockSize(0);
                            }
                        }
                        if (booksPurchased <= book.getStockSize()) {
                        book.deductStockSize(booksPurchased);
                        book.setTotalBookPrice(booksPurchased);
                        }
                    }
                    else if (confirmBookPurchase == 'N' || confirmBookPurchase == 'n') {
                        book.deductStockSize(booksPurchased);
                        book.setTotalBookPrice(booksPurchased);
                    }
                }
                else if (book.getStockSize() <= 0) {
                    System.out.println("\nWe're sorry, book \"The Art of War\" is currently out of stock.");
                }
                book.setTotalBookPrice(booksPurchased);

                // CDS
                System.out.println("\nWould the customer like to purchase the CD \"Studio Ghibli Soundtrack\"? (y/n)");
                char confirmCDPurchase = scnr.next().charAt(0);
                if (confirmCDPurchase == 'Y' || confirmCDPurchase == 'y') {
                    System.out.println("How many CDs does the customer want to purchase?");
                    cdsPurchased = scnr.nextInt();
                    if (cdsPurchased > cd.getStockSize()) {
                        System.out.println("We only have " + cd.getStockSize() + " copies of \"Studio Ghibli Soundtrack\" available. Would you like to purchase the remaining copies? (y/n)");
                        char purchaseRemainingCDs = scnr.next().charAt(0);
                        if (purchaseRemainingCDs == 'Y' || purchaseRemainingCDs == 'y') {
                            cdsPurchased = cd.getStockSize();
                            cd.setStockSize(0);
                        }
                        else if (cd.getStockSize() == 0) {
                            cdsPurchased = cd.getStockSize();
                        }
                        else if (purchaseRemainingCDs == 'N' || purchaseRemainingCDs == 'n') {
                            cd.setStockSize(0);
                        }
                    }
                    if (cdsPurchased <= cd.getStockSize()) {
                        cd.deductStockSize(cdsPurchased);
                        cd.setTotalBookPrice(cdsPurchased);
                    }
                }
                else if (confirmCDPurchase == 'N' || confirmCDPurchase == 'n') {
                    cd.deductStockSize(cdsPurchased);
                    cd.setTotalCDPrice(cdsPurchased);
                }
                else if (cd.getStockSize() <= 0) {
                    System.out.println("\nWe're sorry, the CD \"Studio Ghlibi Sountrack\" is currently out of stock.");
                }
                cd.setTotalCDPrice(cdsPurchased);


                // DVDS
                System.out.println("\nWould the customer like to purchase the DVD \"Up\"? y/n");
                char confirmDVDPurchase = scnr.next().charAt(0);
                if (confirmDVDPurchase == 'Y' || confirmDVDPurchase == 'y') {
                    System.out.println("How many DVDs does the customer want to purchase?");
                    dvdsPurchased = scnr.nextInt();
                    if (dvdsPurchased > dvd.getStockSize()) {
                        System.out.println("We only have " + dvd.getStockSize() + " copies of \"Up\" available. Would you like to purchase the remaining copies? (y/n)");
                        char purchaseRemainingDVDS = scnr.next().charAt(0);
                        if (purchaseRemainingDVDS == 'Y' || purchaseRemainingDVDS == 'y') {
                            dvdsPurchased = dvd.getStockSize();
                            dvd.setStockSize(0);
                        }
                        else if (dvd.getStockSize() == 0) {
                            dvdsPurchased = dvd.getStockSize();
                        }
                        else if (purchaseRemainingDVDS == 'N' || purchaseRemainingDVDS == 'n') {
                            dvd.setStockSize(0);
                        }
                    }
                    if (dvdsPurchased <= 0) {
                        dvd.deductStockSize(dvdsPurchased);
                        dvd.setTotalDVDPrice(dvdsPurchased);
                    }
                }
                else if (confirmDVDPurchase == 'N' || confirmDVDPurchase == 'n') {
                    dvd.deductStockSize(dvdsPurchased);
                    dvd.setTotalDVDPrice(dvdsPurchased);
                }
                else if (dvd.getStockSize() <= 0) {
                    System.out.println("\nWe're sorry, the DVD \"Up\" is currently out of stock.");
                }
                dvd.setTotalDVDPrice(dvdsPurchased);

                finalOrder.setTotalPurchasePrice(booksPurchased, cdsPurchased, dvdsPurchased);
                double totalSpending = finalOrder.getPurchaseTotal(booksPurchased, cdsPurchased, dvdsPurchased);
                r.setTotalSpending(totalSpending);
                p.setTotalSpending(totalSpending);
                
                System.out.println("RECEIPT");
                System.out.println("The customer is ordering " + booksPurchased + " book(s) for a total of $" + book.getTotalBookPrice());
                System.out.println("The customer is ordering " + cdsPurchased + " CD(s) for a total of $" + cd.getTotalCDPrice());
                System.out.println("The customer is ordering " + dvdsPurchased + " DVD(s) for a total of $" + dvd.getTotalDVDPrice());

                System.out.println("Initial total would have been: $" + finalOrder.getPurchaseTotal(booksPurchased, cdsPurchased, dvdsPurchased));
                double tempStoreBalance;
                if (p.getIsPremiumMember() == true) {
                    System.out.println("Given customer's premium membership the amount is now: $" + (finalOrder.getPurchaseTotal(booksPurchased, cdsPurchased, dvdsPurchased) * .6));
                    tempStoreBalance = (finalOrder.getPurchaseTotal(booksPurchased, cdsPurchased, dvdsPurchased) * .6) + bookstoreBalance;
                    // p.setBookstoreBalance(tempStoreBalance);
                    p.setTotalSpending(tempStoreBalance);
                }
                else if (p.getIsPremiumMember() == false) {
                    System.out.println("Given customer's regular membership the amount is now: $" + (finalOrder.getPurchaseTotal(booksPurchased, cdsPurchased, dvdsPurchased) * .85));
                    tempStoreBalance = bookstoreBalance + (finalOrder.getPurchaseTotal(booksPurchased, cdsPurchased, dvdsPurchased) * .85);
                    // p.setBookstoreBalance(tempStoreBalance);
                    p.setTotalSpending(tempStoreBalance);
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

                for (int i = 0; i < prem.size(); i++) {
                balance.add(prem.get(i).getTotalSpending());
                }
                choiceComplete = true;
            }


            while (num == 2 && !choiceComplete) { // COMPLETE
                /*====================================
                     VIEW ALL MEMBERS INFORMATION
                ====================================*/
                System.out.println("=====================================");
                System.out.println("        BOOKSTORE'S MEMBERS");
                System.out.println("=====================================");
                for (int i = 0; i < prem.size(); i++) {
                    System.out.println("\nCustomer name: " + prem.get(i).getFirstName() + " " + prem.get(i).getLastName() + "\nPremium member? " + prem.get(i).getIsPremiumMember() + "\nPaid monthly premium? " + paidPremium + "\nTotal spent at bookstore: " + "$" + prem.get(i).getTotalSpending() + "\nPreferred Payment Method: " + prem.get(i).getPayMethod() + "\n");
                }
                choiceComplete = true;
            }


            while (num == 3 && !choiceComplete) { // COMPLETE
                 /*====================================
                         CHECK STORE INVENTORY
                ====================================*/
                System.out.println("=====================================");
                System.out.println("          STORE INVENTORY");
                System.out.println("=====================================");
                System.out.println("There are " + book.getStockSize() + " books remaining in stock.");
                System.out.println("There are " + cd.getStockSize() + " CDs remaining in stock.");
                System.out.println("There are " + dvd.getStockSize() + " DVDs remaining in stock.");

                choiceComplete = true;

            }


            while (num == 4 && !choiceComplete) {
                /*====================================
                         CHECK STORE BALANCE
                ====================================*/
                // lists values (correct); now sum them up
                if (prem.size() <= 1) {
                    System.out.println("Trying checking your balance later on once you have more business!");
                }
                for (int i = 0; i < prem.size(); i++) {
                    for (int j = i + 1; j < prem.size(); j++) {
                    System.out.println("The bookstore's current balance is $" + prem.get(i).getTotalSpending() + prem.get(j).getTotalSpending());
                    }
                }
                // stores last value issue: fix
                choiceComplete = true;
            }


            while (num == 5 && !choiceComplete) {
                 /*====================================
                            EXIT PROGRAM
                ====================================*/
                System.exit(0);
                choiceComplete = true;
            }
        }
    }
}
