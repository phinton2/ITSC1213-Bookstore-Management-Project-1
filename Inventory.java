public class Inventory {
    private int stockSize;
    private int productPrice;
    private int totalPurchasePrice;

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
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    public int getPurchaseTotal(int numBooks, int numCDs, int numDVDs) {
        this.totalPurchasePrice = (7 * numBooks) + (12 * numCDs) + (18 * numDVDs);
        return totalPurchasePrice;
    }
    public void setPurchaseTotal(int totalPurchasePrice) {
        this.totalPurchasePrice = totalPurchasePrice;
    }

    public void deductStockSize (int productsSold) {
        this.stockSize = stockSize - productsSold;
    }
    public void setTotalPurchasePrice(int numBooks, int numCDs, int numDVDs) {
        System.out.println((7 * numBooks) + (12 * numCDs) + (18 * numDVDs));
    }

}
