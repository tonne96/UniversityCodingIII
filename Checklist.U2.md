# Übung 2
Erstellen Sie ein prototypisches Command Line Interface (CLI.CLI) für den Beleg mit 4 Befehlen (und ggf. ohne Modi): ein Befehl zum Einfügen einer (vordefinierten) Mediadatei, ein Befehl zum Anzeigen der Mediadateien, ein Befehl zum Ändern des Zugriffszählers einer Mediadatei und ein Befehl zum Entfernen einer Mediadatei.

Weitere Informationen stehen im Anforderungsdokument unter der Überschrift CLI.CLI. Der Persistenzmodus sowie die Ausführung als Client bzw. Server sind nicht Teil dieser Übung.

## Abgabeanforderungen
Die Abgabe hat als zip-Datei zu erfolgen, die ein lauffähiges IntelliJ-IDEA-Projekt enthält. Dafür kann der Projektordner direkt in das zip eingepackt werden. Sie sollte die befüllte Checkliste im root des Projektes (neben der iml-Datei) enthalten in der der erreichte Stand bezüglich des Bewertungsschemas vermerkt ist.

Änderungen an der Checkliste sind grundsätzlich nicht zulässig. Davon ausgenommen ist das Befüllen der Checkboxen und ergänzende Anmerkungen die _kursiv gesetzt_ sind.

## Quellen
Zulässige Quellen sind suchmaschinen-indizierte Internetseiten und LLMs. Werden mehr als drei zusammenhängende Anweisungen übernommen ist die Quelle in den Kommentaren anzugeben. Ausgeschlossen sind Quellen, die auch als Beleg oder Übungsaufgabe abgegeben werden oder wurden. Zulässig sind außerdem die über moodle bereitgestellten Materialien, diese können für die Übungsaufgaben und den Beleg ohne Quellenangabe verwendet werden.
Flüchtige Quellen, wie LLMs, sind per screen shot zu dokumentieren.

## Bewertung
0 Punkte wenn die grundsätzlichen Anforderungen nicht erfüllt sind. 1 Punkt für die Erfüllung der Basisanforderung und darauf aufbauend je ein Punkt für die nummerierten Anforderungen.

### grundsätzliche Anforderungen
- [ ] Quellen angegeben
- [ ] Abgabe als zip-Archiv mit dem Projekt im root
- [ ] IntelliJ-Projekt (kein Gradle, Maven o.ä.)
- [ ] keine weiteren Bibliotheken außer JUnit5, Mockito und JavaFX (und deren Abhängigkeiten)
- [ ] keine Umlaute, Sonderzeichen, etc. in Datei- und Pfadnamen
- [ ] kompilierbar
- [ ] Trennung zwischen Test- und Produktiv-Code
- [ ] geforderte main-Methoden nur im default package des Moduls belegProg3, nicht in den Submodulen
- [ ] keine vorgetäuschte Funktionalität (inkl. leere Tests)
- [ ] ausführbar

### Basisanforderung
- [ ] Benutzeroberfläche und Geschäftslogik korrekt aufgeteilt (mindestens 2-Schichten-Architektur)
- [ ] CLI.CLI-Implementierung für CRUD für einen Typ
- [ ] Dokumentation des Befehlssatzes inkl. Beispiele, falls abweichend zu Anforderungsdokument

### 1 einfaches addMediaobjectEvent system
- [ ] addMediaobjectEvent-System für die Kommunikation vom CLI.CLI zur GL realisiert

### 2 Beobachtermuster
- [ ] ein Beobachter gemäß Anforderungen realisiert

### 3 erweitertes addMediaobjectEvent system
abhängig von 1
- [ ] addMediaobjectEvent-System für die Kommunikation von der GL zum CLI.CLI realisiert
