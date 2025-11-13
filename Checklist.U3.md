# Übung 3
Erstellen Sie die Simulationen für den Beleg.

Weitere Informationen stehen im Anforderungsdokument unter der Überschrift Simulation.

## Abgabeanforderungen
Die Abgabe hat als zip-Datei zu erfolgen, die ein lauffähiges IntelliJ-IDEA-Projekt enthält. Dafür kann der Projektordner direkt in das zip eingepackt werden. Sie sollte die befüllte Checkliste im root des Projektes (neben der iml-Datei) enthalten in der der erreichte Stand bezüglich des Bewertungsschemas vermerkt ist.

Änderungen an der Checkliste sind grundsätzlich nicht zulässig. Davon ausgenommen ist das Befüllen der Checkboxen und ergänzende Anmerkungen die _kursiv gesetzt_ sind.

## Quellen
Zulässige Quellen sind suchmaschinen-indizierte Internetseiten. Werden mehr als drei zusammenhängende Anweisungen übernommen ist die Quelle in den Kommentaren anzugeben. Ausgeschlossen sind Quellen, die auch als Beleg oder Übungsaufgabe abgegeben werden oder wurden. Zulässig sind außerdem die über moodle bereitgestellten Materialien, diese können für die Übungsaufgaben und den Beleg ohne Quellenangabe verwendet werden.
Flüchtige Quellen, wie Sprachmodelle, sind per screen shot zu dokumentieren.

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
- [ ] Trennung zwischen GL und Simulationslogik
- [ ] kritische Bereiche/atomare Operationen verwendet
- [ ] Simulation 1

### 1 Simulation 2
- [ ] Simulation 2

### 2 Testbarkeit
- [ ] Trennung zwischen deterministischer und nicht-deterministischer Funktionalität in den Simulationen
- [ ] mindestens je ein Test für alle in der Simulation verwendeten Methoden die auf die Geschäftslogik zugreifen
- [ ] alle Tests sind deterministisch

### 3 Simulation 3
- [ ] Simulation 3
