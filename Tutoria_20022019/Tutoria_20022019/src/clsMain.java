import java.util.ArrayList;

import LN.clsMovil;

public class clsMain 
{
	
	public static void main (String [] args)
	{
		
		
		
		//DECLARACION DEL OBJETO
		ArrayList<clsMovil> listaM;
		//CREO EL OBJETO
		listaM= new ArrayList<clsMovil>();
		
		
		altaMovil(listaM);
		
		for(clsMovil a:listaM)
		{
			System.out.println(a.getColor() + " " + a.getMarca() + " " + a.getModelo() + " " + a.getPrecio()  );
		}
		
		
		
		
		
	
//***************************************************
//		//Con arrays	
//		clsMovil ellos[];
//		ellos=new clsMovil[10];
//		for(int i=0;i<ellos.length;i++)
//		{
//			if(ellos[i]==null)
//				ellos[i]=objMovil;
//
//				
//		}
//		ellos[0]=objMovil;
//		ellos[0]=objMovil2;
//***************************************************		
		
//		objMovil.setColor("gris");
////		objMovil.setMarca("yoquese");
//		objMovil.setModelo("J7");
//		objMovil.setPrecio(20);
		
		
		
		
	}
	
	private static void altaMovil (ArrayList<clsMovil>listaM)
	{
		
		int precio;
		String marca;
		String color;
		String modelo;
		
		clsMovil objMovil;
		clsMovil objMovil2;
		
		marca="yoquese";
		modelo="J7";
		precio=20;
		color="gris";
		
		objMovil = new clsMovil(marca,modelo,color,precio);
		
		marca="ffff";
		modelo="hgjkt";
		precio=3330;
		color="morauuuuuu";
		objMovil2 = new clsMovil(marca,modelo,color,precio);
		
		listaM.add(objMovil2);
		listaM.add(objMovil);
		listaM.add(objMovil2);
		
		
	}

}
