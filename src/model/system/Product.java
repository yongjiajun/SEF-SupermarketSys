package model.system;

public class Product {

	// manages product details, manager can modify most, supplier modifies quantity
	// productLoad and productSave not implemented yet! (product.txt read/write)
	// product array can be stored in SupportSystem..?

	//TODO

	private String productName;
	private int stockQty;
	private String productID;
	private double productPrice;

	// to be overwritten by methods
	private boolean discountEligible = false;
	private double discountRate = 0;
	private double discountedPrice = 0;


	private boolean bulkSalesEligible = false;
	private int bulkSalesQty = 0;
	private double bulkSalesRate = 0;
	private boolean weightable = false;
	private double pricePerGram = 0;

	private int restockLvl = 0;
	private int reorderQty = 0;


	public Product(String productName, int stockQty, String productID, double productPrice) {
		this.productName = productName;
		this.stockQty = stockQty;
		this.productID = productID;
		this.productPrice = productPrice;
		// product name is ID, quantitySold is written to sales.txt and read from there
	}

	public void setProductName(String name) {
		this.productName = name;
	}

	public String getProductName() {
		return productName;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void addStockQty(int quantity)
	{
		this.stockQty += quantity;
	}

	public void reduceStockQty(int quantity)
	{
		this.stockQty -= quantity;
	}

	public String getProductId() {
		return productID;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double price)
	{
		this.productPrice = price;
	}

	public boolean getDiscountEligible() {
		return discountEligible;
	}

	public double getDiscountRate()
	{
		return discountRate;
	}

	public void setDiscountRate(double rate)
	{
//		double price = this.getProductPrice();
		this.discountRate = rate;

//		double total = 0;
//		double s;
// 		s = 100 - rate;
//		total = (s * price) / 100;
//		this.setProductPrice(total);


		if (rate > 0)
			this.discountEligible = true;
 		else if (rate == 0)
			this.discountEligible = false;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountPercentage) {
//		this.discountedPrice = discountPercentage;
		double price = this.getProductPrice();
		this.discountRate = discountPercentage;
		double total = 0;
		double s;
		s = 100 - discountPercentage;
		total = (s * price) / 100;

		this.discountedPrice = total;
 	}

	public boolean getBulkSalesEligible() {
		return bulkSalesEligible;
	}

	public double getBulkSalesRate() {
		return bulkSalesRate;
	}

	public double getBulkSalesQty() {
		return bulkSalesQty;
	}

	public void setBulkSales(double rate, int qty)
	{
		this.bulkSalesRate = rate;
		this.bulkSalesQty = qty;
		if (rate > 0 && qty != 0)
			this.bulkSalesEligible = true;
		else if (rate == 0 && qty == 0)
			this.bulkSalesEligible = false;
	}

	public boolean getWeightable()
	{
		return weightable;
	}

	public double getPricePerGram(){
		return pricePerGram;
	}

	public void setWeightable(double pricePerGram)
	{
		this.pricePerGram = pricePerGram;
		if (pricePerGram > 0)
			this.weightable = true;
		else if (pricePerGram == 0)
			this.weightable = false;
	}

	public void setRestockLvl(int restockLvl)
	{
		this.restockLvl = restockLvl;
	}

	public int getRestockLvl() {
		return restockLvl;
		// will be constantly monitored and restocks automatically
		// restocks will be done by addStockQty(int qty)
	}

	public void setReorderQty(int qty)
	{
		this.reorderQty = qty;
	}

	public int getReorderQty()
	{
		return reorderQty;
		// monitored
	}


}
