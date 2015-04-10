package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import utils.DegreSommetComparator;
import entite.AbstractGraphe;
import entite.Sommet;

/**
 * Classe modélisant la coloration selon l'algorithme de Welsh-Powel.
 * @author Thibaud VERBAERE
 *
 */
public class WelshPowel extends AbstractColoration {
		
	/**
	 * Créé une nouvelle instance pour une colorisation selon Welsh-Powel d'un graphe.
	 * @param g le graphe à colorer.
	 */
	public WelshPowel(AbstractGraphe g) {
		super(g);
	}
	
	/**
	 * Execute l'algorithme de Welsh-Powel sur le graphe.
	 * @return le nombre de couleur utilisé durant l'algorithme
	 */
	public void execute() {
		List<Sommet> sommets = new ArrayList<Sommet>(this.liste_sommets);
		// Reinitialisation de la variable (en cas de réutilisation).
		this.affectation_couleurs = new HashMap<Sommet,Integer>();
		this.nb_couleurs = 0;
		// on tri la liste des sommets
		Collections.sort(sommets,new DegreSommetComparator());

		// On prend les sommets dans l'ordre décroissant.
		while (!sommets.isEmpty()) {
			Sommet s = sommets.get(0);
			this.nb_couleurs++;
			// On met la plus petite couleur
			this.affectation_couleurs.put(s, this.nb_couleurs);
			sommets.remove(s);
				
			List<Sommet> copy = new ArrayList<Sommet>(sommets);
			// On parcours les autres sommets pour attribuer la couleur ailleurs
			for (Sommet s2 : sommets) {
				// On passe les sommets ayant déja été colorés
				if (!this.affectation_couleurs.containsKey(s2)) {
					if (!this.aUnVoisinColoreAvec(s2,this.nb_couleurs)) {
						// On peut mettre la couleur si on ne trouve pas de voisin avec cette couleur.
						this.affectation_couleurs.put(s2, this.nb_couleurs);
						copy.remove(s2);
					}
				}
			}
			sommets = copy;
		}
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
