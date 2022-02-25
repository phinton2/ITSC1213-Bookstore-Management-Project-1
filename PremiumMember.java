public class PremiumMember extends RegularMember {
    private String payMethod;
    private boolean isPremiumMember;

    public PremiumMember(String firstName, String lastName, double totalSpending, String payMethod) {
        super(firstName, lastName, totalSpending, payMethod); // new addition...
        this.payMethod = payMethod;
    }
    public PremiumMember() {}
    
    public String getPayMethod() {
        return payMethod;
    }
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    public boolean getIsPremiumMember() {
        return isPremiumMember;
    }
    public void setIsPremiumMember(boolean isPremium) {
        if (isPremium) {
            isPremiumMember = true;
        }
        else if (!isPremium) {
            isPremiumMember = false;
        }
    }
}
