package algo;

import java.util.LinkedList;
import java.util.List;

import entite.AbstractGraphe;
import entite.Sommet;

public class Naif extends AbstractColoration{
	
	public Naif(AbstractGraphe g){
		super(g);
	}
	
	public void execute(){
		// Initialisation des variables
		List<Integer> couleurChoisie;
		int j = 0;
		int size = this.liste_sommets.size();

		// On parcours tout les sommets du graphe
		for(int i = 0 ; i < size ; i++){
			couleurChoisie = new LinkedList<Integer>();
			// On cherche les couleurs de ses voisins 
			for(Sommet s : this.liste_sommets.get(i).getVoisins()){
				if(!affectation_couleurs.containsKey(s))
					continue;
				if(couleurChoisie.contains(affectation_couleurs.get(s)))
					continue;
				
				couleurChoisie.add(affectation_couleurs.get(s));
			}
			
			// On attribue au sommet courant la plus petite couleur non trouvée chez ses voisins
			while(couleurChoisie.contains(++j));

			affectation_couleurs.put(this.liste_sommets.get(i), j);
		}
		
		for(Integer i : affectation_couleurs.values())
			if(i > this.nb_couleurs)
				this.nb_couleurs = i;
	}
}
