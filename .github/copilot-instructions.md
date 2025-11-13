This repository is a small Spring Boot website (Java 17, Maven, Thymeleaf) for SoftSolutions Technologies LLC.

Keep instructions concise and codebase-specific. Avoid changing UI assets unless asked.

Key facts an AI agent should know:

- Project type: Spring Boot web application. Entry point: `src/main/java/com/softsolutions/SoftSolutionsTechnologiesLlcApplication.java`.
- Templates: Thymeleaf HTML files under `src/main/resources/templates/` (e.g. `index.html`, `it.html`, `software.html`). Edit these for content changes or small layout fixes.
- Static assets live in `src/main/resources/static/assets/` (css, js, vendor libraries). Keep naming and pathing consistent with existing references in templates.
- Security: Basic Spring Security setup in `src/main/java/com/softsolutions/config/SecurityConfig.java`. Public endpoints are explicitly permitted in that file (", /it, /cybersecurity, /software, /ai, /assets/**, /h2-console/**"). Update there when changing route access.
- Database: Embedded H2 configured via `src/main/resources/application.properties`. The project uses a file-backed H2 DB at `jdbc:h2:file:./data/softsolutionsdb` (username `sa`, password `1234`). Expect local dev to require no external DB.

Build & run (Windows / cmd.exe):

- Build: `mvn clean package` or `mvnw.cmd clean package`.
- Run in dev: `mvn spring-boot:run` or `mvnw.cmd spring-boot:run`.
- Run the produced jar: `java -jar target/SoftSolutionsTechnologiesLLC-0.0.1-SNAPSHOT.jar` (artifactId in pom.xml).

Developer patterns & conventions:

- Controller routing: simple Thymeleaf controllers under `com.softsolutions.controller.AppController`. Add new pages by creating a mapping method that returns the template name.
- Static files are referenced with relative paths like `assets/css/main.css` from templates. When modifying paths, maintain the same folder layout.
- Do not alter third-party vendor files under `static/assets/vendor/` unless updating library versions. Prefer minimal edits to `assets/css/main.css` for styling fixes.
- Security changes: update `SecurityConfig.java`. The project disables CSRF and frameOptions (to allow H2 console). Keep those settings in mind when modifying security behavior.

Testing & troubleshooting:

- Unit tests: `mvn test` (there is a basic Spring Boot test in `test/java/.../SoftSolutionsTechnologiesLlcApplicationTests.java`).
- H2 console: `http://localhost:8080/h2-console` (use the JDBC URL from `application.properties`).
- If port 8080 is in use, update `server.port` in `application.properties` for local testing.

When making changes, follow this checklist:

1. Update or add Java code under `src/main/java/com/softsolutions/`.
2. Update templates under `src/main/resources/templates/` for UI changes.
3. Update static assets under `src/main/resources/static/assets/` if styling/JS changes are needed.
4. Run `mvn test` then `mvn spring-boot:run` and verify pages at `http://localhost:8080` and `http://localhost:8080/h2-console`.

Examples (common edits):

- Add a new public page: create `src/main/resources/templates/newpage.html` and add a `@GetMapping("/newpage")` method in `AppController` returning `"newpage"`. If it should be public, add the path to the permitted matchers in `SecurityConfig`.
- Change a CSS color: edit `src/main/resources/static/assets/css/main.css`. Confirm the file is linked in `index.html`.

Files to reference when coding:

- `pom.xml` — dependencies & Java version (Java 17).
- `src/main/resources/application.properties` — DB, port, devtools, H2 console settings.
- `src/main/java/com/softsolutions/config/SecurityConfig.java` — security rules.
- `src/main/java/com/softsolutions/controller/AppController.java` — route-to-template mapping.

If you need clarification, ask which area to modify (backend Java, Thymeleaf template, or static assets) and which browsers/viewport sizes to support for UI changes.

Feedback request: tell me if you'd like more examples (e.g., how to add a REST endpoint, integrate a new library, or run with Docker).
