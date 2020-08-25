package Est_Productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServPrueba
 */
@WebServlet("/ServPrueba")
public class ServPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/E_Productos")
	private DataSource miPool;
       
    public ServPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Crear el objeto printWritter
		
				PrintWriter salida = response.getWriter();
				
				response.setContentType("text/plain");
				
	    //crear conexion BD
				
				Connection miConexion = null;
				Statement miStatement = null;
				
				ResultSet miResultset = null;		
				
				try {
					miConexion= miPool.getConnection();
					String miSql = "select * from productosest";
					miStatement = miConexion.createStatement();
					miResultset=miStatement.executeQuery(miSql);
					
					while(miResultset.next()) {
						String des_prod = miResultset.getString(2);
						salida.println(des_prod);
					}
					
					
				}catch(SQLException e){
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
