package entite;

import utils.MyRandom;

/**
 * Classe permettant de générer un Graphe aélatoire pour un nombre de sommets et
 * d'arêtes fixés.
 * 
 * @author Jean-Serge Monbailly
 * @author Thibaud Verbaere
 * 
 */
public class GrapheAleatoire extends AbstractGraphe {

	private int nSommets;
	private float p;

	// =========================================================================================
	// Constructeurs
	// =========================================

	/**
	 * Permet d'initialiser un graphe connaissant son nombre de sommets et
	 * d'arêtes.
	 * 
	 * @param nSommets
	 *            le nombre de sommets du graphe
	 * @param nAretes
	 *            le nombre d'arêtes du graphe.
	 */
	public GrapheAleatoire(int nSommets, float p) {
		super();
		this.nSommets = nSommets;
		this.p = p;

		this.generereGrapheAleatoire();
	}

	// =========================================================================================
	// Génération du graphe
	// =========================================

	/**
	 * Génère le graphe aléatoirement. Commence par générer les sommets du
	 * graphe puis génère aléatoirement le nombre d'arêtes voulu.
	 */
	private void generereGrapheAleatoire() {
		// Génération des sommets
		for (int i = 0; i < this.nSommets; i++) {
			this.sommets.add(new Sommet(i));
		}

		MyRandom rand = new MyRandom();
		Arete areteACreer;
		int poids;
		
		// On cherche toutes les combinaisons de sommets possible
		for (int i = 0 ; i < this.nSommets ; i++) {
			for (int j = i+1 ; j < this.nSommets ; j++) {
				if (rand.nextFloat() <= p) {
					poids = (rand.nextPositive() % Arete.MAX_VALUE) + 1;
					areteACreer = new Arete(this.getSommets().get(i), this.getSommets().get(j), poids);

					this.aretes.add(areteACreer);
				}
			}
		}
	}

}
