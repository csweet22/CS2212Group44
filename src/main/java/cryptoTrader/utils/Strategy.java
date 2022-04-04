package cryptoTrader.utils;

import java.util.HashMap;

/**
 * An interface that all strategies must inherit to ensure functionality
 * @author Mitchell Walker
 */
interface Strategy {
    /**
     * A method where the logic for performing trades must be implemented
     * @param broker name of the broker making the trade
     * @param coins a list of coin names the broker is interested in
     * @param coin_price a hashmap that stores prices of coins using their names as keys
     * @param date the date of the trade
     * @return a trade object containing all the information about a trade when it is performed
     */
    public Trade trade(String broker, String[] coins,HashMap<String,Double> coin_price, String date); 

    /**
     * @return the name of the strategy
     */
    public String getName();
}
