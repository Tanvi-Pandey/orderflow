# OrderFlow API Documentation

## 1. Create Order

Method: POST

URL:
http://localhost:8080/orders

Request Body:

```json
{
  "symbol": "TCS",
  "side": "BUY",
  "type": "LIMIT",
  "price": 3200,
  "quantity": 15
}
```

Response:

```json
{
  "orderId": 1,
  "status": "OPEN",
  "message": "Order processed successfully"
}
```

---

## 2. Get Order Book

Method: GET

URL:

http://localhost:8080/orders/book

---

## 3. Get Trades

Method: GET

URL:

http://localhost:8080/trades

---

## 4. Get Trade Count

Method: GET

URL:

http://localhost:8080/trades/count

---

## 5. Delete Trades

Method: DELETE

URL:

http://localhost:8080/trades