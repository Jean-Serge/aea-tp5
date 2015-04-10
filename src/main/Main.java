package main;

import algo.Naif;
import entite.AbstractGraphe;
import entite.GrapheAleatoire;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long deb, fin;

		deb = System.currentTimeMillis();
		AbstractGraphe g = new GrapheAleatoire(5, (float) 0.3);
		fin = System.currentTimeMillis() - deb;

		System.out.println("La création du graphe a pris " + fin + " ms.");
		System.out.println(g);

		deb = System.currentTimeMillis();
		int coloration = new Naif(g).execute();
		fin = System.currentTimeMillis() - deb;

		System.out.println("Le calcul naïf de la coloration a pris " + fin + " ms.");

		System.out.println("Coloration du graphe en " + coloration
				+ " couleurs.");
	}

}
