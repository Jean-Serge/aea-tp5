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
	private int nAretes;

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
	public GrapheAleatoire(int nSommets, int nAretes) {
		super();
		this.nSommets = nSommets;
		this.nAretes = nAretes;

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
		int cptAretesCrees = 0;
		Arete areteACreer = null;
		int debut, fin, poids;
		boolean egal;

		while (cptAretesCrees < this.nAretes) {
			debut = rand.nextPositive() % this.nSommets;
			fin = rand.nextPositive() % this.nSommets;
			poids = rand.nextPositive() % Arete.MAX_VALUE ;
			// Pas d'arête d'un sommet vers lui-même
			if (debut == fin)
				continue;

			areteACreer = new Arete(this.sommets.get(debut),
					this.sommets.get(fin), poids);
			// On vérifie que l'arête en question n'existe pas déjà
			egal = false;
			for (Arete a : this.aretes) {
				if (areteACreer.equals(a)){
					egal = true;
					break;
				}
			}

			if (egal)
				continue;

			// Si tout se passe bien on ajoute cet Arête
			this.aretes.add(areteACreer);
			cptAretesCrees++;
		}

	}

}
