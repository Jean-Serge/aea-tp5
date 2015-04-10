# aea-tp5

## Jean-Serge MONBAILLY
## Thibaud VERBAERE




Algorithmes implémentés
=======================


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
Puis il faut choisir le sommet non coloré ayant un DSAT maximum.
Pour rappel, le DSAT d'un sommet et le nom