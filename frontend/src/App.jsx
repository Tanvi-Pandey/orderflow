import "./App.css";

function App() {
  return (
    <div className="app">

      <nav className="navbar">
        <h1>OrderFlow</h1>

        <div className="nav-links">
          <span>Dashboard</span>
          <span>Orders</span>
          <span>Portfolio</span>
          <span>Settings</span>
        </div>

        <button className="profile">Profile</button>
      </nav>


      <div className="dashboard">

        <div className="card">
          <h2>Place Order</h2>

          <div className="trade-buttons">
            <button className="buy">BUY</button>
            <button className="sell">SELL</button>
          </div>

          <label>Order Type</label>
          <select>
            <option>Market</option>
            <option>Limit</option>
          </select>

          <label>Price</label>
          <input placeholder="Enter Price" />

          <label>Quantity</label>
          <input placeholder="Enter Quantity" />

          <p className="value">
            Estimated Value: ₹0.00
          </p>

          <button className="place">
            Place Order
          </button>
        </div>


        <div className="card">
          <h2>Market Overview</h2>

          <div className="market-box">
            <h3>NIFTY 50</h3>
            <p>22,500</p>
            <span>+1.25%</span>
          </div>

          <div className="market-box">
            <h3>BANK NIFTY</h3>
            <p>48,200</p>
            <span>+0.85%</span>
          </div>
        </div>


        <div className="card history">
          <h2>Recent Orders</h2>

          <table>
            <thead>
              <tr>
                <th>Stock</th>
                <th>Type</th>
                <th>Quantity</th>
                <th>Status</th>
              </tr>
            </thead>

            <tbody>
              <tr>
                <td>RELIANCE</td>
                <td>BUY</td>
                <td>10</td>
                <td>Completed</td>
              </tr>

              <tr>
                <td>TATA</td>
                <td>SELL</td>
                <td>5</td>
                <td>Pending</td>
              </tr>
            </tbody>
          </table>

        </div>

      </div>

    </div>
  );
}

export default App;