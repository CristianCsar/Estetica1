package Est_Productos;

public class Est_Productos {

	
	public Est_Productos(int id, String productos, double precio, String tiempo) {
		super();
		this.id = id;
		this.producto = productos;
		this.precio = precio;
		this.tiempo = tiempo;
		
		
	}
	public Est_Productos(String productos, double precio, String tiempo) {
		super();
		this.producto = productos;
		this.precio = precio;
		this.tiempo = tiempo;
		
		//getters and setters
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProductos(String productos) {
		this.producto = productos;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Est_Productos [id=" + id + ", productos=" + producto + ", precio=" + precio + ", tiempo=" + tiempo
				+ "]";
	}



	private int id;
	private String producto;
	private double precio;
	private String tiempo;
	
}
