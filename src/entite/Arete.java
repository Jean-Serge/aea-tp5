package entite;

/**
 * Cette classe représente une arête du graphe. Une arête est représentée par
 * son sommet d'origine et celui d'arrivée.
 * 
 * @author Jean-Serge Monbailly
 * @author Thibaud Verbaere
 * 
 */
public class Arete {

	// Poids Maximal d'une Arète
	public static final int MAX_VALUE = 101;
	
	private Sommet origine;
	private Sommet arrivee;
	private int valeur;

	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	/**
	 * Créé une nouvelle arète de valeur 1.
	 * 
	 * @param origine le sommet d'origine de l'arete
	 * @param arrivee le sommet d'arrivee de l'arete
	 */
	public Arete(Sommet origine, Sommet arrivee){
		this(origine, arrivee, 1);
	}
	
	/**
	 * Créé une nouvelle arète de valeur indiquée.
	 * 
	 * @param origine le sommet d'origine de l'arete
	 * @param arrivee le sommet d'arrivee de l'arete
	 * @param valeur la valeur de l'arete
	 */
	public Arete(Sommet origine, Sommet arrivee, int valeur) {
		this.origine = origine;
		this.arrivee = arrivee;
		this.valeur = valeur;
	}

	// 	========================================================================================= 
	//	Fonctions utiles
	// 	=========================================
	
	/**
	 * Compare 2 Arete pour savoir si elles sont identique.
	 * i.e : si elles ont le même sommet d'origine et d'arrivée.
	 * 
	 * @param autreArete l'arête à comparer à l'Arête courante
	 * @return true si les 2 Arêtes sont égales
	 */
	public boolean equals(Arete autreArete) {
		boolean endroit = this.origine.equals(autreArete.getOrigine())
				&& this.arrivee.equals(autreArete.getArrivee());
		boolean envers = this.origine.equals(autreArete.getArrivee())
				&& this.arrivee.equals(autreArete.getOrigine());
		return endroit || envers;
	}

	// 	========================================================================================= 
	//	Accesseurs
	// 	=========================================
	
	public Sommet getOrigine() {
		return origine;
	}

	public Sommet getArrivee() {
		return arrivee;
	}

	public String toString(){
		String retour = "";
		retour += this.origine + "\t  ====>  \t" + this.arrivee + " \t" + this.valeur;
		return retour;
	}
	
	public int getValeur(){
		return this.valeur;
	}
}
