# Week 8 – Conceptual Questions and Answers

## 1. Explain encapsulation using User.email and validation.

Encapsulation keeps an object's data private and provides controlled access through methods. For example, declare `email` as `private` and provide a setter that checks whether the supplied email is valid before updating it. This prevents invalid data from being stored and protects the object's state.

## 2. In a system with optional DataExport and DataVisualization capabilities, should inheritance or composition be used?

Composition is suitable when these capabilities are optional or can be combined in different ways. A class can contain or receive capability objects without creating a separate subclass for every combination. This reduces a rigid inheritance hierarchy and makes the system easier to extend.

## 3. Explain abstraction, overriding, and runtime polymorphism using NotificationService and InAppNotification.

Define a common abstract class or interface for notifications with a method such as `send()`. Concrete notification types, including `InAppNotification`, implement or override that method. When the program calls `send()` through a common reference, Java selects the implementation belonging to the actual object at runtime. This demonstrates abstraction, method overriding, and runtime polymorphism.

## 4. Explain composition for Organization–Department and aggregation for Department–Employee.

- **Composition (Organization–Department):** A strong whole-part relationship. In the model, a Department is treated as belonging to the Organization's lifecycle.
- **Aggregation (Department–Employee):** A weaker whole-part relationship. Employees can exist independently of a particular Department and may be reassigned.

## 5. Model Student–Course enrollment using UML multiplicity. How is duplicate enrollment prevented?

A Student can enroll in many Courses, and a Course can have many Students, so the relationship is many-to-many (`0..*` on both ends, depending on the system's rules). Multiplicity describes how many objects may be related; it does not itself prevent duplicate enrollment. Enforce that rule with business logic, such as checking existing enrollments or using a unique constraint on the Student–Course pair.
