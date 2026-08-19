package com.stockexchange.controller;

import com.stockexchange.orderbook.MarketDepth;
import com.stockexchange.orderbook.MarketDepthService;
import com.stockexchange.service.MarketDataBroadcaster;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/market")
public class MarketDataController {

    private final MarketDepthService marketDepthService;
    private final MarketDataBroadcaster marketDataBroadcaster;

    public MarketDataController(
            MarketDepthService marketDepthService,
            MarketDataBroadcaster marketDataBroadcaster) {

        this.marketDepthService = marketDepthService;
        this.marketDataBroadcaster = marketDataBroadcaster;
    }

    @GetMapping("/depth")
    public MarketDepth getMarketDepth() {
        return marketDepthService.getMarketDepth();
    }

    @GetMapping(
            value = "/depth/stream",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<MarketDepth> streamMarketDepth() {
        return marketDataBroadcaster.getMarketDataStream();
    }
}