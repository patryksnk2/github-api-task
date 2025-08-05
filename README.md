
# GitHub API Consumer

Aplikacja Spring Boot, która działa jako konsument API GitHub, pobierając informacje o repozytoriach użytkownika GitHub. Aplikacja jest w stanie wylistować repozytoria, które nie są forkami, oraz dla każdego repozytorium zwrócić szczegóły dotyczące branchy i ostatnich commitów. Aplikacja umożliwia obsługę błędów w przypadku nieistniejącego użytkownika GitHub.

## Spis treści

- [Opis](#opis)
- [Wymagania](#wymagania)
- [Instalacja](#instalacja)
- [Użycie](#użycie)
- [Testy](#testy)
- [Struktura projektu](#struktura-projektu)
- [Autor](#autor)

## Opis

Aplikacja pozwala na:

1. **Wyszukiwanie repozytoriów**:
    - Aplikacja łączy się z GitHub API, aby pobrać informacje o repozytoriach użytkownika GitHub, które **nie są forkami**.
    - Zwracane dane zawierają:
        - **Nazwa repozytorium**.
        - **Login właściciela repozytorium**.
        - **Dla każdego branchu**: nazwa oraz SHA ostatniego commita.

2. **Obsługa błędów**:
    - W przypadku nieistniejącego użytkownika GitHub, aplikacja zwróci kod odpowiedzi **404**.

3. **Testowanie**:
    - Aplikacja zawiera **test integracyjny** sprawdzający pozytywną sytuację, kiedy użytkownik GitHub istnieje i dane o repozytoriach są poprawnie zwracane.

## Wymagania

- **Java 21** lub wyższa.
- **Spring Boot** 3.5.x.
- **Gradle** (zainstalowany lokalnie, aby móc uruchomić komendy).

## Instalacja

1. **Klonowanie repozytorium:**

   Aby sklonować repozytorium, użyj poniższego polecenia:

   ```bash
   git clone https://github.com/patryksnk2/github-api-task.git
   ```

2. **Instalacja zależności:**

   W katalogu głównym projektu uruchom:

   ```bash
   ./gradlew build
   ```

   To polecenie pobierze wszystkie zależności i przygotuje projekt do uruchomienia.

## Użycie

1. **Uruchomienie aplikacji:**

   Aby uruchomić aplikację, użyj polecenia:

   ```bash
   ./gradlew bootRun
   ```

2. **API:**

   Aplikacja uruchamia się na losowym porcie, który możesz znaleźć w logach po uruchomieniu. Domyślnie API będzie dostępne pod adresem:

   ```
   http://localhost:<port>/api/repos/{username}
   ```

   Gdzie `{username}` to login użytkownika GitHub, którego repozytoria chcesz pobrać.

   **Przykład żądania:**

   ```bash
   GET http://localhost:<port>/api/repos/test
   ```

   Oczekiwany wynik to lista repozytoriów użytkownika o nazwie "test", które nie są forkami, z informacjami o branchach i ostatnich commitach.

3. **Błąd 404:**

   W przypadku nieistniejącego użytkownika GitHub, aplikacja zwróci odpowiedź z kodem `404 Not Found`.

## Testy

Aplikacja zawiera **test integracyjny** sprawdzający pozytywną sytuację, kiedy użytkownik GitHub istnieje i mamy dane o repozytoriach. Test jest zaprojektowany, aby sprawdzić jak najwięcej logiki biznesowej w jednym teście.

Aby uruchomić testy, użyj polecenia:

```bash
./gradlew test
```

## Struktura projektu

```
src
├── main
│   ├── java
│   │   ├── com
│   │   │   ├── atipera
│   │   │   │   ├── githubapi
│   │   │   │   │   ├── controller
│   │   │   │   │   ├── dto
│   │   │   │   │   ├── service
│   │   │   │   │   ├── client
│   │   │   │   │   └── GitHubApiApplication.java
├── test
│   ├── java
│   │   ├── com
│   │   │   ├── atipera
│   │   │   │   ├── githubapi
│   │   │   │   │   ├── GitHubControllerIntegrationTest.java
│   │   │   │   │   ├── service
│   │   │   │   │   └── client
└── build.gradle
```

- **controller**: Zawiera kontroler obsługujący endpoint `/api/repos/{username}`.
- **dto**: Zawiera obiekt Data Transfer Object (DTO) używany do mapowania danych z GitHub.
- **service**: Zawiera logikę biznesową, w tym przetwarzanie danych o repozytoriach i branchach.
- **client**: Zawiera klienta API do komunikacji z GitHub.

## Autor

Patryk Czerski  
GitHub: [patryksnk2](https://github.com/patryksnk2)  
LinkedIn: [Patryk Czerski](https://www.linkedin.com/in/patryk-czerski-84b36b378/)
