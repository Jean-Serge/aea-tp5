package entite;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un Sommet pour le graphe.
 * @author monbailly
 * @author verbaere
 *
 */
public class Sommet {

	private int id;
	
	private int couleur;
	
	private int degre;
	
	private List<Sommet> voisins;
	
	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	/**
	 * Instancie un nouveau sommet à partir d'un identifiant.
	 * @param id
	 */
	public Sommet(int id) {
		this.id = id;
		this.couleur = 0; // 0 : non coloré
		this.degre = 0; // de base un sommet n'est pas relié à un autre sommet.
		this.voisins = new ArrayList<Sommet>();
	}
		
	
	// 	========================================================================================= 
	//	Fonctions utiles
	// 	=========================================
	
	/**
	 * Cette fonction n'est pas vraiment surchargée car elle permet
	 * de vérifier s'il s'agit bien du bon sommet dans le bon graphe.
	 * @param autreSommet le sommet à comparer au sommet courant
	 * @return true s'il s'agit du même sommet.
	 */
	public boolean equals(Sommet autreSommet){
		return super.equals(autreSommet);
	}
	
	public String toString(){
		return "" + this.id;
	}
	
	/**
	 * Retourne la liste des sommets voisins.
	 * @return
	 */
	public List<Sommet> getVoisins() {
		return this.voisins;
	}
	
	/**
	 * Permet de colorer un sommet avec une couleur (modélisée sous forme d'entier).
	 * @param color l'indice de la couleur
	 */
	public void colorerSommet(int color) {
		this.couleur = color;
	}
	
	/**
	 * Incrémente le degré du sommet.
	 */
	public void incrementerDegre() {
		this.degre++;
	}
	
	/**
	 * Décrémente le degré du sommet.
	 */
	public void decrementerDegre() {
		this.degre--;
	}
	
	/**
	 * Ajoute au sommet un voisin passé en paramètre.
	 * @param s le sommet
	 */
	public void ajouterVoisin(Sommet s) {
		this.voisins.add(s);
	}
	
	/**
	 * Retourne le degré du sommet.
	 * @return le degré
	 */
	public int getDegre() {
		return this.degre;
	}
	
	

}
