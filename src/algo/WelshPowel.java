package algo;

import java.util.Collections;
import java.util.List;

import utils.DegreSommetComparator;

import entite.Graphe;
import entite.Sommet;

/**
 * Classe modélisant la coloration selon l'algorithme de Welsh-Powel.
 * @author verbaere
 *
 */
public class WelshPowel {
	
	private Graphe graphe;
	
	private int nb_couleur;

	/**
	 * Créé une nouvelle instance pour une colorisation selon Welsh-Powel d'un graphe.
	 * @param graphe le graphe à colorer.
	 */
	public WelshPowel(Graphe graphe) {
		this.graphe = graphe;
		this.nb_couleur = 0;
	}
	
	/**
	 * Execute l'algorithme de Welsh-Powel sur le graphe.
	 * @return le nombre de couleur utilisé durant l'algorithme
	 */
	public int execute() {
		List<Sommet> sommets = graphe.getSommets();
		// on tri la liste des sommets
		Collections.sort(sommets,new DegreSommetComparator());

		for (Sommet s: sommets) {
			
			if (s.getCouleur() == 0) {
				
				for (Sommet s1 : sommets) {
					if (!s1.getVoisins().contains(s))
						s1.colorerSommet(this.nb_couleur+1);
				}
				
			}
		}
			
		return this.nb_couleur;
	}
	
}
