import { useState } from "react";
import "./OrderEntry.css";

export default function OrderEntry() {
  const [formData, setFormData] = useState({
    symbol: "",
    orderType: "Buy",
    quantity: "",
    price: "",
  });

  const [errors, setErrors] =useState({});
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });

    setErrors({
      ...errors,
      [e.target.name]: "",
    });

    setMessage("");
  };

  const validate = () => {
    let temp = {};

    if (!formData.symbol.trim())
      temp.symbol = "Stock Symbol is required.";

    if (!formData.quantity)
      temp.quantity = "Quantity is required.";
    else if (Number(formData.quantity) <= 0)
      temp.quantity = "Quantity must be greater than 0.";

    if (!formData.price)
      temp.price = "Price is required.";
    else if (Number(formData.price) <= 0)
      temp.price = "Price must be greater than 0.";

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

  const order = {
    symbol: formData.symbol,
    side: formData.orderType.toUpperCase(),
    type: "LIMIT",
    price: Number(formData.price),
    quantity: Number(formData.quantity)
  };

  try {
    const response = await fetch("http://localhost:8080/orders", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(order)
    });

    const data = await response.json();

    if (response.ok) {
  console.log("Backend Response:", data);
  console.log("Message:", data.message);

  alert(data.message);   // <-- Add this

  setMessage(data.message);
} else {
  alert("Failed");
  setMessage("Failed to place order");
}

    setFormData({
      symbol: "",
      orderType: "Buy",
      quantity: "",
      price: ""
    });

  } catch (error) {
    console.error(error);
    setMessage("Cannot connect to backend.");
  }
};

  return (
    <div className="order-entry-card">
      <h2>Order Entry</h2>
{/* 
      {message && (
        <div className="success-message">
          {message}
        </div>
      )} */
      <h2 style={{ color: "green" }}>
  {message}
</h2>}

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

          {errors.symbol && (
            <small className="error">{errors.symbol}</small>
          )}
        </div>

        <div className="form-group">
          <label>Order Type</label>

          <select
            name="orderType"
            value={formData.orderType}
            onChange={handleChange}
          >
            <option>Buy</option>
            <option>Sell</option>
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

          {errors.quantity && (
            <small className="error">{errors.quantity}</small>
          )}
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

          {errors.price && (
            <small className="error">{errors.price}</small>
          )}
        </div>

        <button type="submit" className="submit-btn">
          Place Order
        </button>

      </form>
    </div>
  );
}
