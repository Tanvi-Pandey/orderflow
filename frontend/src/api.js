const BASE_URL = "http://localhost:8080";

export async function placeOrder(order) {
  const res = await fetch(`${BASE_URL}/orders`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(order),
  });

  const data = await res.json();

  if (!res.ok) {
    throw new Error(data.message || "Failed to place order");
  }

  return data; // OrderResponse: { orderId, symbol, status, message }
}

export async function getOrderBook() {
  const res = await fetch(`${BASE_URL}/orders/book`);
  if (!res.ok) throw new Error("Failed to fetch order book");
  return res.json(); // { buyOrderBook: { buyOrders: {...} }, sellOrderBook: { sellOrders: {...} } }
}

export async function getTrades() {
  const res = await fetch(`${BASE_URL}/trades`);
  if (!res.ok) throw new Error("Failed to fetch trades");
  return res.json();
}

export async function getTradeCount() {
  const res = await fetch(`${BASE_URL}/trades/count`);
  if (!res.ok) throw new Error("Failed to fetch trade count");
  return res.json();
}