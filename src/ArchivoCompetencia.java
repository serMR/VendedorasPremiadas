import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoCompetencia {
	
	public static Supermecado leer(String path) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File(path));
		int cantventas, nventas, cantvenderodas = sc.nextInt();
		Vendedora[] vecVendedoras = new Vendedora[cantvenderodas];
		Integer[] ventas;
		
		for (int i = 0; i < vecVendedoras.length; i++) {
			
			cantventas = sc.nextInt();
			ventas= new Integer[cantventas];
			
			for(int j=0; j<cantventas; j++)
				ventas[j]=sc.nextInt();
			
			vecVendedoras[i] = new Vendedora(ventas);
		}
		nventas = sc.nextInt();
		sc.close();
		
		return new Supermecado(vecVendedoras,nventas);//retorno el objeto
	   
	}
	
	public static void escribir(String path, String cad) throws FileNotFoundException{
		
		PrintWriter salida = new PrintWriter(new File(path));
		System.out.println(cad);
		salida.println(cad);//grabo
		salida.close();
		
	}
	
	

}
