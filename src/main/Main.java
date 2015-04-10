package main;

import algo.AbstractColoration;
import algo.DSatur;
import algo.Naif;
import algo.WelshPowel;
import entite.AbstractGraphe;
import entite.GrapheAleatoire;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long deb, fin;
		int nb_couleurs;
		AbstractColoration coloration;

		deb = System.currentTimeMillis();
		AbstractGraphe g = new GrapheAleatoire(10, (float) 0.3);
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
