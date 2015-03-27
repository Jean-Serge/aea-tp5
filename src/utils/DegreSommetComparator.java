package utils;

import java.util.Comparator;

import entite.Sommet;

/**
 * Classe permettant le tri (sort) des sommets par rapport à leur degré dans une
 * liste JAVA.
 * 
 * ATTENTION, Les valeurs de -1 et 1 ont été inversées afin de trier les sommets dans un ordre décroissant !!!
 * 
 * @author verbaere
 * 
 */
public class DegreSommetComparator implements Comparator<Sommet> {

	/**
	 * Un sommet est plus grand qu'un autre si son degré est plus élevé.
	 * Retourne un entier utile à la comparaison de deux sommets : - (1) si le
	 * second sommet passé en paramètre est plus grand que le premier. - (-1)
	 * si c'est le premier sommet qui est le plus grand. - (0) si les deux
	 * sommets ont un poids identique.
	 * 
	 * @param s1
	 *            le premier sommet à comparer
	 * @param s2
	 *            le second sommet à comparer
	 * 
	 */
	public int compare(Sommet s1, Sommet s2) {
		if (s1.getDegre() > s2.getDegre())
			// Cas 2 : s1 a un degré > à s2 (return -1)
			return -1;
		else if (s1.getDegre() < s2.getDegre())
			// Dernier Cas
			return 1;

		return 0;
	}

}
