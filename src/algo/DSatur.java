package algo;

import java.util.Collections;
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

	/**
	 * Créé une nouvelle instance pour une colorisation par DSatur d'un graphe.
	 * @param graphe le graphe à colorer.
	 */
	public DSatur(Graphe graphe) {
		this.nb_couleur = 0;
		this.liste_sommets = graphe.getSommets();
	}
	
	/**
	 * Execute l'algorithme de Welsh-Powel sur le graphe.
	 * @return le nombre de couleur utilisé durant l'algorithme
	 */
	public int execute() {
		// Reinitialisation de la variable (en cas de réutilisation).
		this.nb_couleur = 1;
		// on tri la liste des sommets
		Collections.sort(this.liste_sommets,new DegreSommetComparator());

		// On colore le premier sommet avec 1 :
		this.liste_sommets.get(0).colorerSommet(this.nb_couleur);
		
		//TODO :
		// Choisir un sommet avec DSAT max (si = on prend selon le degré)
		// On colore le sommet avec la plus petite couleur
		
		
		
		return this.nb_couleur;
	}
	
}