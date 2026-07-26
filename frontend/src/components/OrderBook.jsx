import { useState, useEffect } from "react";
import "./OrderBook.css";

function OrderBook() {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    const generateOrders = () => {
      const symbols = [
        "AAPL",
        "TSLA",
        "NVDA",
        "MSFT",
        "GOOGL",
        "META",
        "AMZN",
        "NFLX",
      ];

      const data = symbols.map((symbol) => ({
        symbol,
        bid: (Math.random() * 400 + 100).toFixed(2),
        ask: (Math.random() * 400 + 100).toFixed(2),
        volume: Math.floor(Math.random() * 5000 + 100),
      }));

      setOrders(data);
    };

    generateOrders();

    const timer = setInterval(generateOrders, 5000);

    return () => clearInterval(timer);
  }, []);

  return (
    <div className="orderbook">

      <div className="orderbook-header">
        <h2>Live Order Book</h2>
        <span className="live-dot">LIVE</span>
      </div>

      <table>

        <thead>

          <tr>

            <th>Symbol</th>
            <th>Bid</th>
            <th>Ask</th>
            <th>Volume</th>

          </tr>

        </thead>

        <tbody>

          {orders.map((item, index) => (

            <tr key={index}>

              <td>{item.symbol}</td>

              <td className="buy">
                ${item.bid}
              </td>

              <td className="sell">
                ${item.ask}
              </td>

              <td>{item.volume}</td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}

export default OrderBook;