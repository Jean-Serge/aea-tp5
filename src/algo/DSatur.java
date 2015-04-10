package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.DegreSommetComparator;
import entite.AbstractGraphe;
import entite.Sommet;

/**
 * Classe modélisant la coloration selon l'algorithme DSatur.
 * @author Thibaud VERBAERE
 *
 */
public class DSatur extends AbstractColoration {
		
	/**
	 * Créé une nouvelle instance pour une colorisation par DSatur d'un graphe.
	 * @param graphe le graphe à colorer.
	 */
	public DSatur(AbstractGraphe g) {
		super(g);
	}
	
	/**
	 * Execute l'algorithme de DSatur sur le graphe.
	 * @return le nombre de couleur utilisé durant l'algorithme
	 */
	public void execute() {
		List<Sommet> sommets = new ArrayList<Sommet>(this.liste_sommets);
		// on tri la liste des sommets
		Collections.sort(sommets,new DegreSommetComparator());
		
		// On colore le premier sommet avec 1 :
		this.affectation_couleurs.put(sommets.remove(0), this.nb_couleurs);
		
		// Tant qu'on a pas coloré tout les sommets on execute la boucle
		Sommet selectionne;
		int dsat_max;
		int i;
		boolean pas_colore;
		int res;
		
		
		while (sommets.size() != 0) {
			selectionne = sommets.get(0);
			dsat_max = this.DSAT(sommets.get(0));
			pas_colore = true;
			res = 0;
			
			// Choisir un sommet avec DSAT max (si = on prend selon le degré)
			for (Sommet s : sommets) {
				res = this.DSAT(s);
				if (res > dsat_max) {
					dsat_max = res;
					selectionne = s;
				}
			}

			// On cherche la plus petite couleur possible pour le sommet selectionne
			i = 1;
			while (pas_colore && i <= this.nb_couleurs) {
				if (!this.aUnVoisinColoreAvec(selectionne, i)) {

					this.affectation_couleurs.put(selectionne, i);
					sommets.remove(selectionne);
					pas_colore = false;
				}
				i++;
			}
			
			// On colore le sommet
			if (pas_colore) {
				
				this.nb_couleurs++;
				this.affectation_couleurs.put(selectionne, this.nb_couleurs);
				sommets.remove(selectionne);
			}
			else {
				pas_colore = true;
			}
		}		
	}
	
	
	/**
	 * Retourne le nombre de voisins colorés différemment.
	 * @return dsat, soit le nombre de voisins colorés.
	 */
	public int DSAT(Sommet sommet) {
		Set<Integer> couleurs = new HashSet<Integer>();
		for (Sommet s : sommet.getVoisins()) {
			couleurs.add(this.affectation_couleurs.get(s));
		}
		
		return couleurs.size();
	}
	
	/**
	 * Teste si le sommet a un voisin coloré avec une couleur passée en paramètre.
	 * @param couleurCode le code de la couleur
	 * @return True|False
	 */
	public boolean aUnVoisinColoreAvec(Sommet sommet, int couleurCode) {
		for (Sommet s : sommet.getVoisins()) {
			// Des qu'on trouve la couleur on renvoie 'true'.
			if (this.affectation_couleurs.containsKey(s) && this.affectation_couleurs.get(s) == couleurCode)
				return true;
		}
		return false;
	}
}