package main;

import algo.AbstractColoration;
import algo.DSatur;
import algo.Naif;
import algo.WelshPowel;
import entite.AbstractGraphe;
import entite.GrapheAleatoire;

public class Main {
	
	/*
	 * Exécutions :
	 * 		Graphe(N=50,E=368) :
	 * 			- Naif : 		10 couleurs pour 2ms
	 * 			- Welsh-Powel :	 8 couleurs pour 4ms
	 * 			- DSatur	  :  7 couleurs pour 13ms
	 * 		Graphe(N=50,E=611) :
	 * 			- Naif : 		13 couleurs pour 1ms
	 * 			- Welsh-Powel :	11 couleurs pour 2ms
	 * 			- DSatur	  : 11 couleurs pour 11ms
	 * 		Graphe(N=100,E=1452) :
	 * 			- Naif : 		14 couleurs pour 2ms
	 * 			- Welsh-Powel :	13 couleurs pour 5ms
	 * 			- DSatur	  : 12 couleurs pour 20ms
	 * 		Graphe(N=100,E=1452) :
	 * 			- Naif : 		21 couleurs pour 5ms
	 * 			- Welsh-Powel :	20 couleurs pour 6ms
	 * 			- DSatur	  : 19 couleurs pour 33ms
	 * 		Graphe(N=200,E=5884) :
	 * 			- Naif : 		22 couleurs pour 8ms
	 * 			- Welsh-Powel :	21 couleurs pour 8ms
	 * 			- DSatur	  : 19 couleurs pour 77ms
	 * 		Graphe(N=200,E=9980) :
	 * 			- Naif : 		37 couleurs pour 10ms
	 * 			- Welsh-Powel :	34 couleurs pour 15ms
	 * 			- DSatur	  : 32 couleurs pour 99ms
	 * 		Graphe(N=1000,E=250220) :
	 * 			- Naif : 		126 couleurs pour 52ms
	 * 			- Welsh-Powel :	123 couleurs pour 141ms
	 * 			- DSatur	  : 114 couleurs pour 7032ms
	 * 		Graphe(N=1000,E=149196) :
	 * 			- Naif : 		77 couleurs pour 32ms
	 * 			- Welsh-Powel :	73 couleurs pour 64ms
	 * 			- DSatur	  : 68 couleurs pour 4532ms
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long deb, fin;
		int nb_couleurs;
		AbstractColoration coloration;

		deb = System.currentTimeMillis();
		AbstractGraphe g = new GrapheAleatoire(2000, (float) 0.55);
		fin = System.currentTimeMillis() - deb;

		System.out.println("La création du graphe a pris " + fin + " ms.");
		System.out.println(g);

		// Algorithme naïf
		coloration = new Naif(g);

		deb = System.currentTimeMillis();
		coloration.execute();
		nb_couleurs = coloration.getNbCouleurs();
		fin = System.currentTimeMillis() - deb;

		System.out.println("Le calcul naïf de la coloration a pris " + fin
				+ " ms.");

		System.out.println("Coloration du graphe en " + nb_couleurs
				+ " couleurs.");

		System.out.println("Coloration : " + coloration.getColoration());
		
		// Algorithme de WelshPowel
		coloration = new WelshPowel(g);

		deb = System.currentTimeMillis();
		coloration.execute();
		nb_couleurs = coloration.getNbCouleurs();
		fin = System.currentTimeMillis() - deb;

		System.out.println("Le calcul de la coloration avec l'algorithme de WelshPowel a pris " + fin
				+ " ms.");

		System.out.println("Coloration du graphe en " + nb_couleurs
				+ " couleurs.");
		System.out.println("Coloration : " + coloration.getColoration());
		
		// Algorithme DSatur
		coloration = new DSatur(g);

		deb = System.currentTimeMillis();
		coloration.execute();
		nb_couleurs = coloration.getNbCouleurs();
		fin = System.currentTimeMillis() - deb;

		System.out.println("Le calcul de la coloration avec l'algorithme DSatur a pris " + fin
				+ " ms.");

		System.out.println("Coloration du graphe en " + nb_couleurs
				+ " couleurs.");
		System.out.println("Coloration : " + coloration.getColoration());
	}

}
