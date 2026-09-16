# Java Shopping Cart — Software Testing & Quality Assurance

A Java-based shopping cart application developed as a mini project for a **Software Testing and Quality Assurance** course.

The project focuses on both software implementation and systematic testing using **JUnit, EclEmma, and PIT Mutation Testing**.

## Features

The application provides a command-line shopping workflow supporting:

* Add items to a shopping cart
* View cart contents
* Edit item quantities
* Remove items
* Calculate order totals
* Apply state-based sales tax
* Calculate shipping charges
* Checkout

## Technologies

* Java
* JUnit
* EclEmma
* PIT Mutation Testing
* Eclipse
* Object-Oriented Programming

## Application Design

The application is separated into modular components:

### `Item`

Represents a purchasable product containing a name and price.

Input validation prevents invalid prices.

### `CartItem`

Associates an `Item` with a quantity and calculates the item's subtotal.

### `ShoppingCart`

Manages cart operations including:

* Adding items
* Editing quantities
* Removing items
* Calculating subtotal
* Applying tax
* Applying shipping costs
* Checkout

### `TaxCalculator`

Defines an abstraction for calculating sales tax.

`DefaultTaxCalculator` provides the default implementation.

### `ShippingMethod`

Supports two shipping options:

| Shipping Method | Cost |
| --------------- | ---: |
| Standard        |  $10 |
| Next Day        |  $25 |

Standard shipping becomes free when the raw purchase total exceeds $50.

## Tax Rules

The application applies a 6% sales tax for:

* Illinois (IL)
* California (CA)
* New York (NY)

Other states have no sales tax in the project specification.

## Software Testing

Testing was a major focus of the project.

### JUnit Testing

JUnit tests were developed to verify core functionality such as:

* Item creation and validation
* Cart operations
* Quantity validation
* Subtotal calculations
* Tax calculations
* Shipping calculations
* Checkout behavior
* Error handling

### Code Coverage

EclEmma was used to measure how much of the application source code was exercised by the test suite.

Coverage analysis helped identify portions of the implementation that required additional testing.

### Mutation Testing

PIT Mutation Testing was used to evaluate the effectiveness of the test suite.

Rather than measuring only whether code was executed, mutation testing introduces small changes to the program and determines whether the tests detect them.

This provided additional insight into test quality and helped identify weak or insufficient test cases.

## Software Engineering Concepts

This project demonstrates:

* Object-Oriented Programming
* Interfaces and implementations
* Encapsulation
* Exception handling
* Input validation
* Modular software design
* Unit testing
* Code coverage
* Mutation testing
* Software quality assurance

## Running the Application

Compile the project and run:

```bash
java mini.Main
```

The command-line interface provides options to add, view, edit, and remove items, calculate totals, checkout, or exit.

## Testing

Run the JUnit test suite through your Java IDE or Maven configuration.

Testing results and screenshots are available in:

```text
docs/testing-results/
```

## Academic Context

This project was completed as part of a **Software Testing and Quality Assurance** course mini project.

The project focused on implementing a functional Java application and evaluating its quality through unit testing, code coverage analysis, and mutation testing.
