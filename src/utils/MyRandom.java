package utils;

import java.util.Random;

public class MyRandom extends Random {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4505783718180659211L;

	/**
	 * Retourne une valeur aléatoire positive en utilisant la fonction next de Random pour
	 * définir le nombre de bit à utiliser.
	 * 
	 * @return une valeur aléatoire positive.
	 */
	public int nextPositive(){
		return next(31);
	}
}
