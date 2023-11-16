java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ListarPratosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Prato");

            while (rs.next()) {
                out.println("<p>ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome") +
                            ", Tipo: " + rs.getString("tipo") +
                            ", Ingredientes: " + rs.getString("ingredientes") + "</p>");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            out.println("Erro ao listar pratos: " + e.getMessage());
        }
    }
}
