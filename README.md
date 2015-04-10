# aea-tp5

## Jean-Serge MONBAILLY
## Thibaud VERBAERE

Performances
============
Plus un algorithme est efficace (nombre de couleurs minimal) et plus cet algorithme est lent.
À l'inverse, plus celui-ci est rapide et moins ses résultats sont optimaux.

Ainsi l'algorithme naïf est rapide mais donnera assez rapidement de mauvais résultat (un nombre de couleurs
éloigné de l'optimale) ; et l'algorithme DSAT est le plus lent mais le plus efficace. L'algorithme de Welsh-Powel
est quand à lui un bon compromis, il offre un temps de calcul très proche de celui de l'algorithme naïf tout en 
gardant une précision semblable à celle de DSAT.

On constate assez vite les différences (à partir d'environ 50 sommets).

(des valeurs numériques sont disponible en commentaire de la classe Main du projet)


Algorithmes implémentés
=======================

naïf:
-----
L'algorithme naïf parcours les sommets du graphe (sans ordre préçis).
Pour chacun d'eux il établit la liste des couleurs de ses voisins et donne au sommet courant la plus petite
couleur possible non attribuée à l'un d'eux.

Welsh-Powel:
------------
Dans un premier temps, il faut ordonner les sommets suivant un ordre décroissant de leur degré.
On prend le premier sommet (donc le sommet de degré maximum) et on le colore avec la plus petite couleur possible.
Puis l'on fait un parcours des sommets encore non colorés et l'on colore chaque sommet pouvant être coloré
de la même couleur (le sommet ne doit pas être adjacent à un sommet de cette couleur).
Dès qu'on colore un sommet on le supprime de la liste de sommet.
On revient à la seconde étape tant que la liste contient des sommets.

DSATUR:
-------
Dans un premier temps, il faut ordonner les sommets suivant un ordre décroissant de leur degré.
On colore le premier sommet de la liste avec la couleur 1 (donc le sommet de degré maximum).
Puis il faut choisir le sommet non coloré ayant un DSAT maximum et on le colore en la plus petite couleur possible.
Pour rappel, le DSAT d'un sommet et le nombre de couleurs différentes utilisées dans le voisinage de ce sommet.
Si l'on croise deux sommets ayant le même DSAT alors on prend celui qui a le degré maximum.
Une fois coloré on retire le sommet de la liste et on recommence à la troisième étape. On arrête une fois la liste
des sommets vide.
