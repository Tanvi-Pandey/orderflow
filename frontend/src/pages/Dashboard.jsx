import "../App.css";
import OrderBook from "../components/OrderBook";
import OrderEntry from "../components/OrderEntry";

import {
  FaChartLine,
  FaUserCircle,
  FaBell,
  FaSearch,
  FaWallet,
  FaChartPie,
  FaCoins,
  FaGlobe,
  FaNewspaper,
  FaArrowUp,
} from "react-icons/fa";

import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
  CartesianGrid,
} from "recharts";

function Dashboard() {

  const chartData = [
    { day: "Mon", value: 120 },
    { day: "Tue", value: 180 },
    { day: "Wed", value: 160 },
    { day: "Thu", value: 240 },
    { day: "Fri", value: 310 },
    { day: "Sat", value: 280 },
    { day: "Sun", value: 350 },
  ];

  return (

    <div className="app">

      {/* NAVBAR */}

      <header className="navbar">

        <div className="logo">
          <FaChartLine />
          <h2>OrderFlow</h2>
        </div>

        <nav>

          <a href="#">Dashboard</a>

          <a href="#">Markets</a>

          <a href="#">Portfolio</a>

          <a href="#">Orders</a>

          <a href="#">News</a>

        </nav>

        <div className="search">

          <FaSearch />

          <input
            placeholder="Search Stocks..."
          />

        </div>

        <div className="profile">

          <FaBell />

          <FaUserCircle />

        </div>

      </header>

      {/* HERO SECTION */}
      <section className="hero">

  <div className="hero-left">

    <span className="badge">
      Professional Trading Platform
    </span>

    <h1>
      Trade Stocks
      <br />
      Like a Pro
    </h1>

    <p>
      Modern stock trading dashboard with portfolio
      management, live order book, market analytics,
      watchlists and professional order execution.
    </p>

    <div className="hero-buttons">

      <button className="primary">
        Start Trading
      </button>

      <button className="secondary">
        Live Markets
      </button>

    </div>

  </div>

  <div className="hero-right">

    <div className="portfolio-card">

      <h3>Portfolio Value</h3>

      <h1>$245,820</h1>

      <span>

        <FaArrowUp />

        14.82%

      </span>

    </div>

  </div>

</section>

{/* DASHBOARD CARDS */}

<section className="cards">

  <div className="card">

    <FaWallet />

    <h3>Balance</h3>

    <h2>$52,430</h2>

  </div>

  <div className="card">

    <FaChartPie />

    <h3>Today's Profit</h3>

    <h2>$12,520</h2>

  </div>

  <div className="card">

    <FaCoins />

    <h3>Holdings</h3>

    <h2>27 Stocks</h2>

  </div>

  <div className="card">

    <FaGlobe />

    <h3>Markets Open</h3>

    <h2>18</h2>

  </div>

</section>

{/* MAIN GRID */}

<section className="main-grid">

  {/* LEFT SIDE */}

  <div className="left">

    <div className="chart-card">

      <div className="heading">

        <h2>
          Market Overview
        </h2>

      </div>

      <ResponsiveContainer
        width="100%"
        height={320}
      >

        <LineChart data={chartData}>

          <CartesianGrid strokeDasharray="3 3" />

          <XAxis dataKey="day" />

          <YAxis />

          <Tooltip />

          <Line
            type="monotone"
            dataKey="value"
            stroke="#00c896"
            strokeWidth={3}
          />

        </LineChart>

      </ResponsiveContainer>

    </div>

    {/* LIVE ORDER BOOK */}

    <OrderBook />

  </div>

  {/* RIGHT SIDE */}

  <div className="right">

    <OrderEntry />
          {/* WATCHLIST */}

      <div className="watchlist">

        <h2>Watchlist</h2>

        <table>

          <thead>

            <tr>

              <th>Stock</th>

              <th>Price</th>

              <th>Change</th>

            </tr>

          </thead>

          <tbody>

            <tr>

              <td>RELIANCE</td>

              <td>$2,850</td>

              <td className="green">+2.4%</td>

            </tr>

            <tr>

              <td>TCS</td>

              <td>$4,120</td>

              <td className="green">+1.9%</td>

            </tr>

            <tr>

              <td>INFY</td>

              <td>$1,710</td>

              <td className="blue">+0.6%</td>

            </tr>

            <tr>

              <td>HDFCBANK</td>

              <td>$1,890</td>

              <td className="green">+1.1%</td>

            </tr>

          </tbody>

        </table>

      </div>

      {/* MARKET NEWS */}

      <div className="news">

        <h2>

          <FaNewspaper />

          Market News

        </h2>

        <div className="news-item">

          <h4>NIFTY closes at record high</h4>

          <p>
            Banking, IT and Auto sectors led today's rally with strong buying interest.
          </p>

        </div>

        <div className="news-item">

          <h4>Global Markets Rally</h4>

          <p>
            US and Asian markets remain positive ahead of major economic data releases.
          </p>

        </div>

        <div className="news-item">

          <h4>Technology Stocks Gain</h4>

          <p>
            Semiconductor and AI companies continue to outperform the broader market.
          </p>

        </div>

      </div>

    </div>

  </section>

  {/* FOOTER */}

  <footer className="footer">

    <div>

      <h2>OrderFlow</h2>

      <p>
        Professional Trading Dashboard built using React.
      </p>

    </div>

    <div>

      <a href="#">About</a>

      <a href="#">Support</a>

      <a href="#">Privacy</a>

      <a href="#">Contact</a>

    </div>

  </footer>

</div>

  );

}

export default Dashboard;