package cryptoTrader.utils;

import java.util.ArrayList;

public class Broker {
    private String name;
    private String[] coinList;
    private Strategy strategy;

    public Broker(String name, String[] coinList, String strategyName){
        this.name = name;
        this.coinList = coinList;
        strategy = StrategyFactory.getInstance().getStrategy(strategyName);
    }

    public Trade makeTrade(){
        return strategy.trade(name, coinList);
    }
}
