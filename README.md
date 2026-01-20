Spring Boot E-Commerce Backend

This project is a backend application for an e-commerce system built using Spring Boot. It provides APIs to manage products, shopping cart, orders, and payments. The project is designed for learning purposes and can be easily extended with real payment gateways like Razorpay.

🚀 Features Implemented

Add and view products

Add products to cart and view cart items

Create orders from cart with automatic total calculation

Mock payment handling with order status update

Ready for Razorpay payment gateway integration

🛠️ Technologies Used

Java

Spring Boot

Spring Web

Spring Data

Maven

▶️ How to Run the Project

Clone the repository:

git clone https://github.com/tarun250/springboot_ecommerce_backend.git


Open the project in IntelliJ / Eclipse

Run the application using:

mvn spring-boot:run


The server will start at:

http://localhost:8080

📡 API Overview
Product APIs

POST /api/products – Add a new product

GET /api/products – View all products

Cart APIs

POST /api/cart/add – Add product to cart

GET /api/cart/{userId} – View cart

DELETE /api/cart/{userId}/clear – Clear cart

Order APIs

POST /api/orders – Create order from cart

GET /api/orders/{orderId} – View order details

Payment APIs

POST /api/payments/create – Create mock payment

Order status updates automatically after payment


🧠 Project Understanding (Simple)

This backend simulates the complete flow of an e-commerce system where users can browse products, add them to a cart, place orders, and complete payments. The project follows clean architecture and REST API principles.

📌 Notes

This project is intended for educational and demonstration purposes

Mock payment is used by default

Real payment gateways can be added easily

📜 License

This project is open for academic and learning use.
