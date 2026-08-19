package com.stockexchange.dto;

import java.util.List;

public class MarketDepthResponse {

    private List<PriceLevelResponse> bids;
    private List<PriceLevelResponse> asks;

    public MarketDepthResponse() {
    }

    public MarketDepthResponse(
            List<PriceLevelResponse> bids,
            List<PriceLevelResponse> asks) {

        this.bids = bids;
        this.asks = asks;
    }

    public List<PriceLevelResponse> getBids() {
        return bids;
    }

    public void setBids(List<PriceLevelResponse> bids) {
        this.bids = bids;
    }

    public List<PriceLevelResponse> getAsks() {
        return asks;
    }

    public void setAsks(List<PriceLevelResponse> asks) {
        this.asks = asks;
    }
}