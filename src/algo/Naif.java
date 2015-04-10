package algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import entite.AbstractGraphe;
import entite.Sommet;

public class Naif extends AbstractColoration{

	private AbstractGraphe g;
	
	private HashMap<Sommet, Integer> affectation_couleur;
	
	public Naif(AbstractGraphe g){
		super(g);
		this.affectation_couleur = new HashMap<Sommet, Integer>();
	}
	
	public void execute(){
		// Initialisation des variables
		List<Integer> couleurChoisie = new LinkedList<Integer>();
		int nb_couleurs = 0;
		int j = 0;
		int size = this.liste_sommets.size();

		// On parcours tout les sommets du graphe
		for(int i = 0 ; i < size ; i++){
			// On cherche les couleurs de ses voisins 
			for(Sommet s : this.liste_sommets.get(i).getVoisins()){
				if(!affectation_couleur.containsKey(s))
					continue;
				if(couleurChoisie.contains(affectation_couleur.get(s)))
					continue;
				
				couleurChoisie.add(affectation_couleur.get(s));
			}
			
			// On attribue au sommet courant la plus petite couleur non trouvée chez ses voisins
			while(couleurChoisie.contains(j)){
				j++;
			}

			affectation_couleur.put(this.liste_sommets.get(i), j);
		}

		// On recherche le nombre de couleurs utilisé
		for(Integer i : affectation_couleur.values())
			if(i > nb_couleurs)
				nb_couleurs = i;
	}
}
