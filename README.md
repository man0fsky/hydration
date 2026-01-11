# Hydration App

Hydration App to prosta aplikacja backendowa oparta o Spring Boot, służąca do
rejestrowania spożycia płynów oraz obliczania rzeczywistego bilansu nawodnienia
na podstawie rodzaju napoju.

Aplikacja udostępnia REST API umożliwiające:
- dodawanie informacji o wypitych napojach,
- obliczanie łącznej objętości spożytych płynów,
- obliczanie bilansu nawodnienia z uwzględnieniem współczynników dla różnych napojów
  (np. kawa, alkohol).

---

## Stack technologiczny

- Java 21 (Eclipse Temurin)
- Spring Boot 3
- Gradle
- JUnit 5
- REST API (Spring Web)

---

## Funkcjonalności

### 1. Rejestrowanie spożycia płynów
Użytkownik może dodać informację o wypitym napoju, podając:
- objętość (ml),
- typ napoju.

Aplikacja zapisuje wpis wraz z aktualną datą i godziną.

**Endpoint:**  
`POST /intake`

---

### 2. Obliczanie łącznej objętości wypitych płynów
Zwraca sumę objętości wszystkich zarejestrowanych napojów, niezależnie od ich typu.

**Endpoint:**  
`GET /intake/volume`

---

### 3. Obliczanie bilansu nawodnienia
Zwraca rzeczywisty bilans nawodnienia, obliczany jako iloczyn objętości napoju
i współczynnika nawodnienia przypisanego do jego typu
(np. alkohol ma ujemny wpływ na nawodnienie).

**Endpoint:**  
`GET /intake/hydration`

---

## Typy napojów i współczynniki nawodnienia

| Typ napoju      | Współczynnik |
|-----------------|--------------|
| WATER           | 1.0          |
| COFFEE          | 0.8          |
| TEA             | 0.9          |
| ENERGY_DRINK    | 0.7          |
| BEER            | -0.1         |
| LIQUOR          | -0.2         |

---


## Przykłady użycia API

### Dodanie wody
```http
POST http://localhost:8080/intake
Content-Type: application/json
```
```json
{
  "volume": 500,
  "type": "WATER"
}
```
---

### Dodanie kawy
```http
POST http://localhost:8080/intake
Content-Type: application/json
```
```json
{
  "volume": 300,
  "type": "COFFEE"
}

```
---
### Dodanie alkoholu
```http
POST http://localhost:8080/intake
Content-Type: application/json
```
```json
{
"volume": 200,
"type": "LIQUOR"
}
```
---
### Pobranie łącznej objętości wypitych płynów
```http
GET http://localhost:8080/intake/volume
```

Przykładowa odpowiedź:
```json
1000.0
```
---
### Pobranie bilansu nawodnienia
```http
GET http://localhost:8080/intake/hydration
```

Przykładowa odpowiedź:
```json
700.0
```
---
### Walidacja danych

Aplikacja posiada walidację danych wejściowych. Wpis zostanie odrzucony, jeżeli:
- objętość napoju jest mniejsza lub równa 0,
- typ napoju nie został podany,
- data spożycia znajduje się w przyszłości.

W przypadku błędnych danych aplikacja zgłasza błąd walidacji.


## Uruchomienie aplikacji

```bash
git clone https://github.com/man0fsky/hydration
```
```bash
cd hydration
```
```bash
./gradlew bootRun

```

Aplikacja będzie dostępna pod adresem:
```http
http://localhost:8080
```

---
### Testy


Projekt zawiera testy jednostkowe dla:

walidatora danych,

serwisu aplikacji,

kalkulatora nawodnienia.

Uruchomienie testów:

```bash
./gradlew test
```
## Autor

**man0fsky**  
Projekt jednoosobowy, wykonany w ramach zajęć akademickich.  
Kierunek: Informatyka  
Technologie: Java, Spring Boot, Gradle
