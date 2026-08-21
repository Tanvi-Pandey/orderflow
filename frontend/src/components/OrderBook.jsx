import { useState, useEffect } from "react";
import { getOrderBook } from "../api";
import "./OrderBook.css";

function flattenLevels(sideOrders) {
  // sideOrders: { "150.0": [Order, Order, ...], "160.0": [...] }
  if (!sideOrders) return [];
  return Object.entries(sideOrders)
    .map(([price, orders]) => ({
      price: Number(price),
      quantity: orders.reduce((sum, o) => sum + o.quantity, 0),
      symbol: orders[0]?.symbol || "-",
    }))
    .sort((a, b) => a.price - b.price);
}

function OrderBook() {
  const [bids, setBids] = useState([]);
  const [asks, setAsks] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchBook = async () => {
      try {
        const book = await getOrderBook();
        setBids(flattenLevels(book.buyOrderBook?.buyOrders).reverse()); // highest bid first
        setAsks(flattenLevels(book.sellOrderBook?.sellOrders)); // lowest ask first
        setError("");
      } catch (err) {
        setError("Unable to reach backend");
      }
    };

    fetchBook();
    const timer = setInterval(fetchBook, 3000);
    return () => clearInterval(timer);
  }, []);

  const rows = Math.max(bids.length, asks.length);

  return (
    <div className="orderbook">
      <div className="orderbook-header">
        <h2>Live Order Book</h2>
        <span className="live-dot">{error ? "OFFLINE" : "LIVE"}</span>
      </div>

      {error && <p style={{ color: "#ff6b6b" }}>{error}</p>}

      <table>
        <thead>
          <tr>
            <th>Symbol</th>
            <th>Bid</th>
            <th>Bid Qty</th>
            <th>Ask</th>
            <th>Ask Qty</th>
          </tr>
        </thead>
        <tbody>
          {rows === 0 && (
            <tr><td colSpan="5" style={{ textAlign: "center" }}>No open orders</td></tr>
          )}
          {Array.from({ length: rows }).map((_, i) => (
            <tr key={i}>
              <td>{bids[i]?.symbol || asks[i]?.symbol || "-"}</td>
              <td className="buy">{bids[i] ? `$${bids[i].price.toFixed(2)}` : "-"}</td>
              <td>{bids[i]?.quantity ?? "-"}</td>
              <td className="sell">{asks[i] ? `$${asks[i].price.toFixed(2)}` : "-"}</td>
              <td>{asks[i]?.quantity ?? "-"}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default OrderBook;