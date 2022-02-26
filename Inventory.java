public class Inventory {
    private int stockSize;
    private double productPrice;
    private double totalPurchasePrice;
    private double totalBookPrice;
    private double totalCDPrice;
    private double totalDVDPrice;
    private double bookstoreBalance = 0;

    public Inventory(int productPrice, int stockSize) {
        this.productPrice = productPrice;
        this.stockSize = stockSize;
    }
    public Inventory() {}
    public int getStockSize() {
        return stockSize;
    }
    public void setStockSize(int stockSize) {
        this.stockSize = stockSize;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    // Books price total
    public double getTotalBookPrice() {
        return totalBookPrice;
    }
    public void setTotalBookPrice(int numBooks) {
        this.totalBookPrice = (7 * numBooks);
    }

    // CD price total
    public double getTotalCDPrice() {
        return totalCDPrice;
    }
    public void setTotalCDPrice(int numCDs) {
        this.totalCDPrice = (12 * numCDs);
    }

    // DVD price total
    public double getTotalDVDPrice() {
        return totalDVDPrice;
    }
    public void setTotalDVDPrice (int numDVDs) {
        this.totalDVDPrice = (18 * numDVDs);
    }

    public double getPurchaseTotal(int numBooks, int numCDs, int numDVDs) {
        this.totalPurchasePrice = (7 * numBooks) + (12 * numCDs) + (18 * numDVDs);
        return totalPurchasePrice;
    }
    public void setPurchaseTotal(double totalPurchasePrice) {
        this.totalPurchasePrice = totalPurchasePrice;
    }

    public void deductStockSize (int productsSold) {
        this.stockSize = stockSize - productsSold;
    }
    public void setTotalPurchasePrice(int numBooks, int numCDs, int numDVDs) {
        System.out.println((7 * numBooks) + (12 * numCDs) + (18 * numDVDs));
    }

    public double getBookstoreBalance() {
        return bookstoreBalance;
    }
    public void setBookstoreBalance(double bookstoreProfit) {
        this.bookstoreBalance = bookstoreProfit + bookstoreBalance;
    }
}
