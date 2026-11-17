# Smooth Prismarine (Fabric, Minecraft 26.3)

Fügt zwei Blöcke hinzu:

- **Smooth Prismarine** (Glatter Prismarin)
- **Smooth Dark Prismarine** (Glatter dunkler Prismarin)

## Herstellung

| Ergebnis | Ofen | Steinschneider |
|---|---|---|
| Smooth Prismarine | Prismarine | Prismarine oder Prismarine Bricks |
| Smooth Dark Prismarine | Dark Prismarine | Dark Prismarine |

## Bauen

Voraussetzungen: **JDK 25**, Gradle (Version passend zu Loom 1.17, 9.x).

```
gradle wrapper      # einmalig, erzeugt gradlew
./gradlew build     # Jar liegt danach in build/libs/
./gradlew runClient # Spiel zum Testen starten
```

Die fertige Jar (ohne `-sources`) in den `mods`-Ordner legen, zusammen mit Fabric API 0.161.0+26.3.

## Anpassen

Versionen stehen in `gradle.properties`. Rezepte liegen in `src/main/resources/data/smoothprismarine/recipe/`.
Die Texturen sind einfache Platzhalter und lassen sich in `assets/smoothprismarine/textures/block/` ersetzen.
