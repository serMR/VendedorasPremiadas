
public class Vendedora {

	private Integer[] ventas; //vector de ventas de vendedora
	
	public Vendedora(Integer[] vec){
		this.ventas=vec;
	}
	
	public int cantVentas(){
		return this.ventas.length;
	}
	
	public int mayImportNVentas(int n){ //calculo de mayor importe de n ventas consecutivas
		
		int total,mayor=0, i=0;
		int longitud = ventas.length;
		
		if(n>longitud) //si no cumple con n ventas no participa.
			return 0;
		
		while(i<longitud && (i+n)<=longitud){ //no puedo pasarme de la longitud del vector
			
			total=0;
			for(int j=0; j<n; j++)
				total+=this.ventas[j+i];
			
			if(total>mayor)
				mayor=total;
			i++;
		}
		
		return mayor;
	
	}
}
