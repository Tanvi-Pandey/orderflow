import { useState } from "react";
import { placeOrder } from "../api";
import "./OrderEntry.css";

export default function OrderEntry() {
  const [formData, setFormData] = useState({
    symbol: "",
    side: "BUY",
    type: "LIMIT",
    quantity: "",
    price: "",
  });

  const [errors, setErrors] = useState({});
  const [message, setMessage] = useState("");
  const [isError, setIsError] = useState(false);
  const [submitting, setSubmitting] = useState(false);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
    setErrors({ ...errors, [e.target.name]: "" });
    setMessage("");
  };

  const validate = () => {
    let temp = {};
    if (!formData.symbol.trim()) temp.symbol = "Stock Symbol is required.";
    if (!formData.quantity) temp.quantity = "Quantity is required.";
    else if (Number(formData.quantity) <= 0) temp.quantity = "Quantity must be greater than 0.";
    if (!formData.price) temp.price = "Price is required.";
    else if (Number(formData.price) < 0) temp.price = "Price cannot be negative.";
    return temp;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const validationErrors = validate();
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
      setMessage("");
      return;
    }

    setErrors({});
    setSubmitting(true);
    setMessage("");

    try {
      const response = await placeOrder({
        symbol: formData.symbol.toUpperCase(),
        side: formData.side,
        type: formData.type,
        price: Number(formData.price),
        quantity: Number(formData.quantity),
      });

      setIsError(false);
      setMessage(
        `Order #${response.orderId} (${response.status}) — ${response.message || "placed successfully"}`
      );

      setFormData({ symbol: "", side: "BUY", type: "LIMIT", quantity: "", price: "" });
    } catch (err) {
      setIsError(true);
      setMessage(err.message);
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <div className="order-entry-card">
      <h2>Order Entry</h2>

      {message && (
        <div className={isError ? "error-message" : "success-message"}>
          {message}
        </div>
      )}

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Stock Symbol</label>
          <input
            type="text"
            name="symbol"
            placeholder="AAPL"
            value={formData.symbol}
            onChange={handleChange}
          />
          {errors.symbol && <small className="error">{errors.symbol}</small>}
        </div>

        <div className="form-group">
          <label>Side</label>
          <select name="side" value={formData.side} onChange={handleChange}>
            <option value="BUY">Buy</option>
            <option value="SELL">Sell</option>
          </select>
        </div>

        <div className="form-group">
          <label>Order Type</label>
          <select name="type" value={formData.type} onChange={handleChange}>
            <option value="LIMIT">Limit</option>
            <option value="MARKET">Market</option>
          </select>
        </div>

        <div className="form-group">
          <label>Quantity</label>
          <input
            type="number"
            name="quantity"
            value={formData.quantity}
            onChange={handleChange}
          />
          {errors.quantity && <small className="error">{errors.quantity}</small>}
        </div>

        <div className="form-group">
          <label>Price</label>
          <input
            type="number"
            step="0.01"
            name="price"
            value={formData.price}
            onChange={handleChange}
          />
          {errors.price && <small className="error">{errors.price}</small>}
        </div>

        <button type="submit" className="submit-btn" disabled={submitting}>
          {submitting ? "Placing..." : "Place Order"}
        </button>
      </form>
    </div>
  );
}