package cryptoTrader.utils;

import java.util.HashMap;

public class Broker {
    private String name;
    private String[] coinList;
    private Strategy strategy;

    public Broker(String name, String[] coinList, Strategy strategy){
        this.name = name;
        this.coinList = coinList;
        this.strategy = strategy;
    }


    public Trade makeTrade(HashMap<String, Double> coin_price, String date){
        return strategy.trade(name, coinList,coin_price,date);//the name of the broker, the coins they're interested in, the map of coins to prices, and the date
    }

    public String getName(){
        return name;
    }

    public String[] getCoins(){
        return coinList;
    }

    public Strategy getStrategy(){
        return strategy;
    }
}
