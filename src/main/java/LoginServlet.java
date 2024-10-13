import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String DBURL = "jdbc:mysql://localhost:3306/smlnma";
        String UN = "root";
        String PW = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DBURL, UN, PW);
            String Req = "SELECT * FROM us WHERE username=? AND password=?";
            PreparedStatement St = con.prepareStatement(Req);
            St.setString(1, request.getParameter("username"));
            St.setString(2, request.getParameter("password"));
            ResultSet rs = St.executeQuery();

            if (rs.next()) {
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("Users.jsp");
            }
            
            rs.close();
            St.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}