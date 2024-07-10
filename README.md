# Online Shopping System

This repository contains a comprehensive Online Shopping System developed using Core Java with a strong emphasis on Object-Oriented Programming (OOP) principles. The system is designed to manage various aspects of online shopping, including product management, customer management, order processing, and more.

## Table of Contents

- [Features](#features)
- [Class Structure](#class-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Contact](#contact)

## Features

- **Admin Management**: Manage admin-related functionalities.
- **Customer Management**: Add, view, and remove customer information.
- **Product Management**: Add, view, and remove products.
- **Order Processing**: Handle order creation, updates, and management.
- **Billing**: Generate bills for orders.
- **Coupon Management**: Add, view, and manage discount coupons.
- **Stock Management**: Monitor and update product stock levels.
- **Wishlist Management**: Handle customer wishlists.
- **Data Loading**: Load initial data for testing and development purposes.

## Class Structure

### Core Classes

- **Admin.java**: Handles admin functionalities.
- **AdminRepo.java**: Repository for storing admin data.
- **AdminServices.java**: Services for admin operations.
- **App.java**: The main application class.
- **BillItem.java**: Represents individual items in a bill.
- **Coupon.java**: Represents discount coupons.
- **CouponRepo.java**: Repository for storing coupons.
- **Customer.java**: Handles customer functionalities.
- **CustomerRepo.java**: Repository for storing customer data.
- **CustomerServices.java**: Services for customer operations.
- **Loaders.java**: Loads initial data into the system.
- **Order.java**: Represents customer orders.
- **OrderRepo.java**: Repository for storing orders.
- **Product.java**: Represents products in the system.
- **ProductRepo.java**: Repository for storing products.
- **Stock.java**: Manages stock levels for products.
- **StockRepo.java**: Repository for storing stock information.
- **WishList.java**: Manages customer wishlists.
- **WishlistRepo.java**: Repository for storing wishlists.

## Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/rex-alan/online-shopping-system.git
    ```

2. **Navigate to the project directory**:
    ```bash
    cd online-shopping-system
    ```

3. **Compile the Java files**:
    ```bash
    javac -d bin src/*.java
    ```

4. **Run the application**:
    ```bash
    java -cp bin App
    ```

## Usage

1. **Run the application**:
    ```bash
    java -cp bin App
    ```

2. **Follow the on-screen prompts** to navigate through different functionalities:
    - Admin
    - Customers
    - Products
    - Orders
    - Billing
    - Coupons
    - Stock
    - Wishlists

## Contact

For any queries or contributions, please contact rexalan1174@gmail.com.
