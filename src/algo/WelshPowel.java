package algo;

import java.util.ArrayList;
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
		this.liste_sommets = new ArrayList<Sommet>(graphe.getSommets());
				
	}
	
	/**
	 * Execute l'algorithme de Welsh-Powel sur le graphe.
	 * @return le nombre de couleur utilisé durant l'algorithme
	 */
	public int execute() {
		// Reinitialisation de la variable (en cas de réutilisation).
		this.affectation_couleur = new HashMap<Sommet,Integer>();
		this.nb_couleur = 0;
		// on tri la liste des sommets
		Collections.sort(this.liste_sommets,new DegreSommetComparator());

		// On prend les sommets dans l'ordre décroissant.
		while (!this.liste_sommets.isEmpty()) {
			Sommet s = this.liste_sommets.get(0);
			this.nb_couleur++;
			// On met la plus petite couleur
			this.affectation_couleur.put(s, this.nb_couleur);
			this.liste_sommets.remove(s);
				
			List<Sommet> copy = new ArrayList<Sommet>(this.liste_sommets);
			// On parcours les autres sommets pour attribuer la couleur ailleurs
			for (Sommet s2 : this.liste_sommets) {
				// On passe les sommets ayant déja été colorés
				if (!this.affectation_couleur.containsKey(s2)) {
					if (!this.aUnVoisinColoreAvec(s2,this.nb_couleur)) {
						// On peut mettre la couleur si on ne trouve pas de voisin avec cette couleur.
						this.affectation_couleur.put(s2, this.nb_couleur);
						copy.remove(s2);
					}
				}
			}
			this.liste_sommets = copy;
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
