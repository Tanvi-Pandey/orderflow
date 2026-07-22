import "./App.css";
import {
  FaChartLine,
  FaUserCircle,
  FaBell,
  FaSearch,
  FaArrowUp,
  FaArrowDown,
  FaWallet,
  FaChartPie,
  FaNewspaper,
  FaCoins,
  FaGlobe,
  FaFire,
  FaBars
} from "react-icons/fa";

function App() {
  return (
    <div className="app">

      {/* ================= NAVBAR ================= */}

      <header className="navbar">

        <div className="logo">
          <FaChartLine />
          <h2>OrderFlow</h2>
        </div>

        <nav className="nav-links">
          <a href="#">Markets</a>
          <a href="#">Portfolio</a>
          <a href="#">Trade</a>
          <a href="#">Watchlist</a>
          <a href="#">News</a>
          <a href="#">Learn</a>
        </nav>

        <div className="search-box">
          <FaSearch />
          <input type="text" placeholder="Search Stocks..." />
        </div>

        <div className="nav-right">

          <FaBell className="bell"/>

          <button className="login">
            Login
          </button>

          <button className="register">
            Register
          </button>

          <FaUserCircle className="profile"/>

        </div>

      </header>


      {/* ================= HERO ================= */}

      <section className="hero">

        <div className="hero-left">

          <span className="tag">
            India's Smart Trading Platform
          </span>

          <h1>

            Trade Smarter.

            <br/>

            Invest Better.

          </h1>

          <p>

            Professional stock trading dashboard inspired by
            modern fintech platforms. Track markets,
            analyse stocks and execute trades in seconds.

          </p>

          <div className="hero-buttons">

            <button className="start-btn">
              Start Trading
            </button>

            <button className="market-btn">
              Live Market
            </button>

          </div>

          <div className="stats">

            <div>
              <h2>12L+</h2>
              <p>Users</p>
            </div>

            <div>
              <h2>250+</h2>
              <p>Stocks</p>
            </div>

            <div>
              <h2>99.9%</h2>
              <p>Uptime</p>
            </div>

          </div>

        </div>

        <div className="hero-right">

          <div className="hero-card">

            <h3>Portfolio Value</h3>

            <h1>₹12,48,520</h1>

            <span className="green">
              +18.26% Today
            </span>

          </div>

        </div>

      </section>


      {/* ================= LIVE TICKER ================= */}

      <section className="ticker">

        <div>NIFTY 50 <span>22,514 ▲1.20%</span></div>

        <div>SENSEX <span>74,820 ▲0.82%</span></div>

        <div>BANK NIFTY <span>48,250 ▲0.68%</span></div>

        <div>BTC ₹57,42,000</div>

        <div>ETH ₹2,91,000</div>

        <div>GOLD ₹72,500</div>

        <div>CRUDE ₹6,480</div>

      </section>


      {/* ================= DASHBOARD ================= */}

      <section className="dashboard">

        <div className="dashboard-card">

          <FaWallet/>

          <h3>Available Balance</h3>

          <h2>₹5,42,000</h2>

        </div>

        <div className="dashboard-card">

          <FaChartPie/>

          <h3>Today's Profit</h3>

          <h2 className="green">
            +₹21,240
          </h2>

        </div>

        <div className="dashboard-card">

          <FaCoins/>

          <h3>Open Positions</h3>

          <h2>18</h2>

        </div>

        <div className="dashboard-card">

          <FaFire/>

          <h3>Success Rate</h3>

          <h2>84%</h2>

        </div>

      </section>


      {/* ================= MAIN GRID ================= */}

      <section className="main-grid">

        {/* LEFT */}

        <div className="left-column">

          {/* Trading Chart */}

          <div className="glass chart-box">

            <div className="heading">

              <h2>Market Performance</h2>

              <button>
                Full Report
              </button>

            </div>

            <div className="fake-chart">

              <div className="line1"></div>

              <div className="line2"></div>

              <div className="line3"></div>

            </div>

          </div>

          {/* Watchlist */}

          <div className="glass watchlist">

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

                  <td>₹2920</td>

                  <td className="green">
                    +1.25%
                  </td>

                </tr>

                <tr>

                  <td>TCS</td>

                  <td>₹3922</td>

                  <td className="green">
                    +0.84%
                  </td>

                </tr>

                <tr>

                  <td>INFY</td>

                  <td>₹1715</td>

                  <td className="red">
                    -0.21%
                  </td>

                </tr>

                <tr>

                  <td>HDFC</td>

                  <td>₹1684</td>

                  <td className="green">
                    +2.31%
                  </td>

                </tr>

              </tbody>

            </table>

          </div>
                    </div>


          {/* ================= TOP GAINERS ================= */}

          <div className="glass gainers">

            <h2>
              Top Gainers
            </h2>

            <div className="stock-row">

              <div>
                <h3>RELIANCE</h3>
                <p>Energy & Retail</p>
              </div>

              <span className="green">
                +3.42%
              </span>

            </div>


            <div className="stock-row">

              <div>
                <h3>TATA MOTORS</h3>
                <p>Automobile</p>
              </div>

              <span className="green">
                +2.86%
              </span>

            </div>


            <div className="stock-row">

              <div>
                <h3>ICICI BANK</h3>
                <p>Banking</p>
              </div>

              <span className="green">
                +2.12%
              </span>

            </div>


          </div>


        </div>



        {/* ================= RIGHT COLUMN ================= */}

        <div className="right-column">


          {/* Market News */}

          <div className="glass news-box">

            <div className="heading">

              <h2>
                Market News
              </h2>

              <FaNewspaper/>

            </div>


            <div className="news-item">

              <h3>
                RBI keeps interest rates unchanged
              </h3>

              <p>
                Banking stocks react positively after policy announcement.
              </p>

            </div>


            <div className="news-item">

              <h3>
                IT sector sees strong recovery
              </h3>

              <p>
                Technology stocks gain momentum in global markets.
              </p>

            </div>


            <div className="news-item">

              <h3>
                Gold prices reach new highs
              </h3>

              <p>
                Investors move towards safe assets.
              </p>

            </div>


          </div>



          {/* ================= TRADE PANEL ================= */}


          <div className="glass trade-box">


            <h2>
              Quick Trade
            </h2>


            <div className="trade-input">

              <input 
                type="text"
                placeholder="Enter Stock Name"
              />

            </div>


            <div className="trade-buttons">

              <button className="buy">
                Buy
              </button>


              <button className="sell">
                Sell
              </button>


            </div>


          </div>



          {/* ================= GLOBAL MARKET ================= */}


          <div className="glass global-box">


            <div className="heading">

              <h2>
                Global Markets
              </h2>

              <FaGlobe/>

            </div>



            <div className="market-row">

              <span>
                NASDAQ
              </span>

              <b className="green">
                +1.45%
              </b>

            </div>



            <div className="market-row">

              <span>
                DOW JONES
              </span>

              <b className="green">
                +0.72%
              </b>

            </div>



            <div className="market-row">

              <span>
                FTSE 100
              </span>

              <b className="red">
                -0.31%
              </b>

            </div>



          </div>


        </div>


      </section>
            {/* ================= FOOTER ================= */}

      <footer className="footer">

        <div className="footer-left">

          <div className="logo">

            <FaChartLine />

            <h2>
              OrderFlow
            </h2>

          </div>


          <p>
            Smart trading dashboard for modern investors.
            Track markets, manage portfolios and make
            better investment decisions.
          </p>


        </div>



        <div className="footer-links">


          <div>

            <h3>
              Platform
            </h3>

            <a href="#">
              Markets
            </a>

            <a href="#">
              Trading
            </a>

            <a href="#">
              Portfolio
            </a>

          </div>



          <div>

            <h3>
              Company
            </h3>

            <a href="#">
              About
            </a>

            <a href="#">
              Careers
            </a>

            <a href="#">
              Contact
            </a>

          </div>



          <div>

            <h3>
              Support
            </h3>

            <a href="#">
              Help Center
            </a>

            <a href="#">
              Privacy
            </a>

            <a href="#">
              Terms
            </a>

          </div>


        </div>


      </footer>



      {/* ================= COPYRIGHT ================= */}

      <div className="copyright">

        © 2026 OrderFlow. All Rights Reserved.

      </div>


    </div>

  );

}


export default App;