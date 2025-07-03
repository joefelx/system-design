
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

