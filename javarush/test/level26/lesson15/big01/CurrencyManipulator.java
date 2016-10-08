package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)){
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount(){
        int i = 0;
        for (Map.Entry<Integer, Integer> map : denominations.entrySet()){
            int a = map.getKey() * map.getValue();
            i += a;
        }
        return i;
    }

    public boolean hasMoney(){
        return denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount){

        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o2.hashCode() - o1.hashCode();
            }
        });
        map.putAll(denominations);

        Map<Integer, Integer> map1 = new TreeMap<>(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                return o2.hashCode() - o1.hashCode();
            }
        });
        int sum = 0;

        for (Map.Entry<Integer, Integer> m : map.entrySet()){

             while ((int)((expectedAmount - sum) / m.getKey()) > 0) {
                sum += m.getKey();
                map.put(m.getKey(), m.getValue() - 1);
                if (map1.containsKey(m.getKey())) {
                    map1.put(m.getKey(), map1.get(m.getKey()) + 1);
                } else {
                    map1.put(m.getKey(), 1);
                }
            }
        }

        if (sum > expectedAmount || sum < expectedAmount)
            throw new NotEnoughMoneyException();

       denominations.putAll(map);

        return map1;
    }
}


