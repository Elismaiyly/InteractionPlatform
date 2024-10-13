package OurPackage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smlnma", "root", "");

            if (con != null) {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String numeroTel = request.getParameter("numero_tel");
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                String sql = "INSERT INTO us (nom, prenom, numero_tel, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, nom);
                statement.setString(2, prenom);
                statement.setString(3, numeroTel);
                statement.setString(4, email);
                statement.setString(5, username);
                statement.setString(6, password);

                statement.executeUpdate();
                statement.close();
                con.close();

                response.sendRedirect("form.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}