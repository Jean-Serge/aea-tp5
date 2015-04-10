package algo;

import static org.junit.Assert.assertFalse;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import entite.AbstractGraphe;
import entite.Graphe;
import entite.GrapheAleatoire;
import entite.Sommet;

public class TestDSatur {
	
	private AbstractGraphe g = new Graphe();
	
	@Before
	public void setUp() {
		Random r = new Random();
		g = new GrapheAleatoire((r.nextInt() % 1000) + 1, r.nextFloat());
	}

	@Test
	public void TestColoration() {
		DSatur ds = new DSatur(g);
		ds.execute();
		// Pour chaque sommet on vérifie qu'il n'y a pas de voisin de même couleur que lui.
		for (Sommet s : g.getSommets()) {
			for (Sommet vs : s.getVoisins()) {
				assertFalse(ds.getColoration().get(s) == ds.getColoration().get(vs));
			}
		}
	}
	
}
