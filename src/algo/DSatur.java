package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.DegreSommetComparator;
import entite.Graphe;
import entite.Sommet;

/**
 * Classe modélisant la coloration selon l'algorithme DSatur.
 * @author Thibaud VERBAERE
 *
 */
public class DSatur {
		
	private int nb_couleur;
	
	private List<Sommet> liste_sommets;
	
	private HashMap<Sommet,Integer> affectation_couleur;

	/**
	 * Créé une nouvelle instance pour une colorisation par DSatur d'un graphe.
	 * @param graphe le graphe à colorer.
	 */
	public DSatur(Graphe graphe) {
		this.nb_couleur = 0;
		this.liste_sommets = new ArrayList<Sommet>(graphe.getSommets());
		this.affectation_couleur = new HashMap<Sommet,Integer>();
		
	}
	
	/**
	 * Execute l'algorithme de DSatur sur le graphe.
	 * @return le nombre de couleur utilisé durant l'algorithme
	 */
	public int execute() {
		// Reinitialisation de la variable (en cas de réutilisation).
		this.nb_couleur = 1;
		// on tri la liste des sommets
		Collections.sort(this.liste_sommets,new DegreSommetComparator());

		// On colore le premier sommet avec 1 :
		this.affectation_couleur.put(this.liste_sommets.get(0), this.nb_couleur);
		this.liste_sommets.remove(0);
		
		// Tant qu'on a pas coloré tout les sommets on execute la boucle
		Sommet selectionne;
		int dsat_max;
		int i;
		boolean pas_colore;
		int res;
		
		
		while (this.liste_sommets.size() != 0) {
			selectionne = this.liste_sommets.get(0);
			dsat_max = this.DSAT(this.liste_sommets.get(0));
			pas_colore = true;
			res = 0;
			
			// Choisir un sommet avec DSAT max (si = on prend selon le degré)
			for (Sommet s : this.liste_sommets) {
				res = this.DSAT(s);
				if (res > dsat_max) {
					dsat_max = res;
					selectionne = s;
				}
			}

			// On cherche la plus petite couleur possible pour le sommet selectionne
			i = 1;
			while (pas_colore && i <= this.nb_couleur) {
				if (!this.aUnVoisinColoreAvec(selectionne, i)) {

					this.affectation_couleur.put(selectionne, i);
					this.liste_sommets.remove(selectionne);
					pas_colore = false;
				}
				i++;
			}
			
			// On colore le sommet
			if (pas_colore) {
				
				this.nb_couleur++;
				this.affectation_couleur.put(selectionne, this.nb_couleur);
				this.liste_sommets.remove(selectionne);
			}
			else {
				pas_colore = true;
			}
		}		
		
		return this.nb_couleur;
	}
	
	
	/**
	 * Retourne le nombre de voisins colorés.
	 * @return dsat, soit le nombre de voisins colorés.
	 */
	public int DSAT(Sommet sommet) {
		Set<Integer> couleurs = new HashSet<Integer>();
		for (Sommet s : sommet.getVoisins()) {
			couleurs.add(this.affectation_couleur.get(s));
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
			if (this.affectation_couleur.containsKey(s) && this.affectation_couleur.get(s) == couleurCode)
				return true;
		}
		return false;
	}
	
	
	/**
	 * Retourne les affectations de couleurs.
	 * @return
	 */
	public HashMap<Sommet,Integer> getAffectations() {
		return this.affectation_couleur;
	}
	
}