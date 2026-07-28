# OrderFlow API Testing

## Project Overview

This repository contains the API testing and integration work for the OrderFlow project.

## Technologies Used

- Java
- Spring Boot
- REST API
- Postman

## APIs Tested

1. Create Order
   - POST /orders

2. Get Order Book
   - GET /orders/book

3. Get Trades
   - GET /trades

4. Get Trade Count
   - GET /trades/count

5. Delete Trades
   - DELETE /trades

## Folder Structure

```
OrderFlow
│
├── postman
│   └── OrderFlow.postman_collection.json
│
├── docs
│   ├── API_Documentation.md
│   └── Testing_Report.md
│
├── screenshots
│   ├── create-order.png
│   ├── get-order-book.png
│   ├── get-trades.png
│   └── trade-count.png
│
└── README.md
```

## How to Run

### Backend

```bash
mvn spring-boot:run
```

### API Testing

1. Open Postman.
2. Import `OrderFlow.postman_collection.json`.
3. Start the Spring Boot application.
4. Run the API requests.

## Contribution

**Manish**
- Created and tested Postman API collection.
- Verified REST API functionality.
- Prepared API documentation.
- Prepared API testing report.
- Captured API response screenshots.

## Author

**Manish**