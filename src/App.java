
import java.io.FileNotFoundException;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Supermecado comp = ArchivoCompetencia.leer(".\\premio.in");
		ArchivoCompetencia.escribir(".\\premio.out", comp.solucionar());
		
	}

}
