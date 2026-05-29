# Subscription Management API

A simple Spring Boot REST API for managing users, subscriptions, and the payment method attached to a subscription.

The project currently uses in-memory lists for storage, so data is reset every time the application restarts.

## Tech Stack

- Java 21
- Spring Boot 4
- Spring Web
- Maven Wrapper
- Docker

## Project Structure

```text
src/main/java/com/timle/subscriptionapi
+-- controller
|   +-- SubscriptionController.java
|   +-- UserController.java
+-- model
|   +-- PaymentMethod.java
|   +-- Subscription.java
|   +-- User.java
+-- service
|   +-- SubscriptionService.java
|   +-- UserService.java
+-- SubscriptionapiApplication.java
```

## Getting Started

### Prerequisites

- Java 21 or newer
- Docker Desktop, if running the app in a container
- No separate Maven installation is required because the project includes the Maven Wrapper.

### Run the Application

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

On macOS/Linux:

```bash
./mvnw spring-boot:run
```

The API starts at:

```text
http://localhost:8080
```

### Build and Run with Docker

First build the jar:

On Windows:

```powershell
.\mvnw.cmd clean package
```

On macOS/Linux:

```bash
./mvnw clean package
```

Then build the Docker image:

```bash
docker build -t subscription-api .
```

Run the container on the default port:

```bash
docker run -p 8080:8080 subscription-api
```

The API starts at:

```text
http://localhost:8080
```

The application also supports setting the port with the `PORT` environment variable:

```bash
docker run -e PORT=9090 -p 9090:9090 subscription-api
```

With this command, the API starts at:

```text
http://localhost:9090
```

### Run Tests

On Windows:

```powershell
.\mvnw.cmd test
```

On macOS/Linux:

```bash
./mvnw test
```

## API Endpoints

### Users

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/users` | Get all users |
| POST | `/users` | Create a user |
| GET | `/users/{id}` | Get a user by ID |
| DELETE | `/users/{id}` | Delete a user by ID |

### Subscriptions

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/subscriptions` | Get all subscriptions |
| POST | `/subscriptions` | Create a subscription |
| GET | `/subscriptions/{id}` | Get a subscription by ID |
| DELETE | `/subscriptions/{id}` | Delete a subscription by ID |

### Subscription Payment Methods

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/subscriptions/{id}/payment-method` | Get the payment method for a subscription |
| PUT | `/subscriptions/{id}/payment-method` | Set or replace the payment method for a subscription |
| DELETE | `/subscriptions/{id}/payment-method` | Remove the payment method from a subscription |

## Example Requests

### Create a User

```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "name": "Tim Le",
    "email": "alex@example.com"
  }'
```

### Create a Subscription

```bash
curl -X POST http://localhost:8080/subscriptions \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "merchantName": "Netflix",
    "amount": 15.99,
    "frequency": "Monthly",
    "user": {
      "id": 1,
      "name": "Tim Le",
      "email": "tim@example.com"
    },
    "paymentMethod": {
      "id": 1,
      "cardHolder": "Tim Le",
      "lastFourDigits": "4242",
      "cardType": "Visa"
    }
  }'
```

### Update a Subscription Payment Method

```bash
curl -X PUT http://localhost:8080/subscriptions/1/payment-method \
  -H "Content-Type: application/json" \
  -d '{
    "id": 2,
    "cardHolder": "Tim Le",
    "lastFourDigits": "1111",
    "cardType": "Mastercard"
  }'
```

## Notes

- IDs are supplied by the request body; the API does not currently auto-generate them.
- Missing records currently return `null` instead of a custom HTTP error response.
- Data is not persisted to a database yet.
