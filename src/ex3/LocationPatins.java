package ex3;

import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {
	Map<Integer, Deque<Integer>> chepa;
	Map<Integer,Integer> associationPointureCasier;
	
	public LocationPatins(int[] casiers) {
		chepa = new HashMap<>();
		for (int i =33; i<=48; i++){
			chepa.put(i,new ArrayDeque<>());
		}
		for (int i = 0; i<casiers.length; i++){
			chepa.get(casiers[i]).add(i);
		}
	}

	// date1 < date2
	private static double prix(LocalTime date1, LocalTime date2) {
		// 1 euro par milliseconde (c'est assez cher en effet)
		return MILLIS.between(date1, date2) ;
	}

	public int attribuerCasierAvecPatins(int pointure) {
		if (pointure < 33 || pointure > 48)
			throw new IllegalArgumentException();
		LocalTime l = LocalTime.now();
		int casierPris = chepa.get(pointure).removeFirst();
		
		//a compléter
		casierOQPbbTaVuOue.add(casierPris);
		return casierPris;
	}

	public double libererCasier(int numeroCasier) {
		chepa.get NIK TA MER
		return 0;
	}

}
