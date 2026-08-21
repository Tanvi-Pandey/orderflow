# OrderFlow

A high-throughput order matching engine and market data platform, built as an advanced full-stack Java engineering project (Axlero Solutions — Project 1: "OrderFlow").

OrderFlow simulates a simplified stock exchange: a Java backend matches buy/sell orders using the **LMAX Disruptor** lock-free concurrency pattern, and a React trading terminal lets a user submit orders and watch the order book update live.

---

## Tech Stack

**Backend**
- Java 25, Spring Boot
- Spring WebFlux (reactive web layer)
- LMAX Disruptor (lock-free order event processing)
- JUnit 5 (unit testing)
- Maven

**Frontend**
- React 19 + Vite
- React Router
- Recharts (market overview chart)
- react-icons

**Testing**
- Postman collection (`Testing/Postman/OrderFlow.postman_collection.json`)
- JUnit backend unit tests

---

## Project Structure

```
OrderFlow/
├── backend/                  # Spring Boot matching engine + REST API
│   └── src/main/java/com/stockexchange/
│       ├── MatchingEngineApplication.java   # Spring Boot entry point
│       ├── config/            # Disruptor & OrderBook bean configuration
│       ├── controller/        # REST controllers (Order, Trade)
│       ├── disruptor/         # LMAX Disruptor event factory, producer, handler
│       ├── dto/                # Request/response DTOs
│       ├── enums/              # OrderSide, OrderType, OrderStatus
│       ├── exception/          # Global exception handling
│       ├── model/              # Order, Trade, OrderEvent
│       ├── orderbook/          # BuyOrderBook, SellOrderBook, OrderBook
│       ├── runner/             # TestRunner utility
│       └── service/             # MatchingEngine, OrderService, TradeService
├── frontend/                 # React (Vite) trading terminal
│   └── src/
│       ├── api.js              # Backend API client (fetch wrappers)
│       ├── components/         # OrderEntry, OrderBook, MarketSummary, TradingChart, Sidebar, LoginModal
│       └── pages/                # Login, Register, Dashboard
├── docs/                      # Architecture & sprint documentation
├── Testing/
│   ├── Postman/                # Postman API test collection
│   ├── docs/                    # Testing/integration/setup documentation
│   └── Screenshots/             # Test evidence screenshots
└── README.md
```

---

## Getting Started

### Prerequisites
- Java 25 (JDK)
- Maven
- Node.js + npm

### Run the backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
The API starts on `http://localhost:8080`. Verify with:
```bash
curl http://localhost:8080/actuator/health
```

### Run the frontend
```bash
cd frontend
npm install
npm run dev
```
Opens on `http://localhost:5173`. The frontend polls the backend's order book every 3 seconds and submits orders directly via REST.

> Both the backend and frontend must be running simultaneously for the app to function — the frontend has no built-in mock/offline mode.

---

## API Reference

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/orders` | Submit a new order (`symbol`, `side`, `type`, `price`, `quantity`) |
| `GET` | `/orders/book` | Get the current order book (buy/sell price levels) |
| `GET` | `/trades` | Get all executed trades |
| `GET` | `/trades/count` | Get the total number of executed trades |
| `DELETE` | `/trades` | Clear all recorded trades |

### Example: Place an order
```http
POST /orders
Content-Type: application/json

{
  "symbol": "AAPL",
  "side": "BUY",
  "type": "LIMIT",
  "price": 150.00,
  "quantity": 100
}
```
Response:
```json
{
  "orderId": 1,
  "symbol": "AAPL",
  "status": "OPEN",
  "message": "Order processed successfully"
}
```

---

## Testing

### Postman
Import `Testing/Postman/OrderFlow.postman_collection.json` into Postman. It includes requests for order creation, order book retrieval, trade retrieval, and trade count, plus edge-case requests (invalid quantity, invalid symbol, partial match).

### Backend unit tests
```bash
cd backend
mvn test
```
Covers matching engine behavior (price-time priority matching, partial fills, trade execution).

### Verified end-to-end flow
A buy order and a matching sell order (same symbol, price, and quantity) were submitted via Postman and the live frontend. Both fully matched, generating a trade record retrievable via `GET /trades`, and the frontend's Live Order Book correctly reflected the resulting order book state.

---

## Known Limitations / Scope Notes

- **No real-time push (WebSocket/SSE) yet** — the frontend currently polls `GET /orders/book` every 3 seconds rather than receiving pushed updates. This was descoped from the original design in favor of shipping a working polling-based version first.
- **Login is UI-only** — the login/register pages are not backed by a real authentication service; submitting the login form navigates directly to the Dashboard.
- **In-memory state** — orders and trades are not persisted to a database; restarting the backend clears all state.
- **Simulated risk checks** — pre-trade fund validation described in the original design is not yet implemented.

---

## Authors

[Your Name] — Axlero Solutions, Advanced Full-Stack Java Engineering
By the end of Week 3, the application should be capable of broadcasting Level 2 market data in real time while providing a responsive Order Book interface. The performance comparison between React DOM and Canvas rendering will help determine the most suitable approach for high-frequency trading interfaces.
