package algo;

import java.util.Collections;
import java.util.HashMap;
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
	
	private HashMap<Sommet,Integer> affectation_couleur;

	/**
	 * Créé une nouvelle instance pour une colorisation selon Welsh-Powel d'un graphe.
	 * @param graphe le graphe à colorer.
	 */
	public WelshPowel(Graphe graphe) {
		this.nb_couleur = 0;
		this.liste_sommets = graphe.getSommets();
		this.affectation_couleur = new HashMap<Sommet,Integer>();
		
		// Initialisation des affectations des couleurs
		for (Sommet s : this.liste_sommets)
			this.affectation_couleur.put(s, 0);
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
			if (this.affectation_couleur.get(s) == 0) {
				this.nb_couleur++;
				// On met la plus petite couleur
				this.affectation_couleur.remove(s);
				this.affectation_couleur.put(s, this.nb_couleur);
				
				// On parcours les autres sommets pour attribuer la couleur ailleurs
				for (Sommet s2 : this.liste_sommets) {
					// On passe les sommets ayant déja été colorés
					if (this.affectation_couleur.get(s2) == 0) {
						if (!this.aUnVoisinColoreAvec(s2,this.nb_couleur)) {
							// On peut mettre la couleur si on ne trouve pas de voisin avec cette couleur.
							this.affectation_couleur.remove(s2);
							this.affectation_couleur.put(s2, this.nb_couleur);
						}
					}
				}
			}
		}
		
		return this.nb_couleur;
	}
	

	/**
	 * Teste si le sommet a un voisin coloré avec une couleur passée en paramètre.
	 * @param couleurCode le code de la couleur
	 * @return True|False
	 */
	public boolean aUnVoisinColoreAvec(Sommet sommet, int couleurCode) {
		for (Sommet s : sommet.getVoisins()) {
			// Des qu'on trouve la couleur on renvoie 'true'.
			if (this.affectation_couleur.get(s) == couleurCode)
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
