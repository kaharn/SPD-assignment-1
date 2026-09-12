Конечно — вот готовое **Markdown-содержимое**, которое можно просто вставить в `README.md`:

````
---

## ⚙️ How to Build and Run

### Option 1: Running via Terminal / CLI

Clone the repository:

```bash
git clone <your-repository-url>
cd assignment1
````

Compile the project source files:

```
javac -d out src/com/astana/builder/*.java
```

Run the executable `Main` class:

```
java -cp out com.astana.builder.Main
```

### Option 2: Running via IntelliJ IDEA

1. Open **IntelliJ IDEA**.
2. Select **File → Open...** and choose the root directory `shp-2216-assignment1-builder`.
3. Ensure **JDK 17** is assigned under **File → Project Structure → Project SDK**.
4. Navigate to:

```
src/com/astana/builder/Main.java
```

5. Click **Run** or use the shortcut **Shift + F10**.

---

## 💻 Code Usage Examples

### 1\. Custom Construction using Fluent Interface

The Builder pattern allows reports to be created step-by-step using a fluent interface with method chaining:

```
ReportBuilder builder = new HtmlReportBuilder();

Report customReport = builder
        .setTitle("Software Design Patterns Report")
        .setAuthor("Nassyrkhan Kakhar")
        .addSection("Introduction", "Exploring the Builder Pattern in Java 17.")
        .setFooter("Astana IT University 2026")
        .build();

System.out.println(builder.getFormattedOutput());
```

This approach makes the construction process readable and allows the client to specify only the required configuration.

### 2\. Pre-configured Construction via Director

The `ReportDirector` can be used when a predefined construction sequence is required:

```
ReportDirector director = new ReportDirector();
ReportBuilder mdBuilder = new MarkdownReportBuilder();

director.constructExecutiveSummary(mdBuilder, "Alex Mercer");

Report execSummary = mdBuilder.build();

System.out.println(mdBuilder.getFormattedOutput());
```

The Director encapsulates the construction sequence, while the Concrete Builder remains responsible for creating the final report representation.

---

## ✨ Clean Code Principles Applied

### Validated Construction — Fail-Fast Rule

The `build()` method performs internal validation through `validateState()` before creating the final `Report` object.

If mandatory attributes such as `title` or `author` are `null` or blank, the builder throws an `IllegalStateException`. This prevents invalid objects from being created.

### Encapsulation & Immutability

Fields inside `Report` are declared as `private final`.

Collections are encapsulated using:

```
Collections.unmodifiableList()
```

This guarantees that the created report cannot be modified after construction.

### Fluent Interface — Method Chaining

Concrete builder methods return `this` as a `ReportBuilder`, allowing multiple construction operations to be chained together:

```
builder
        .setTitle("Title")
        .setAuthor("Author")
        .addSection("Section", "Content")
        .build();
```

This eliminates unnecessary temporary variables and improves readability.

### Single Responsibility Principle (SRP)

Responsibilities are separated between the project components:

- **Builders** are responsible for object construction and validation.
- **`ReportDirector`** contains predefined assembly logic.
- **`Report`** represents the final data structure.
- **Concrete Builders** are responsible for format-specific representation.

This separation makes the system easier to understand, maintain, and extend.

### No Magic Strings / Numbers

Predefined configurations and report formats use explicit constants, domain methods, and the `ReportFormat` enum instead of scattered magic strings or numeric values.

This improves code readability and reduces the possibility of inconsistent values across the application.

---

## 🧪 Validation and Error Handling

The implementation also demonstrates defensive object construction.

For example, attempting to build a report without mandatory information results in an exception:

```
ReportBuilder builder = new HtmlReportBuilder();

builder
        .setTitle("")
        .setAuthor("John Doe")
        .build();
```

The builder validates its state before construction and throws:

```
IllegalStateException
```

This follows the **fail-fast principle**, ensuring that invalid state is detected as early as possible.

---

## 🔄 Extensibility

One of the main advantages of the Builder pattern in this project is that new report formats can be introduced without significantly changing the client code.

For example, future implementations could include:

```
PdfReportBuilder
JsonReportBuilder
XmlReportBuilder
```

Each new Concrete Builder would implement the existing `ReportBuilder` interface while providing its own representation logic.

The `ReportDirector` could also be extended with additional predefined construction methods without changing the `Report` product itself.

---

## 🎯 Design Pattern Benefits

The Builder pattern provides several benefits in this project:

- Separates complex object construction from the final representation.
- Supports different report formats using the same construction interface.
- Makes object creation readable through method chaining.
- Allows optional report properties to be configured flexibly.
- Centralizes validation before object creation.
- Supports predefined construction sequences through the Director.
- Makes the system easier to extend with additional report formats.
- Helps maintain immutable final `Report` objects.

---

## 📌 Conclusion

This project demonstrates a practical implementation of the **Builder Design Pattern** using Java 17.

The solution separates the construction of complex report objects from their representation and provides both flexible custom construction and predefined construction through the `ReportDirector`.

The combination of **Builder**, **Concrete Builders**, **Director**, and **Product** demonstrates the core structure of the GoF Builder pattern while applying clean code principles such as **SRP, encapsulation, immutability, fail-fast validation, and avoidance of magic values**.

```

```