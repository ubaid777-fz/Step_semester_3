# Week 10 – Conceptual Answers

## 1. Overloading vs Overriding
Method overloading means having methods with the same name but different parameter lists in the same class. It is resolved at compile time.

Method overriding occurs when a subclass provides its own implementation of a superclass method with the same signature. It is resolved at runtime through dynamic method dispatch.

## 2. Constructor Invocation
When an object of a derived class is created, the base-class constructor executes first, followed by the derived-class constructor. For example: Person → Employee → Manager. A derived constructor can pass values to its base constructor using super().

## 3. Concrete Class, Abstract Class and Interface
A concrete class can be instantiated and can contain state and implemented methods. An abstract class cannot be directly instantiated and can contain both implemented and abstract methods. An interface defines a common contract that classes can implement.

## 4. Two Interfaces with Same Abstract Method
If a class implements two interfaces that contain the same abstract method signature, the implementing class normally provides one implementation of that method. One implementation can satisfy both contracts.

## 5. equals() and hashCode()
equals() determines whether two objects should be considered equal based on their content. hashCode() produces a hash value used by hash-based collections such as HashSet and HashMap. If equals() is overridden but hashCode() is not, equal objects may have different hash codes and behave incorrectly in hash-based collections. If two objects are equal according to equals(), they must have the same hashCode().

## 6. Shallow Copy vs Deep Copy
A shallow copy copies the object but keeps references to the same nested objects. A deep copy creates independent copies of nested mutable objects as well. For example, two Student objects with a shared mutable Address may affect each other after a shallow copy; a deep copy gives each student a separate Address.

## 7. Inner Type vs Static Nested Type
A non-static inner class is associated with an instance of the outer class and can directly access the outer object's members. A static nested class does not require an outer-class object for creation and can directly access only static members of the outer class.

## 8. Array Operation Complexity
Accessing an array element by index is O(1), because its address can be calculated directly. Insertion or deletion in the middle of a fixed-size array is O(n), because elements may need to be shifted.

## 9. Base-Type Reference and Dynamic Dispatch
An array of a base type can store objects of different derived classes. When an overridden method is called through a base-type reference, Java uses dynamic method dispatch to execute the implementation belonging to the actual object.

## 10. IS-A vs CAN-DO
Use inheritance when one type is genuinely a specialized form of another, such as Car IS-A Vehicle. Use an interface for a capability that unrelated classes can share, such as an Eagle and a Drone both implementing Flyable.
