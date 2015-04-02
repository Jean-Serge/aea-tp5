package algo;

import java.util.Collections;
import java.util.List;

import utils.DegreSommetComparator;
import entite.Graphe;
import entite.Sommet;

/**
 * Classe modélisant la coloration selon l'algorithme de Welsh-Powel.
 * @author Thibaud VERBAERE
 *
 */
public class WelshPowel {
		
	private int nb_couleur;
	
	private List<Sommet> liste_sommets;

	/**
	 * Créé une nouvelle instance pour une colorisation selon Welsh-Powel d'un graphe.
	 * @param graphe le graphe à colorer.
	 */
	public WelshPowel(Graphe graphe) {
		this.nb_couleur = 0;
		this.liste_sommets = graphe.getSommets();
	}
	
	/**
	 * Execute l'algorithme de Welsh-Powel sur le graphe.
	 * @return le nombre de couleur utilisé durant l'algorithme
	 */
	public int execute() {
		// Reinitialisation de la variable (en cas de réutilisation).
		this.nb_couleur = 0;
		// on tri la liste des sommets
		Collections.sort(this.liste_sommets,new DegreSommetComparator());

		// On prend les sommets dans l'ordre décroissant.
		for (Sommet s: this.liste_sommets) {
			// Si une couleur n'est pas attribuée (numéro couleur = 0), on continue si on passe au suivant.
			if (s.getCouleur() == 0) {
				this.nb_couleur++;
				// On met la plus petite couleur
				s.colorerSommet(this.nb_couleur);
				// On parcours les autres sommets pour attribuer la couleur ailleurs
				for (Sommet s2 : this.liste_sommets) {
					// On passe les sommets ayant déja été colorés
					if (s2.getCouleur() == 0) {
						if (!s2.aUnVoisinColoreAvec(this.nb_couleur)) {
							// On peut mettre la couleur si on ne trouve pas de voisin avec cette couleur.
							s2.colorerSommet(this.nb_couleur);
						}
					}
				}
			}
		}
		
		return this.nb_couleur;
	}
	
}
