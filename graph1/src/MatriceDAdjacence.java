import java.util.*;

public class MatriceDAdjacence extends Graph{
	
	private Map<Integer, Airport>  correspondanceIndiceAirport;
	private Map<Airport, Integer>  correspondanceAirportIndice;
	private Flight[][] matrice= new Flight[0][0];
	private int nbAirport=0;

	public MatriceDAdjacence() {
		super();
		correspondanceAirportIndice= new HashMap<Airport,Integer>();
		correspondanceIndiceAirport= new HashMap<Integer,Airport>();
	}

	@Override
	// Complexit�: O(n)�
	protected void ajouterSommet(Airport a) {	
		//� compl�ter
		nbAirport++;
		Flight[][] nouvelleMatrice = new Flight[nbAirport][nbAirport];
		for(int i=0; i<nbAirport-1; i++){
			for (int j=0; j<nbAirport-1; j++){
				nouvelleMatrice[i][j] = matrice[i][j];
			}
		}
		this.matrice = nouvelleMatrice;

		correspondanceAirportIndice.put(a,nbAirport-1);
		correspondanceIndiceAirport.put(nbAirport-1, a);

	}

	@Override
	// Complexit�: O(1)
	protected void ajouterArc(Flight f) {
		int indexSource = correspondanceAirportIndice.get(f.getSource());
		int indexDest = correspondanceAirportIndice.get(f.getDestination());
		matrice[indexSource][indexDest] = f;
	}

	@Override
	// Complexit�: O(n)
	public Set<Flight> arcsSortants(Airport a) {
		int indexAirport = correspondanceAirportIndice.get(a);
		return new HashSet<>(Arrays.asList(matrice[indexAirport]));
	}

	@Override
	// Complexit�: O(1)
	public boolean sontAdjacents(Airport a1, Airport a2) {
		int index1 = correspondanceAirportIndice.get(a1);
		int index2 = correspondanceAirportIndice.get(a2);
		return matrice[index1][index2] != null || matrice[index2][index1] != null;
	}
	
	

}
