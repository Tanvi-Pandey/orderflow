import React from "react";

import {
    LineChart,
    Line,
    XAxis,
    YAxis,
    Tooltip,
    CartesianGrid,
    ResponsiveContainer
} from "recharts";


import "./TradingChart.css";


function TradingChart(){


const data=[

{
time:"9 AM",
price:180
},

{
time:"10 AM",
price:195
},

{
time:"11 AM",
price:188
},

{
time:"12 PM",
price:220
},

{
time:"1 PM",
price:210
},

{
time:"2 PM",
price:240
},

{
time:"3 PM",
price:260
}

];



return(

<div className="trading-chart">


<h2>
Market Performance
</h2>


<ResponsiveContainer width="100%" height={350}>


<LineChart data={data}>


<CartesianGrid 
strokeDasharray="3 3"
/>


<XAxis 
dataKey="time"
/>


<YAxis />


<Tooltip />


<Line

type="monotone"

dataKey="price"

strokeWidth={3}

/>


</LineChart>


</ResponsiveContainer>


</div>


);


}


export default TradingChart;