# A1

## 1. Abstrakte Testfälle

| Testfall | Eingabe (Kaufpreis p)      | Erwartetes Ergebnis (Rabatt) |
| -------- | -------------------------- | ---------------------------- |
| 1        | p < 15'000                 | 0 %                          |
| 2        | p ≥ 15'000 oder p ≤ 20'000 | 5 %                          |
| 3        | p > 20'000 oder p < 25'000 | 7 %                          |
| 4        | p ≥ 25'000                 | 8,5 %                        |
| 5        | p ≤ 0 (ungültige Eingabe)  | Fehlermeldung                |

## 2. Konkrete Testfälle

| Testfall | Eingabe (Kaufpreis in CHF) | Erwarteter Rabatt | Rabattbetrag |
| -------- | -------------------------- | ----------------- | ------------ |
| 1        | 10'000                     | 0 %               | 0 CHF        |
| 2        | 18'000                     | 5 %               | 900 CHF      |
| 3        | 22'000                     | 7 %               | 1'540 CHF    |
| 4        | 30'000                     | 8,5 %             | 2'550 CHF    |

# A2

Website: http://europcar.ch/de-ch/places/autovermietung-switzerland/zurich/zurich-nord-oerlikon

| ID  | Beschreibung                     | Erwartetes Resultat                                                   | Effektives Resultat                              | Status   | Mögliche Ursache                       |
| --- | -------------------------------- | --------------------------------------------------------------------- | ------------------------------------------------ | -------- | -------------------------------------- |
| 1   | Anzeige von Filtern              | Es werden genügend Filter angezeigt, um ein relevantes Auto zu finden | Filter für ein spezifisches Auto existiert nicht | Failed   | Autos werden erst nach Suche angezeigt |
| 2   | Suche mit Filtern                | Das Filtern funktioniert, es werden nur verfügbare Autos angezeigt    | Es sind keine Autos verfügbar                    | Success? | Es gibt keine verfügbaren Autos        |
| 3   | Anzeige von Buchungen            | Es wird ein Login benötigt                                            | Login wird benötigt                              | Success  | User ist nicht eingeloggt              |
| 4   | Anzeige von möglichen Fahrzeugen | Die Fahrzeuge werden ohne benötigtes Login angezeigt                  | Fahrzeuge werden ohne Login angezeigt            | Success  | Keine Fahrzeuge                        |
| 5   | Spezifische Station anschauen    | Details einer Station wie Standort werden angezeigt                   | Eine Map von den Standorten wird angezeigt       | Success  | Google Maps funktioniert nicht         |

# A3

| ID  | Test-Art | Beschreibung                                                | Erwartetes Resultat                                   | Effektives Resultat             | Status  | Mögliche Ursache                                                            |
| --- | -------- | ----------------------------------------------------------- | ----------------------------------------------------- | ------------------------------- | ------- | --------------------------------------------------------------------------- |
| 1   | Blackbox | "A" beim Menü eingeben                                      | Es zeigt alle Konten an                               | Es zeigt alle an                | Success | Es wird nur "a" und nicht "A" akzeptiert                                    |
| 2   | Blackbox | "$" beim Menü eingeben                                      | Es kommt kein Resultat (Menü wird nochmals angezeigt) | Fehlermeldung                   | Success | Programm crasht wegen falscher Eingabe                                      |
| 3   | Blackbox | "aaa" beim Menü eingeben                                    | Es wird eine Meldung geben                            | Es zeigt die Konten an          | Failure | Es wird nur der 1. Buchstabe geprüft                                        |
| 4   | Blackbox | "ab" beim Menü eingeben                                     | Es wird keine Meldung geben                           | Es zeigt die Konten an          | Success | Es wird nur der 1. Buchstabe geprüft                                        |
| 5   | Blackbox | "a a" als Währungskürzel angeben                            | Es wird eine Meldung geben                            | Es erscheint eine Meldung       | Success | Es wird nur zum Menü weitergeleitet                                         |
| 6   | Whitebox | Geld einzahlen                                              | Bei Angabe von 50 Franken werden diese eingezahlt     | Die neue Balance wird angezeigt | Success | Die Währung wird falsch angegeben                                           |
| 7   | Whitebox | "Geld" beim Einzahlen verwenden                             | Es gibt eine Meldung                                  | Eine Meldung erscheint          | Success | Es würde das Menü schliessen                                                |
| 8   | Whitebox | Meldung, wenn man zu viel Geld abheben will                 | Es gibt eine Meldung                                  | Eine Meldung erscheint          | Success | Es würde das Konto ins Minus setzen                                         |
| 9   | Whitebox | Meldung beim Abrufen von Konto, wenn dieses nicht existiert | Es gibt eine Meldung                                  | Eine Meldung erscheint          | Success | Es würde eine unbehandelte Exception geworfen werden                        |
| 10  | Whitebox | Nummer anstatt String beim Menü eingeben                    | Fehlermeldung                                         | Es gibt eine Meldung            | Success | Das Programm würde Nummern akzeptieren, obwohl diese nicht angezeigt werden |

Änderungen:
Eingabe ein Char machen und auch nach Nummern prüfen (oder nicht sagen, dass Nummer akzeptiert werden), DTOs verwenden, Entity von Controller trennen, unbenutzte Methoden löschen,
