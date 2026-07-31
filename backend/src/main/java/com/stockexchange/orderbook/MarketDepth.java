package com.stockexchange.orderbook;

import java.util.ArrayList;
import java.util.List;

public class MarketDepth {

    private List<PriceLevel> bids;
    private List<PriceLevel> asks;

    public MarketDepth() {
        bids = new ArrayList<>();
        asks = new ArrayList<>();
    }

    public List<PriceLevel> getBids() {
        return bids;
    }

    public List<PriceLevel> getAsks() {
        return asks;
    }

    public void setBids(List<PriceLevel> bids) {
        this.bids = bids;
    }

    public void setAsks(List<PriceLevel> asks) {
        this.asks = asks;
    }
}