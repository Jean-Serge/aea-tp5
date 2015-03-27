package entite;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un Graphe basique.
 * Cette classe sera étendue par différents type de Graphe à générer.
 * 
 * @author Jean-Serge Monbailly
 *
 */
public abstract class AbstractGraphe {

	protected List<Sommet> sommets;
	protected List<Arete> aretes;

	
	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================

	/**
	 * Instancie un nouveau Graphe.
	 */
	public AbstractGraphe(){
		this.sommets = new ArrayList<Sommet>();
		this.aretes = new ArrayList<Arete>();
	}
	
	
	// 	========================================================================================= 
	//	Accesseurs
	// 	=========================================
	
	/**
	 * Retour une version textuelle du graphe.
	 * Indique son nombre d'arètes et de sommets puis liste
	 * les différentes arètes du graphe et les affiche.
	 */
	public String toString(){
		String retour = "";
		
		retour += "Nombre d'arêtes : " + this.aretes.size() + "\n";
		retour += "Nombre de sommets : " + this.sommets.size() + "\n";
		
		retour += "\nListe des arêtes : \n";
		
		for(Arete a : this.aretes)
			retour += a + "\n";

		return retour;
	}
	
	public void ajoutSommet(Sommet s){
		this.sommets.add(s);
	}
	
	public List<Arete> getAretes(){
		return this.aretes;
	}
	
	public List<Sommet> getSommets(){
		return this.sommets;
	}
	
	public void ajoutArete(Arete a){
		this.aretes.add(a);
	}
	
	/**
	 * Calcule le poids total d'un graphe.
	 * i.e : la somme du poids de chacune des arètes du graphe
	 * 
	 * @return le poids total du graphe courant
	 */
	public int SommePoids() {
		int res = 0;
		
		for (Arete a : this.aretes)
			res += a.getValeur();
		
		return res;
			
	}
	
}
