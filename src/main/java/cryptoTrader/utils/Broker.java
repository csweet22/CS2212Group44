package cryptoTrader.utils;
public class Broker {
    private String name;
    private String[] coinList;
    private Strategy strategy;

    public Broker(String name, String[] coinList, Strategy strategy){
        this.name = name;
        this.coinList = coinList;
        this.strategy = strategy;
    }

    public Trade makeTrade(){
        return strategy.trade(name, coinList);
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
