package com.stockexchange.dto;

public class OrderBookStatisticsResponse {

    private int totalBuyOrders;
    private int totalSellOrders;
    private int totalOrders;
    private int totalBuyQuantity;
    private int totalSellQuantity;

    public OrderBookStatisticsResponse() {
    }

    public OrderBookStatisticsResponse(
            int totalBuyOrders,
            int totalSellOrders,
            int totalOrders,
            int totalBuyQuantity,
            int totalSellQuantity) {

        this.totalBuyOrders = totalBuyOrders;
        this.totalSellOrders = totalSellOrders;
        this.totalOrders = totalOrders;
        this.totalBuyQuantity = totalBuyQuantity;
        this.totalSellQuantity = totalSellQuantity;
    }

    public int getTotalBuyOrders() {
        return totalBuyOrders;
    }

    public void setTotalBuyOrders(int totalBuyOrders) {
        this.totalBuyOrders = totalBuyOrders;
    }

    public int getTotalSellOrders() {
        return totalSellOrders;
    }

    public void setTotalSellOrders(int totalSellOrders) {
        this.totalSellOrders = totalSellOrders;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getTotalBuyQuantity() {
        return totalBuyQuantity;
    }

    public void setTotalBuyQuantity(int totalBuyQuantity) {
        this.totalBuyQuantity = totalBuyQuantity;
    }

    public int getTotalSellQuantity() {
        return totalSellQuantity;
    }

    public void setTotalSellQuantity(int totalSellQuantity) {
        this.totalSellQuantity = totalSellQuantity;
    }
}