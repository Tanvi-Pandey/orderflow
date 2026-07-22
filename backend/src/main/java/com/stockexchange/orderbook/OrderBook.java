package com.stockexchange.orderbook;

public class OrderBook {

    private final BuyOrderBook buyOrderBook;
    private final SellOrderBook sellOrderBook;

    public OrderBook() {
        this.buyOrderBook = new BuyOrderBook();
        this.sellOrderBook = new SellOrderBook();
    }

    public BuyOrderBook getBuyOrderBook() {
        return buyOrderBook;
    }

    public SellOrderBook getSellOrderBook() {
        return sellOrderBook;
    }
}