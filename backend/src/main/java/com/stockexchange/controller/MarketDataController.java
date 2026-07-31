package com.stockexchange.controller;

import com.stockexchange.orderbook.MarketDepth;
import com.stockexchange.orderbook.MarketDepthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/market")
public class MarketDataController {

    private final MarketDepthService marketDepthService;

    public MarketDataController(MarketDepthService marketDepthService) {
        this.marketDepthService = marketDepthService;
    }

    @GetMapping("/depth")
    public MarketDepth getMarketDepth() {
        return marketDepthService.getMarketDepth();
    }
}