package OurPackage;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class gestionPub extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public gestionPub() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Publication> publications = recupererPublicationsAvecUtilisateur();

        HttpSession session = request.getSession();
        session.setAttribute("commentList", publications);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/accueil.jsp");
        dispatcher.forward(request, response);
    }
    private List<Publication> recupererPublicationsAvecUtilisateur() {
        List<Publication> publications = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smlnma", "root", "");
             PreparedStatement statement = con.prepareStatement(
                     "SELECT p.*, u.username FROM Publication p JOIN us u ON p.id_user = u.Id");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String contenu = resultSet.getString("contenu");
                LocalDateTime tempsPublication = resultSet.getTimestamp("DatePub").toLocalDateTime();
                String auteur = resultSet.getString("username");

                Publication publication = new Publication(contenu, tempsPublication, auteur);
                publications.add(publication);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les exceptions de manière appropriée dans votre application
        }

        return publications;
    }
}