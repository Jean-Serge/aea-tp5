package algo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
		this.liste_sommets = graphe.getSommets();
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
		this.affectation_couleur.remove(this.liste_sommets.get(0));
		this.affectation_couleur.put(this.liste_sommets.get(0), this.nb_couleur);
		
		// Tant qu'on a trouve un DSAT différent de 0 on fait un tour de boucle
		
		
		
		for (Sommet s : this.liste_sommets) {
			int dsat_max = 0;
			Sommet selectionne = null;
			int res = this.DSAT(s);
			if (res > dsat_max) {
				dsat_max = res;
				selectionne = s;
			}
		}
		
		
		//TODO :
		// Choisir un sommet avec DSAT max (si = on prend selon le degré)
		// On colore le sommet avec la plus petite couleur possible
		
		
		
		return this.nb_couleur;
	}
	
	
	/**
	 * Retourne le nombre de voisins colorés.
	 * @return dsat, soit le nombre de voisins colorés.
	 */
	public int DSAT(Sommet sommet) {
		int dsat = 0;
		for (Sommet s : sommet.getVoisins()) {
			// Pour tout sommet voisin on regarde la couleur, si c'est 0 alors on incrémente.
			if (this.affectation_couleur.containsKey(s) && this.affectation_couleur.get(s) == 0)
				dsat++;
		}
		
		return dsat;
	}
	
	
	/**
	 * Retourne les affectations de couleurs.
	 * @return
	 */
	public HashMap<Sommet,Integer> getAffectations() {
		return this.affectation_couleur;
	}
	
}