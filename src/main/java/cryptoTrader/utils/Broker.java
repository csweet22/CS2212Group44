package cryptoTrader.utils;

import java.util.HashMap;

/**
 * A class used to represent brokers, each having a name, a list of coins 
 * they are interested in and a strategy they will use to decide to trade or not
 * @author Mitchell Walker
 */
public class Broker {
    private String name; //the name of the broker
    private String[] coinList; //the list of coins this broker is interested in
    private Strategy strategy; //the strategy this broker will use to trade

    /**
     * The constructor used to create brokers
     * @param name //a String representing the name of the broker
     * @param coinList //a String array containing shorthands for all the coins of interest
     * @param strategy //a strategy object containing the rules this broker will follow when performing trades
     */
    public Broker(String name, String[] coinList, Strategy strategy){
        this.name = name;
        this.coinList = coinList;
        this.strategy = strategy;
    }

    /**
     * Invokes the trade method of this brokers strategy object
     * @param coin_price a hashmap containing coin names as keys and prices as values
     * @param date the date of the trade
     * @return a trade object representing the performed trade (if any)
     */
    public Trade makeTrade(HashMap<String, Double> coin_price, String date){
        return strategy.trade(name, coinList,coin_price, date);//the name of the broker, the coins they're interested in, the map of coins to prices, and the date
    }

    /**
     * @return a string representing the name of the broker
     */
    public String getName(){
        return name;
    }

    /**
     * @return an array of strings representing the coins of interest
     */
    public String[] getCoins(){
        return coinList;
    }

    /**
     * @return a reference to this brokers strategy object
     */
    public Strategy getStrategy(){
        return strategy;
    }
}
