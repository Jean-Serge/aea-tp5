package algo;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import algo.WelshPowel;
import entite.AbstractGraphe;
import entite.Graphe;
import entite.GrapheAleatoire;
import entite.Sommet;

public class TestWelshPowel {
	
	private AbstractGraphe g = new Graphe();
	
	@Before
	public void setUp() {
		Random r = new Random();
		g = new GrapheAleatoire((r.nextInt() % 1000) + 1, r.nextFloat());
	}
	
	@Test
	public void TestColoration() {
		WelshPowel wp = new WelshPowel(g);
		wp.execute();
		// Pour chaque sommet on vérifie qu'il n'y a pas de voisin de même couleur que lui.
		for (Sommet s : g.getSommets()) {
			for (Sommet vs : s.getVoisins()) {
				assertFalse(wp.getColoration().get(s) == wp.getColoration().get(vs));
			}
		}
	}
	
}
