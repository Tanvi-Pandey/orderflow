# Week 3 – Market Data Broadcasting & Order Book UI

## Overview
Week 3 focuses on implementing real-time market data broadcasting and developing a responsive Order Book user interface. The primary objective is to calculate and broadcast Level 2 Order Book depth while ensuring that the frontend efficiently renders frequent market updates.

---

## Objectives

- Implement real-time **Level 2 Market Data Broadcasting**.
- Calculate aggregated bid and ask volumes at each price level.
- Broadcast market depth updates every **100 milliseconds**.
- Build a responsive **Order Book UI** to display live market data.
- Compare the performance of **React DOM** and **Canvas-based rendering** for handling high-frequency updates.

---

## Tasks

### Market Data Broadcasting
- Implement logic to calculate Level 2 Order Book depth.
- Aggregate buy and sell quantities at each price level.
- Broadcast market depth updates at fixed 100 ms intervals.
- Optimize broadcasting for low latency and high throughput.

### Order Book UI
- Design and implement the Order Book interface.
- Display:
  - Bid Price
  - Ask Price
  - Quantity
  - Market Depth
- Integrate live market data updates with the frontend.

### Performance Evaluation
- Implement the Order Book using standard React DOM rendering.
- Implement an alternative Canvas-based rendering approach.
- Compare both implementations based on:
  - Rendering performance
  - CPU utilization
  - Memory consumption
  - Responsiveness under frequent updates

---

## Deliverables

- Level 2 Market Data Broadcasting module.
- Live Order Book UI with real-time updates.
- React DOM implementation.
- Canvas-based implementation.
- Performance comparison report.
- Updated project documentation.

---

## Technologies Used

- Java
- Spring Boot
- Spring WebFlux
- React
- HTML
- CSS
- JavaScript
- Canvas API
- Maven
- Git
- GitHub

---

## Expected Outcome

By the end of Week 3, the application should be capable of broadcasting Level 2 market data in real time while providing a responsive Order Book interface. The performance comparison between React DOM and Canvas rendering will help determine the most suitable approach for high-frequency trading interfaces.