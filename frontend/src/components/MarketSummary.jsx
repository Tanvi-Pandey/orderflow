import React from "react";
import "./MarketSummary.css";

function MarketSummary() {

  const marketData = [
    {
      name: "NIFTY 50",
      price: "24,520",
      change: "+1.25%"
    },
    {
      name: "BTC/USD",
      price: "$68,420",
      change: "+2.10%"
    },
    {
      name: "Portfolio",
      price: "₹1,25,600",
      change: "+₹4,320"
    },
    {
      name: "Buying Power",
      price: "₹50,000",
      change: "Available"
    }
  ];


  return (

    <div className="market-summary">

      {
        marketData.map((item,index)=>(

          <div className="summary-card" key={index}>

            <h3>
              {item.name}
            </h3>

            <h2>
              {item.price}
            </h2>

            <p>
              {item.change}
            </p>


          </div>

        ))
      }

    </div>

  );
}


export default MarketSummary;