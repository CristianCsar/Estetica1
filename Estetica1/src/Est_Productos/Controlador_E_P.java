package Est_Productos;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Est_Productos.ModeloEst;


/**
 * Servlet implementation class Controlador_E_P
 */
@WebServlet("/Controlador_E_P")
public class Controlador_E_P extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private ModeloEst esteticaproductos;
    
    @Resource(name="jdbc/E_Productos")
	private DataSource miPool;
    
    //activamos el metodo init 
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			esteticaproductos = new ModeloEst(miPool);
		}catch(Exception e){
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Leer el parametro del formulario
		String elComando = request.getParameter("instruccion");
		
		// si no se envia el parametro, listar productos
		if(elComando==null) elComando="listar";
			
		
		// Redirigir el flujo de ejecucion al metodo adecuado
		
		switch (elComando) {
		case "listar":
			obtenerProductos(request, response);
			
			break;
		case "insertarBD":
			agregarProductos(request, response);
			break;
			
		case"cargar":
			try {
				cargaProductos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		
		case"actualizarBD":
			try {
				actualizaProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case"eliminar":
			
			try {
				eliminarProducto(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			obtenerProductos(request, response);
		}
		
		
		
		
		

			
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)throws Exception {
		//Capturar el id del articulo
		int IdArticulo = Integer.parseInt(request.getParameter("idarticulo")) ;
		
		//borrar producto de BD
		ModeloEst.eliminarProducto(IdArticulo);
		
		//volver al listado de productos
		
		obtenerProductos(request, response);
		
	}

	private void actualizaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	      // Leer los datos que vienen del formulario de actualizar
		
					int IdArticulo = Integer.parseInt(request.getParameter("id")) ;
					String Descripcion = request.getParameter("descripcion");
					double Precio = Double.parseDouble(request.getParameter("precio"));
					String Duracion= request.getParameter("tiempo");
						
		
		//crear un objeto de tipo producto con la info del formulario
				Est_Productos productoActualizado = new Est_Productos(IdArticulo,Descripcion,Precio,Duracion);
					
		//actualizar la BD con la info del objeto producto
				esteticaproductos.actualizarProducto(productoActualizado);
		//Volver al listado con la info actualizada
				obtenerProductos(request, response);
	}

	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Leer el id articulo que viene del listado
		String id_articulo=request.getParameter("idarticulo"); 	
		// enviar id articulo a modelo
		Est_Productos elProducto=ModeloEst.getProducto(id_articulo);
				
		// colocar atributo correspondiente al id articulo
		request.setAttribute("ProductoActualizar", elProducto);
		// enviar producto al formulario de actualizar(jsp)
		RequestDispatcher Dispatcher=request.getRequestDispatcher("/actualizarProducto.jsp");
		Dispatcher.forward(request, response);
	}

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		
		
		// Leer la informacion del producto que viene del formulario
			int IdArticulo = Integer.parseInt(request.getParameter("id")) ;
			String Descripcion = request.getParameter("descripcion");
			double Precio = Double.parseDouble(request.getParameter("precio"));
			String Duracion= request.getParameter("tiempo");
		// crear un objeto de tipo producto
			Est_Productos nuevoProducto = new Est_Productos(IdArticulo,Descripcion,Precio,Duracion);
		
		// enviar el objeto al modelo
			try {
				esteticaproductos.agregarNuevoProducto(nuevoProducto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		// volver al listado de la tabla productos
			obtenerProductos(request, response);
		
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//obtener lista de productos desde el modelo
		
		List<Est_Productos> productos;
		
		try {
			productos=esteticaproductos.getProductos();
		
		
		//agregar lista de productos al request
			request.setAttribute("ProductosEstetica", productos);
		
		//enviar request a la pagina jsp                               // apunta a la pagina jsp que vamos a usar
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/Lista_E_Productos.jsp");
			
			miDispatcher.forward(request, response);
				
		}catch(Exception e) {
				e.printStackTrace();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
