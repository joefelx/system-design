
### **Important Design Patterns**

> These patterns cover most of the real world code.

- Singleton
- Factory(Factory Method + Abstract Method)
- Strategy
- Observer
- Builder
- Decorator
- Adapter

---

### **10 Steps of LLD**

1. Clarify the requirements
	- Functional vs Non Functional requirements

2. Identify Entities
	- From **Nouns in the requirement to Class** names

3. Identify Behaviours
	- What actions do the entity or class perform.
	- Convert the **verbs to methods**

4. Identify Relationships
	- Association (uses, has-a)
	- Aggregation / Composition (stronger has-a)
	- Inheritance (is-a)

5. Identify the changes
	- Identifying changes that might happen in future and apply the design patterns where it is required.

6.  Draw Class diagram
	- It is important that before start coding, drawing the class diagram is important.
	- If the diagram is clean, the coding is easier.

7. Define Interfaces and Abstractions
	- Good lld must depend on the abstraction and not on the concrete classes.

8. Design the flow
	- Able to fulfil the use case and clear flow in the design has to be achieved otherwise the design in weak.
	
	> Example:
	> User Books -> Ticket Generation -> Payment Processed -> Confirmation sent

9. Write Skeleton code
	- Class and Methods
	- No need for the implementation (business logic), just the whole system as **code from design**.

10. Review
	- Check your design with 
		- Design principles like SOLID, DRY, KISS
		- Design patterns like Singleton, Factory, Abstract, Strategy.


---

### UML Basics

**Building Blocks of UML Diagrams**

- \+ (public)
- \- (private)
- \# (protected)
- ~ (package)


**Relationships**

- Association - uses-a relationship (->)
- Aggregation - has-a relationship (-<>)
- Composition - strong has-a relationship (-<*>)
- Inheritance - is-a relationship (-|>)
- Implementation - implementation of the interface (--|>)
- Dependency - Depending on the another class. It is also use-a relationship (-->)

---

### 7 Design Patterns over most of the problems

#### Creational Patterns

- Singleton pattern.
- Factory Pattern.
- Builder Pattern.

#### Behavioural Pattern

- Strategy.
- Observer.
- Decorator

#### Integration

- Adapter

##### **Singleton Pattern**
It will only have one instance global to unsure reusability without creation new object every time.

- DB connection pool
- Logger
- Config loader

##### **Factory Pattern**
To unsure the centralised object creation.

- UI toolkit creating buttons for different OS
- Frameworks creating beans (Spring)

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Square"); }
}

class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        if (type.equalsIgnoreCase("square")) return new Square();
        return null;
    }
}

```




##### **Builder Pattern**
I skip this for now, because i didn't understand how it is implemented

##### **Strategy Pattern**

- When we want different implementation for the particular method like Payment system where we have option got Paytm, Gpay and etc option on top of UPI.
- It passed over at the run time. Like having a common interface like UPI payments and its implementation changes.
- Calling those implemented Class by passing it as an object to the methods that perform the payment operations, where the chose of the implemented is called on the run time.

use case:
- Payment gateway selection
- Compression strategy (zip, gzip)
- Sorting techniques

```java
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " with credit card");
    }
}

class UPIPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(int amount) {
        strategy.pay(amount);
    }
}

```


##### **Observer Pattern**
We want to notify multiple dependent objects when something changes.

```java
interface Observer {
    void update(String message);
}

class EmailNotifier implements Observer {
    public void update(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSNotifier implements Observer {
    public void update(String message) {
        System.out.println("SMS: " + message);
    }
}

class EventPublisher {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void notifyAllObservers(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}

```

##### **Decorator Pattern**
It is more of like adding additional features to the existing class without modifications.

- Java I/O streams
- Middleware layers

```java
interface Coffee {
    String getDescription();
    int cost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple Coffee"; }
    public int cost() { return 5; }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;
    public MilkDecorator(Coffee coffee) { this.coffee = coffee; }

    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public int cost() { return coffee.cost() + 2; }
}

```


#### **Adapter**

As name suggest, the adapter is used to make two incompatible interfaces work together.

```java
interface NewCharger {
    void chargePhone();
}

class OldCharger {
    public void oldCharge() {
        System.out.println("Charging with old charger");
    }
}

class ChargerAdapter implements NewCharger {
    private OldCharger oldCharger;

    public ChargerAdapter(OldCharger oldCharger) {
        this.oldCharger = oldCharger;
    }

    public void chargePhone() {
        oldCharger.oldCharge();
    }
}

```


---

### **OOPS & SOLID PRINCIPLES**

OOP - Object Oriented Programming

It has four principles:

- Inheritance.
- Abstraction.
- Encapsulation.
- Polymorphism.


#### Inheritance — _Mechanism for Code Reuse via Hierarchies_

> When a class derives from another to reuse or extend its behavior, it forms an _is-a_ relationship.

**Use only when:**

- There's a true generalization-specialization relationship.
- You want to reuse code, not just access it.

**Cracked understanding:**

> Prefer _composition_ over inheritance unless you're modeling real taxonomic hierarchies. Inheritance couples tightly — changes in parent ripple to child.

---

#### Abstraction — *Expose Behaviour, Hide Complexity*

> Abstraction is exposing only relevant behaviour to the outside world and hiding internal implementation.

**In design:**

- Achieved via interfaces and abstract classes.    
- Helps reduce coupling and enforce contracts.

**Cracked understanding:**

> You abstract not just to “hide,” but to _decouple interface from implementation_, so changes inside don't break consumers.

---

#### Encapsulation — _Protect State and Behavior Behind Boundaries_

> Encapsulation means bundling data and methods, and restricting access to internals using access modifiers.

**In design:**

- Keep fields `private`, expose via controlled getters/setters.
- Guard invariants, prevent inconsistent state.

**Cracked understanding:**

> Encapsulation is not just “hiding.” It’s _controlling access_ to prevent misuse and keep objects valid and consistent.

---

#### Polymorphism — _Unified Interface, Varying Behavior_

> The ability of different types (usually subclasses or implementations) to respond to the same method call in different ways.

**In Java:**

- **Compile-time polymorphism**: Method overloading
- **Runtime polymorphism**: Method overriding via inheritance or interfaces

**Cracked understanding:**

> Polymorphism enables extensibility without modification — core to Open/Closed Principle. It's why interfaces matter.


---

