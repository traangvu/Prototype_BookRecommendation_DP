# Prototype_BookRecommendation_DP

# Book Recommendation System (Prototype Design Pattern)

This Java-based **Book Recommendation System** demonstrates the **Prototype Design Pattern**. It allows users to manage and customize book recommendation lists for different audiences by **cloning and modifying** existing lists instead of starting from scratch.

---

The **Prototype Pattern** is a **creational design pattern** used to create duplicate objects while keeping performance in mind. Instead of instantiating new objects with constructors, the pattern allows you to make **deep or shallow copies** of an existing object using a cloning method.

### Key Benefits:
- Reduces the cost of creating new objects.
- Encourages reuse and configuration sharing.
- Useful when object creation is resource-intensive or complex.

---

## How the Prototype Pattern Works in This Project

| Prototype Element        | Implementation                                     |
|--------------------------|----------------------------------------------------|
| Prototype object         | `Book` and `Recommendation` implement `Cloneable`. |
| Shallow vs. Deep Copy    | `Book` uses shallow copy (basic fields).<br>`Recommendation` uses **deep copy** — it clones the list and all contained `Book` objects. |
| Object reuse             | Users can clone an entire recommendation list, modify it, and save it for another target audience. |

---

## 🧱 System Components

### 1. `Book` (Abstract Class)
Represents a general book. Implements `Cloneable` to support copying.

**Attributes**:
- `title`
- `author`
- `genre`
- `publicationYear`

**Method**:
- `clone()` — copies the book instance.

### 2. `Novel` and `Comics` (Subclasses of Book)
Concrete book types that inherit from `Book` and override the `clone()` method for type-specific cloning.

### 3. `Recommendation`
Holds a list of `Book` objects for a specific `targetAudience`.

**Attributes**:
- `targetAudience` — a string describing the intended reader group.
- `List<Book>` — a collection of books.

**Key Methods**:
- `clone()` — performs a deep copy (clones each `Book`).
- `addBook(Book book)` — adds a new book.
- `removeBook(int index)` — removes a book by index.
- `setTargetAudience(String audience)` — updates the target audience.

### 4. `Main` (CLI Interface)
A command-line menu for user interaction.

**Features**:
- View existing recommendations.
- Clone and customize recommendations.
- Add or remove books.
- Change the target audience.

---