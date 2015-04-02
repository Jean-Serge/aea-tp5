package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algo.WelshPowel;
import entite.Arete;
import entite.Graphe;
import entite.Sommet;

public class TestWelshPowel {
	
	WelshPowel wp;
	Graphe g = new Graphe();
	
	Sommet s0 = new Sommet(0);
	Sommet s1 = new Sommet(1);
	Sommet s2 = new Sommet(2);
	Sommet s3 = new Sommet(3);
	Sommet s4 = new Sommet(4);
	Sommet s5 = new Sommet(5);
	Sommet s6 = new Sommet(6);
	Sommet s7 = new Sommet(7);
	Sommet s8 = new Sommet(8);
	
	Arete a1 = new Arete(s0,s1);
	Arete a2 = new Arete(s0,s2);
	Arete a3 = new Arete(s1,s2);
	Arete a4 = new Arete(s2,s3);
	Arete a5 = new Arete(s1,s8);
	Arete a6 = new Arete(s3,s4);
	Arete a7 = new Arete(s4,s5);
	Arete a8 = new Arete(s4,s7);
	Arete a9 = new Arete(s5,s7);
	Arete a10 = new Arete(s5,s6);
	Arete a11 = new Arete(s6,s8);
	Arete a12 = new Arete(s7,s8);

	@Before
	public void setUp() {
		
		g.ajoutSommet(s0);
		g.ajoutSommet(s1);
		g.ajoutSommet(s2);
		g.ajoutSommet(s3);
		g.ajoutSommet(s4);
		g.ajoutSommet(s5);
		g.ajoutSommet(s6);
		g.ajoutSommet(s7);
		g.ajoutSommet(s8);
		
		g.ajoutArete(a1);
		g.ajoutArete(a2);
		g.ajoutArete(a3);
		g.ajoutArete(a4);
		g.ajoutArete(a5);
		g.ajoutArete(a6);
		g.ajoutArete(a7);
		g.ajoutArete(a8);
		g.ajoutArete(a9);
		g.ajoutArete(a10);
		g.ajoutArete(a11);
		g.ajoutArete(a12);
				
	}
	
	@Test
	public void TestNbCouleurs() {
		WelshPowel wp = new WelshPowel(g);
		int nb_couleur = wp.execute();
		// Normalement on a 3 couleurs pour ce graphe :
		assertEquals("nombres de couleurs doit être 3",3,nb_couleur);
	}
	
	@Test
	public void TestColoration() {
		WelshPowel wp = new WelshPowel(g);
		wp.execute();
		// s0, s3 et s7 doivent être de la même couleur :
		assertEquals(s0.getCouleur(),s3.getCouleur());
		assertEquals(s0.getCouleur(),s7.getCouleur());
		
		// s1, s4 et s6 doivent être de la même couleur :
		assertEquals(s1.getCouleur(),s4.getCouleur());
		assertEquals(s1.getCouleur(),s6.getCouleur());
		
		// s2, s8 et s5 doivent être de la même couleur :
		assertEquals(s2.getCouleur(),s8.getCouleur());
		assertEquals(s2.getCouleur(),s5.getCouleur());
	}
	
}
