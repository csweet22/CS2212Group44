package cryptoTrader.utils;

/**
 * An object that contains the information a trade has
 * @author Nathan Chan & Nick Barrie
 */
public class Trade {
	private String clientName; //name of broker
	private String strategyName; //name of strategy used by the broker
	private String coinTraded; //name of the coin traded
	private String action; //buy or sell
	private int quantity; //the number of coins bought or sold
	private double unitPrice; //the price of the coin
	private String timeStamp; //the date of the trade
	
	/**
	 * Creates a new trade object
	 * @param clientName the name of the broker
	 * @param strategyName the name of the strategy used by the broker
	 * @param coinTraded the name of the coin
	 * @param action buy or sell
	 * @param quantity the number of coins to be bought or sold
	 * @param unitPrice the price of the coin
	 * @param timeStamp the date of the action
	 * @return Trade object that is stored in the database
	 */
	public Trade(String clientName, String strategyName, String coinTraded, String action, int quantity, double unitPrice, String timeStamp) {
		this.clientName = clientName;
		this.strategyName = strategyName;
		this.coinTraded = coinTraded;
		this.action = action;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.timeStamp = timeStamp;
	}
	
	/**
	 * 
	 * @return an object array with all the information
	 */
	public Object[] getTradeInfo(){
		Object[] tradeInfo = new Object[7];
		tradeInfo[0] = clientName;
		tradeInfo[1] = strategyName;
		tradeInfo[2] = coinTraded;
		tradeInfo[3] = action;
		tradeInfo[4] = quantity;
		tradeInfo[5] = unitPrice;
		tradeInfo[6] = timeStamp;
		return tradeInfo;
	}

	/**
	 * 
	 * @return the name of the broker that made the trade
	 */
	public String getName(){
		return clientName;
	}

}