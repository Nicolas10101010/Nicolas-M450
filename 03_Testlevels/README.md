# A1 => Calculator

# A2:

## Aufgabe 2 – JUnit Zusammenfassung

Kurze Übersicht der wichtigsten Features von JUnit 5 (Jupiter), die ich am häufigsten brauche.

## Testmethoden

**`@Test`** – markiert eine Methode als Test.

```java
@Test
void addiert() {
    assertEquals(4, calc.add(2, 2));
}
```

**`@DisplayName`** – lesbarer Name im Testreport, z.B. `@DisplayName("Addition von zwei Zahlen")`.

**`@Disabled`** – Test wird übersprungen (z.B. während ein Feature noch in Arbeit ist).

### Assertions

Die wichtigsten Methoden aus `org.junit.jupiter.api.Assertions`:

| Assertion                            | Wann                                           |
| ------------------------------------ | ---------------------------------------------- |
| `assertEquals(expected, actual)`     | Werte vergleichen                              |
| `assertTrue` / `assertFalse`         | Bedingung prüfen                               |
| `assertNull` / `assertNotNull`       | Referenz prüfen                                |
| `assertThrows(Ex.class, () -> ...)`  | erwartete Exception                            |
| `assertAll(...)`                     | mehrere Prüfungen, alle Fehler werden gemeldet |
| `assertTimeout(Duration, () -> ...)` | Laufzeit begrenzen                             |

### Referenz

Offizieller JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/

# A3

# Bank – wie die Software funktioniert

## Aufbau

- **Bank** verwaltet alle Konten in einer TreeMap und vergibt Nummern ab 1000 (`S-`, `Y-`, `P-`).
- **Account** ist die abstrakte Basisklasse mit Saldo und Buchungsliste, davon erben **SavingsAccount** (kein Minus) und **SalaryAccount** (Minus bis zur Kreditlimite), und von SavingsAccount nochmal **PromoYouthSavingsAccount** mit 1 % Bonus.
- Die Unterklassen prüfen nur ihre Regel und rufen dann `super` auf, gebucht wird immer in Account.

## Ablauf

- Beim Ein- oder Auszahlen sucht die Bank das Konto, die Unterklasse prüft, dann wird der Saldo geändert und eine **Booking** angehängt.
- `canTransact()` verhindert Buchungen vor der letzten, so bleibt die Liste sortiert und die Auszüge stimmen.

## Konventionen

- Beträge sind in **Millirappen** (1 Franken = 100'000).
- Das Datum ist eine Zahl in **Banktagen seit 1970** mit 30-Tage-Monaten.

## Besonderheiten

- `Bank.getBalance()` rechnet minus, weil das Guthaben der Kunden für die Bank eine Schuld ist.
- Die zwei **Comparatoren** sortieren die Konten auf- oder absteigend für `printTop5()` und `printBottom5()`.
- Aufgefallen ist mir, dass `createSalaryAccount(12000)` in Main null zurückgibt und die Felder `Account.booking` und `Bank.account` gar nicht gebraucht werden.
