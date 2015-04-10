package algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entite.AbstractGraphe;
import entite.Sommet;

public abstract class AbstractColoration {

	protected AbstractGraphe g;
	protected int nb_couleurs;
	protected Map<Sommet, Integer> affectation_couleurs;
	protected List<Sommet> liste_sommets;
	
	public AbstractColoration(AbstractGraphe g){
		this.g = g;
		this.nb_couleurs = 1;
		this.liste_sommets = this.g.getSommets();
		this.affectation_couleurs = new HashMap<Sommet, Integer>();
	}
	
	public abstract void execute();
	
	public int getNbCouleurs(){
		return this.nb_couleurs;
	}
	
	public Map<Sommet, Integer> getColoration(){
		return this.affectation_couleurs;
	}
}
