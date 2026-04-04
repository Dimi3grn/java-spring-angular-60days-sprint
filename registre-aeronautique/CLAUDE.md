# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Projects in this workspace

This workspace contains two sibling Maven projects under `java_angular_relearn/`:

| Project | Path | Purpose |
|---|---|---|
| `demo` | `../demo` | Java learning exercises (OOP concepts) |
| `registre-aeronautique` | `.` (this repo) | Aeronautical registry domain model |

Both use **Java 21**, **Maven**, and **JUnit 4.11**.

## Commands

All commands run from the respective project root (where `pom.xml` lives).

```bash
mvn compile          # compile
mvn test             # run all tests
mvn test -Dtest=ClassName          # run a single test class
mvn test -Dtest=ClassName#method   # run a single test method
mvn package          # build JAR
mvn clean            # clean target/
```

To run a specific exercise main class directly after compiling:
```bash
mvn compile exec:java -Dexec.mainClass="com.example.exercices.Ex02_Heritage"
```

## Architecture

### `registre-aeronautique`

Domain model for an aeronautical component registry.

- `src/main/java/com/example/registre/Component.java` — abstract base class with `name`, `weight`, and abstract `describe()`
- `src/main/java/com/example/registre/MechanicalComponent.java` — concrete subclass adding `maxRPM`

No tests yet; `src/test/` directory is absent.

### `demo` — learning exercises

Sequential exercises for a Go developer learning Java OOP. Each file in `com.example.exercices` is self-contained with its own `main()`:

| File | Concept |
|---|---|
| `AeroComponent.java` | Encapsulation, private fields, getters |
| `Ex02_Heritage.java` | Inheritance (`extends`), `super()`, `@Override` |
| `Ex03_Interfaces.java` | `interface`, `implements`, multiple interfaces |
| `Ex04_Collections.java` | `ArrayList`, `HashMap`, generics |
| `Ex05_Exceptions.java` | Checked vs unchecked, `try/catch/finally`, custom exceptions |
| `Ex06_StaticFinalAbstract.java` | `static`, `final`, abstract classes |

The exercises use an aeronautics domain (drones, rotors, turbines) as a consistent narrative thread. Comments in each file compare Java syntax to Go equivalents.
