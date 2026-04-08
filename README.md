# 60 Days — Zero to Fullstack Java + Angular

## Contexte

Étudiant en 2ème année de Bachelor Informatique à **Ynov Aix-en-Provence**, j'ai remarqué que le marché du travail demande massivement des profils **Java Spring Boot + Angular** — une stack absente de mon cursus principal.

Je me suis fixé un objectif simple : devenir opérationnel sur cette stack en **60 jours**, avec des sessions de code quotidiennes, tout en maintenant mon rythme d'étudiant — cours l'après-midi, travail la nuit (18h–3h).

---

## Méthode d'apprentissage

Cet apprentissage est guidé par un **agent IA agissant comme mentor technique**, avec des règles strictes :

**Interdiction de génération** — L'agent ne code jamais à ma place. Chaque ligne de ce repo, je l'ai écrite moi-même.

**Méthode Socratique** — L'agent pose des questions, oriente vers la documentation, donne des indices. Il me laisse faire les erreurs et les comprendre.

**Code Review** — À chaque étape, l'agent analyse mon code, identifie les problèmes, et me pousse à les corriger moi-même plutôt que de les corriger directement.

**Compréhension avant progression** — Je ne passe à la notion suivante qu'une fois que j'ai compris et su expliquer la précédente. Chaque concept est ancré dans mes connaissances existantes (Go, JavaScript, Python).

---

## Stack cible

**Backend :** Java 21, Spring Boot, Spring Data JPA, Spring Security / JWT, PostgreSQL

**Frontend :** TypeScript, Angular

---

## Roadmap

### S1 — Java Core

#### J1 — 02/04/2026
- Setup IntelliJ + configuration JDK 21
- Migration VS Code → IntelliJ
- Révision des exercices S1 (héritage, interfaces, collections, exceptions, static/final/abstract)
- Début mini-projet : `Component` (abstract) + `MechanicalComponent`

#### J2 — 03/04/2026
- `ElectricalComponent` (héritage, attribut spécifique)
- `ComponentNotFoundException` (exception custom, RuntimeException)
- `ComponentRegistry` (Map<String, Component>, CRUD complet)
- `Main` (CLI avec Scanner, switch, try/catch)
- Mini-projet S1 fonctionnel et compris de bout en bout

#### J3 — 04/04/2026
- Méthode générique `<T>` : `first(List<T> list)`
- Classe générique `Pair<A, B>` avec attributs, constructeur, getters
- Bounded generic `<T extends Component>` : `findHeaviest(List<T> list)`

#### J4 — 05/04/2026
- Lambdas : syntaxe `x -> operation`, passage en argument
- Streams : `filter`, `map`, `forEach`, `sorted`, `reduce`, `toList()`
- Method references : `Classe::méthode`
- Exercices sur `List<Integer>`, `List<String>` et objets `MechanicalComponent`

#### J5 — 07/04/2026
- Interface `Nameable` comme contrat générique
- `GenericRegistry<T extends Nameable>` : registre générique réutilisable
- `NotFoundException` découplée du domaine
- Streams sur `GenericRegistry` via `getAll()` + `map` + `forEach`

#### J6 — 08/04/2026
> Journée chargée — boulot étudiant jusqu'à 1h du mat, session de code après. 4h du mat quand j'ai posé le clavier. Pas grand chose de fait, mais présent quand même.
- Setup projet Spring Boot via start.spring.io, extraction dans `/sb/demo`
- Lancement `./mvnw spring-boot:run` → Tomcat démarré sur port 8080
- Compréhension de l'IoC : Spring prend le contrôle à la place du développeur
- `@SpringBootApplication` = `@SpringBootConfiguration` + `@EnableAutoConfiguration` + `@ComponentScan`
- Création de `ComponentController` : premier endpoint `GET /components` → retourne `List<String>` en JSON
- Compréhension de `@RestController`, `@RequestMapping`, `@GetMapping`
- Deuxième endpoint `GET /components/{name}` avec `@PathVariable`
- Constat : la liste est hardcodée, les deux méthodes ne la partagent pas → à résoudre J7

---

### À venir

- **J7** — Spring Boot : liste partagée, gestion d'erreurs (404), `@Service`, architecture en couches
