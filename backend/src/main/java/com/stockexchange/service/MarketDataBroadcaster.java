package com.stockexchange.service;

import com.stockexchange.orderbook.MarketDepth;
import com.stockexchange.orderbook.MarketDepthService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class MarketDataBroadcaster {

    private final MarketDepthService marketDepthService;

    private final Sinks.Many<MarketDepth> marketDataSink =
            Sinks.many().replay().latest();

    public MarketDataBroadcaster(
            MarketDepthService marketDepthService) {

        this.marketDepthService = marketDepthService;
    }

    @Scheduled(fixedRate = 100)
    public void broadcastMarketDepth() {

        MarketDepth marketDepth =
                marketDepthService.getMarketDepth();

        marketDataSink.tryEmitNext(marketDepth);
    }

    public Flux<MarketDepth> getMarketDataStream() {
        return marketDataSink.asFlux();
    }
}
