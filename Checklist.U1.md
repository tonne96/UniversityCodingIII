# Übung 1
Erstellen Sie die Geschäftslogik des Belegs prototypisch und testen Sie exemplarisch. Für die Übung müssen nicht alle Anforderungen realisiert werden aber mindestens CRUD d.h. Einfügen, Auflisten, Ändern (AccessCount) und Entfernen für mindestens einen Typ von den im Vertrag vordefinierten Medien, z.B. AudioImpl.

Weitere Informationen stehen im Anforderungsdokument unter der Überschrift GL.

## Abgabeanforderungen
Die Abgabe hat als zip-Datei zu erfolgen, die ein lauffähiges IntelliJ-IDEA-Projekt enthält. Dafür kann der Projektordner direkt in das zip eingepackt werden. Sie sollte die befüllte Checkliste im root des Projektes (neben der iml-Datei) enthalten in der der erreichte Stand bezüglich des Bewertungsschemas vermerkt ist.

Änderungen an der Checkliste sind grundsätzlich nicht zulässig. Davon ausgenommen ist das Befüllen der Checkboxen und ergänzende Anmerkungen die _kursiv gesetzt_ sind.

## Quellen
Zulässige Quellen sind suchmaschinen-indizierte Internetseiten und LLMs. Werden mehr als drei zusammenhängende Anweisungen übernommen ist die Quelle in den Kommentaren anzugeben. Ausgeschlossen sind Quellen, die auch als Beleg oder Übungsaufgabe abgegeben werden oder wurden. Zulässig sind außerdem die über moodle bereitgestellten Materialien, diese können für die Übungsaufgaben und den Beleg ohne Quellenangabe verwendet werden.
Flüchtige Quellen, wie LLMs, sind per screen shot zu dokumentieren.

## Bewertung
0 Punkte wenn die grundsätzlichen Anforderungen nicht erfüllt sind. 1 Punkt für die Erfüllung der Basisanforderung und darauf aufbauend je ein Punkt für die nummerierten Anforderungen.

### grundsätzliche Anforderungen
- [X] Quellen angegeben
- [ ] Abgabe als zip-Archiv mit dem Projekt im root
- [X] IntelliJ-Projekt (kein Gradle, Maven o.ä.)
- [X] keine weiteren Bibliotheken außer JUnit5, Mockito und JavaFX (und deren Abhängigkeiten)
- [X] keine Umlaute, Sonderzeichen, etc. in Datei- und Pfadnamen
- [X] kompilierbar
- [X] Trennung zwischen Test- und Produktiv-Code
- [ ] geforderte main-Methoden nur im default package des Moduls belegProg3, nicht in den Submodulen
- [X] keine vorgetäuschte Funktionalität (inkl. leere Tests)
- [X] ausführbar

### Basisanforderung
- [X] CRUD für einen Typ
- [X] mindestens ein Test

### 1 Ausbau GL
- [ ] Einfügen der Mediadateien vollständig implementiert (siehe Anfoderungsdokument)
- [ ] Unterstützung von mindestens zwei Medientypen

### 2 Testabdeckung
abhängig von 1
- [ ] Einfügen der Mediadateien vollständig getestet (mindestens Pfadabdeckung)

### 3 Stellvertretertests
abhängig von 1
- [ ] mindestens zwei Tests mit Mockito

