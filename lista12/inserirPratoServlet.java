java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class InserirPratoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        String ingredientes = request.getParameter("ingredientes");

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/mydatabase", "SA", "");
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Prato (nome, tipo, ingredientes) VALUES (?, ?, ?)");

            ps.setString(1, nome);
            ps.setString(2, tipo);
            ps.setString(3, ingredientes);
            ps.executeUpdate();

            ps.close();
            conn.close();

            response.sendRedirect("listaPratos.jsp");
        } catch (SQLException e) {
            throw new ServletException("Erro ao inserir prato", e);
        }
    }
}
