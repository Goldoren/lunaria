# Lunaria — mod Fabric pour Minecraft 1.21.1

## Contenu
- **Minerai de pierre de lune** : généré dans l'Overworld entre Y -60 et Y 20 (pierre et deepslate). Nécessite une pioche en fer. Drop 1-2 pierres brutes (Fortune OK, Toucher de soie OK).
- **Pierre de lune brute** → fonte / haut fourneau → **Pierre de lune**
- **Bloc de pierre de lune** (9 pierres) et **Lampe lunaire** (lumière 15)
- **Pioche** et **Épée** en pierre de lune (niveau fer, plus rapides, très enchantables)
- **Bâton de Lune** (64 utilisations) : clic droit = vision nocturne + chute lente + saut amélioré.
  La nuit : durée doublée + régénération. Recharge : 20 s.
- Onglet créatif « Lunaria », traductions FR/EN.

## Recettes
- Bâton : `_M_ / MEM / _S_` (M = pierre de lune, E = perle de l'Ender, S = bâton)
- Lampe : `_M_ / MGM / _M_` (G = glowstone)
- Pioche : `MMM / _S_ / _S_` — Épée : `M / M / S`

## Compiler
Prérequis : **JDK 21** et Gradle 8.8+ (ou le wrapper d'un projet généré sur https://fabricmc.net/develop).
```
gradle wrapper --gradle-version 8.8   # une seule fois
./gradlew build                       # le .jar est dans build/libs/
./gradlew runClient                   # pour tester directement en jeu
```
Dépose le .jar dans `mods/` avec Fabric Loader + Fabric API (1.21.1).

## Ajouter du contenu
- Objets : `ModItems.java` + modèle JSON + texture + entrée de langue
- Blocs : `ModBlocks.java` + blockstate + modèle + loot table + tag `mineable/pickaxe`

## Utiliser dans un modpack CurseForge
1. Le modpack doit être en **Fabric 1.21.1** (+ Fabric API).
2. Récupère le .jar (celui **sans** `-sources`) : en local dans `build/libs/`, ou via l'onglet *Actions* de GitHub (artefact `lunaria-jar`).
3. App CurseForge → ton modpack → **⋮ → Open Folder** → dépose le .jar dans `mods/`.
4. Pour exporter/publier le modpack avec le mod à l'intérieur, vérifie les règles de CurseForge sur les mods non publiés (le plus propre : publier Lunaria comme projet CurseForge, puis l'ajouter au modpack depuis le catalogue).


## Mise à jour 1.1
- **Textures** redessinées (contours, ombrage) pour tous les objets et blocs.
- **Nouveaux objets** : poussière lunaire, essence lunaire, fil lunaire, hache / pelle / houe en pierre de lune,
  Lame spectrale, Amulette lunaire (vision nocturne dans la barre d'accès rapide), Pomme lunaire,
  bloc de poussière lunaire.
- **Bâton de Lune** : barre d'énergie lunaire toujours visible (64 points, 8 par utilisation),
  recharge automatique dans l'inventaire (3x plus vite la nuit), ne casse plus.
- **Monstres** : Spectre lunaire (drops : poussière, essence) et Araignée lunaire (drops : fil, essence), avec oeufs d'apparition.
- **Structures** : Sanctuaire lunaire (garde par des Spectres) et Obélisque lunaire (garde par des Araignées),
  avec coffres de butin. Biomes : forêts, taïgas, collines, plaines, désert, savane, prairies.
- Commandes de test : `/locate structure lunaria:moon_shrine` et `/locate structure lunaria:moon_obelisk`.

## Recettes ajoutées
- Pomme lunaire : pomme + 4 poussières lunaires (sans forme)
- Lame spectrale : épée en pierre de lune + 2 essences + 2 poussières (sans forme)
- Amulette lunaire : `T_T / _E_ / TMT` (T = fil lunaire, E = essence, M = pierre de lune)
- Bloc de poussière : 4 poussières en carré 2x2
- Hache `MM / MS / _S`, pelle `M / S / S`, houe `MM / _S / _S`
