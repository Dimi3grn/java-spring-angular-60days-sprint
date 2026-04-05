# Roadmap 60 jours — Java Spring Boot + Angular

## S1 — Java Core

### J1 — 02/04/2026
- Setup IntelliJ + configuration JDK 21
- Migration VS Code → IntelliJ
- Révision des exercices S1 (héritage, interfaces, collections, exceptions, static/final/abstract)
- Début mini-projet : `Component` (abstract) + `MechanicalComponent`

### J2 — 03/04/2026
- `ElectricalComponent` (héritage, attribut spécifique)
- `ComponentNotFoundException` (exception custom, RuntimeException)
- `ComponentRegistry` (Map<String, Component>, CRUD complet)
- `Main` (CLI avec Scanner, switch, try/catch)
- Mini-projet S1 fonctionnel et compris de bout en bout

### J3 — 04/04/2026
- Méthode générique `<T>` : `first(List<T> list)`
- Classe générique `Pair<A, B>` avec attributs, constructeur, getters
- Bounded generic `<T extends Component>` : `findHeaviest(List<T> list)`

### J4 — 05/04/2026
- Lambdas : syntaxe `x -> operation`, passage en argument
- Streams : `filter`, `map`, `forEach`, `sorted`, `reduce`, `toList()`
- Method references : `Classe::méthode`
- Exercices sur `List<Integer>`, `List<String>` et objets `MechanicalComponent`

---

## À venir

### J5 — Mini-exercice combiné (Generics + Streams)
### J6/J7 — Spring Boot (S2)
