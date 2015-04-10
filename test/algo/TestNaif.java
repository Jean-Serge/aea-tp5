package algo;

import static org.junit.Assert.assertFalse;

import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import entite.AbstractGraphe;
import entite.GrapheAleatoire;
import entite.Sommet;

/**
 * Classe permettant de tester le fonctionnement de l'algorithme de coloration naïf.
 * 
 * @author Jean-Serge Monbailly
 *
 */
public class TestNaif {

	private AbstractGraphe g;
	
	@Before
	public void setUp(){
		Random r = new Random();
		g = new GrapheAleatoire(r.nextInt() % 1000, r.nextFloat());
	}

	/**
	 * Ce test vérifie la cohérence du résultat donnée par l'algo naïf.
	 */
	@Test
	public void testAlgo(){
		Map<Sommet, Integer> map = new Naif(g).getColoration();
		
		for(Sommet s : map.keySet()){
			for(Sommet v : s.getVoisins())
				assertFalse(map.get(s) == map.get(v));	
		}
	}
}
