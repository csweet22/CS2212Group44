package cryptoTrader.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class BrokerManager {

    private static BrokerManager manager = null;
    private HashMap<String, Broker> brokers = new HashMap<>();

    private BrokerManager(){

    }

    public static BrokerManager getInstance(){
        if (manager == null){
            manager = new BrokerManager();
        }
        return manager;
    }

    public void clearBrokers(){
        brokers.clear();
    }

    //returns true if the broker was added
    public boolean addBroker(String name, String[] coins, String strategyName){
        if (brokers.get(name) != null){
            return false;
        }
        Strategy strategy = StrategyFactory.getInstance().getStrategy(strategyName);
        brokers.put(name, new Broker(name, coins, strategy));
        return true;
    }

    public ArrayList<Broker> getBrokers(){
        ArrayList<Broker> brokerList = new ArrayList<>();
        for (Broker broker: brokers.values()){
            brokerList.add(broker);
        }
        return brokerList;
    }

    
}
