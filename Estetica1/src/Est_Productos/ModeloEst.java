package Est_Productos;
import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import Est_Productos.Est_Productos;




public class ModeloEst {
private static  DataSource origenDatos;
	
	public ModeloEst(DataSource origenDatos) {
		ModeloEst.origenDatos= origenDatos;
        }
	
	public List<Est_Productos> getProductos() throws Exception{
		List<Est_Productos> productos= new ArrayList<>();
		Connection miConexion = null;
		Statement miStatement= null;
		ResultSet miResultset = null;
	
		//establecer la conexion 
				miConexion=origenDatos.getConnection();
				
				// crear sentencia sql y statement
				String instruccionSql="select * from productosest";
				miStatement = miConexion.createStatement();
				
				//ejecutar sentencia sql
				miResultset = miStatement.executeQuery(instruccionSql);
				
				//recorrer resultset obtenido 
				
				while(miResultset.next()) {
					int id=miResultset.getInt("id_Productos");
					String producto=miResultset.getString("des_prod");
					double precio=miResultset.getDouble("precio");
					String tiempo=miResultset.getString("duracion");
					
					Est_Productos temProd = new Est_Productos(id,producto,precio, tiempo);
					productos.add(temProd);
				}
				return productos;
}

	public void agregarNuevoProducto(Est_Productos nuevoProducto) throws Exception {
		
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		//obtener conexio
		try {
			miConexion=origenDatos.getConnection();
		
			
		//crear instruccion sql para insertar producto (statement)
		String sql="insert into productosest (id_Productos,des_prod,precio,duracion)"+
				"values(?,?,?,?)";
		miStatement = miConexion.prepareStatement(sql);
		//establecer los parametros para el producto
		miStatement.setInt(1, nuevoProducto.getId());
		miStatement.setString(2, nuevoProducto.getProducto());
		miStatement.setDouble(3, nuevoProducto.getPrecio());
		miStatement.setString(4, nuevoProducto.getTiempo());
		//ejecutar la instruccion sql
		
		miStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			miStatement.close(); 
			miConexion.close();
		}
		
	}

	public static Est_Productos getProducto(String id_articulo) {
		Est_Productos elProducto = null;
		Connection miConexion = null;
		PreparedStatement miStatement = null;
		ResultSet miResultset = null;
		String idarti= id_articulo;
		try {
		//establecer la conexion con BD
			miConexion=origenDatos.getConnection();	
		//crear sql que busque el producto 
			String sql = "select*from productosest where id_Productos=?";
		
		//crear la consulta preparada
		miStatement=miConexion.prepareStatement(sql);
		//establecer los parametros de la consulta
		miStatement.setString(1,idarti );
		//ejecutar la consulta 
		miResultset=miStatement.executeQuery();
		// obtener los datos de respuesta
		if(miResultset.next()) {
			int id=miResultset.getInt("id_Productos");
			String producto=miResultset.getString("des_prod");
			double precio=miResultset.getDouble("precio");
			String tiempo=miResultset.getString("duracion");
			
			elProducto = new Est_Productos(id,producto,precio, tiempo);
			
		}else {
			throw new Exception("No se encontro producto con Id="+idarti);
		}
				
		}catch (Exception e) {
			// TODO: handle exception
		}
		return elProducto;
	}

	public void actualizarProducto(Est_Productos productoActualizado) throws Exception{
		// TODO Auto-generated method stub
		Connection miConexion=null;
		PreparedStatement miStatement = null;
		
		//Establecer la conexion
		try {
		miConexion = origenDatos.getConnection();			
		//crear sentencia sql
		String sql ="update productosest set des_prod=?, precio=?, duracion=? where id_Productos=?";
		//crear la consulta preparada
		miStatement = miConexion.prepareStatement(sql);
		//establecer los parametros
		miStatement.setString(1,productoActualizado.getProducto());
		miStatement.setDouble(2,productoActualizado.getPrecio());
		miStatement.setString(3,productoActualizado.getTiempo());
		miStatement.setInt(4,productoActualizado.getId());
		//ejecutar la instruccion sql
		miStatement.execute();
		}finally {
			miStatement.close(); 
			miConexion.close();
		}
	}

	public static void eliminarProducto(int idArticulo)throws Exception {
		Connection miConexion=null;
		PreparedStatement miStatement = null;
		
		//establecer la conexion con BD
		try {
			

		miConexion = origenDatos.getConnection();
		//crear instruccion sql de eliminacion
		String sql="delete from productosest where id=?";
		//preparar la consulta
		miStatement = miConexion.prepareStatement(sql);
		//establecer parametros de cnsulta
		miStatement.setInt(1,idArticulo);
		//ejecutar sentencia sql
		miStatement.execute();
	}finally {
		miStatement.close(); 
		miConexion.close();
	}
	}
}
