
public class Supermecado {

	private Vendedora[] vendedoras;
	private int n;
	
	public Supermecado(Vendedora[] vec,int nventas){
		this.vendedoras = vec;
		this.n = nventas; 
	}
	
	public String solucionar(){ //devuelve un String que es la cadena que se graba en el archivo .out
		
		boolean nohayganador = true;
		boolean hayganador = false;
		boolean empate=false;
		
		int pos=0;
		
		Integer[] vecCompetidor = new Integer[this.vendedoras.length]; //en este vector almaceno los mayores n importes x vendedora
		
		
		for(Vendedora obj:this.vendedoras){
			if(obj.cantVentas() > this.n) //verifico que exista al menos un participante.
				nohayganador = false;
		}///while para mejorar codigo
		
		if(nohayganador) //si esta en true no hay participantes
			return "No hay ganadoras.";
		
		while(!hayganador && !empate){
			
			for(int i=0; i<vecCompetidor.length; i++)
				vecCompetidor[i]=this.vendedoras[i].mayImportNVentas(this.n); //lleno el vecCompetidor con el mayor n 
																				//importe de cada vendedora
			pos = buscarmayor(vecCompetidor);
			
			if(vecCompetidor[pos]==0)//si el mayor importe equivale a 0 significa que hay empate
				empate=true;
			
			if(esUnico(vecCompetidor,pos)) // si es unico hay ganador
				hayganador = true;
			else
				this.n++;  
		}
		
		if(empate)
			return "No se pudo desempatar.";
	
		return (pos+1)+"\r\n"+this.n+" "+vecCompetidor[pos];	// Creo la cadena para imprimir al ganador. 
																// \r\n : salto de linea para grabar en el archivo..
	}

	private boolean esUnico(Integer[] vecCompetidor, int pos) {
		// TODO Auto-generated method stub
		
		int cont=0,i=0;
		
		while(cont<2 && i<vecCompetidor.length)
			if(vecCompetidor[i++]==vecCompetidor[pos])
				cont++;
		
//		for(int i=0; i<vecCompetidor.length; i++)
//			if(vecCompetidor[i]==vecCompetidor[pos])
//				cont++; //mejorar con while
		
		return cont<2; //devuelve true si contador es unico(se compara asi mismo asi que al menos habra 1)mejorar?

	}

	private int buscarmayor(Integer[] vecCompetidor) {
		// TODO Auto-generated method stub
		
		int mayor = vecCompetidor[0];
		int pos=0;
		
		for(int i=1; i<vecCompetidor.length; i++)
			if(vecCompetidor[i]>mayor){
				mayor=vecCompetidor[i];
				pos=i;
			}
		
		return pos;
	}
	
}
