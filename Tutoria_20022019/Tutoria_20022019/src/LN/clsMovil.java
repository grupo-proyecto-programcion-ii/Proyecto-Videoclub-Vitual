package LN;

public class clsMovil 
{
	
	private String marca;
	private String modelo;
	private String color;
	private int precio;
	
	
	public clsMovil (String _marca,String _modelo,String _color, int _precio)
	{
		this.marca=_marca;
		this.modelo=_modelo;
		this.precio=_precio;
		this.color=_color;
		
	}
	
	public int getPrecio() 
	{
		return precio;
	}

	public void setPrecio(int precio) 
	{
		this.precio = precio;
	}

	public String getMarca() 
	{
		return marca;
	}
	
	public void setMarca(String marca) 
	{
		this.marca = marca;
	}
	
	public String getModelo() 
	{
		return modelo;
	}
	
	public void setModelo(String modelo) 
	{
		this.modelo = modelo;
	}
	
	public String getColor() 
	{
		return color;
	}
	
	public void setColor(String color) 
	{
		this.color = color;
	}
	
		
	
	
	
	
	

}
