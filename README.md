# # Générateur de mot de passe

Petit programme en Java qui génère des mots de passe aléatoires. On choisit la longueur et si on veut des majuscules, des chiffres et des symboles, et il génère le mot de passe direct dans le terminal.

## Pourquoi ce projet

Je voulais m'entraîner sur les boucles, les `StringBuilder` et la génération aléatoire en Java, donc j'ai fait un petit outil utile plutôt qu'un exercice random.

## Comment ça marche

Le programme construit d'abord la liste des caractères autorisés (les minuscules sont toujours là, le reste est optionnel selon ce que l'utilisateur choisit). Ensuite il pioche des caractères au hasard dans cette liste, un par un, jusqu'à atteindre la longueur demandée.

Pour le tirage aléatoire, j'utilise `SecureRandom` et pas `Random`. `Random` est prévisible si on connaît sa graine de départ, ce qui n'est pas top pour un mot de passe. `SecureRandom` est fait pour ce genre de cas.

## Lancer le programme

Compiler :
```
javac GenerateurMotDePasse.java
```

Exécuter :
```
java GenerateurMotDePasse
```

## Utilisation

Le programme pose 4 questions :

1. La longueur du mot de passe voulue
2. Si on veut des majuscules (o/n)
3. Si on veut des chiffres (o/n)
4. Si on veut des symboles comme `!@#$%` (o/n)

Exemple :
```
--- GENERATEUR DE MOT DE PASSE ---
Longueur du mot de passe souhaitee : 12
Inclure des majuscules ? (o/n) : o
Inclure des chiffres ? (o/n) : o
Inclure des symboles (!@#...) ? (o/n) : o

Mot de passe genere : xT8!kR2@wZ#9
```