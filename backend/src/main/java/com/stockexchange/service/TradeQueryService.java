package com.stockexchange.service;

import com.stockexchange.model.Trade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeQueryService {

    private final TradeService tradeService;

    public TradeQueryService(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    public List<Trade> getAllTrades() {
        return new ArrayList<>(tradeService.getTrades());
    }

    public List<Trade> getTradesBySymbol(String symbol) {

        List<Trade> result = new ArrayList<>();

        for (Trade trade : tradeService.getTrades()) {

            if (trade.getSymbol() != null &&
                    trade.getSymbol().equalsIgnoreCase(symbol)) {

                result.add(trade);
            }
        }

        return result;
    }
}