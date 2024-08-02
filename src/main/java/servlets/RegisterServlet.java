package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(RegisterServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f8ff; color: #333; padding: 20px; }");
        out.println(".container { background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); max-width: 600px; margin: auto; }");
        out.println("h2 { color: #0056b3; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='container'>");
        out.println("<h2>ID: " + request.getParameter("id") + "</h2>");
        out.println("<h2>First Name: " + request.getParameter("firstName") + "</h2>");
        out.println("<h2>Last Name: " + request.getParameter("lastName") + "</h2>");
        out.println("</div>");
        out.println("</body></html>");

        LOGGER.log(Level.INFO, "doGet called with ID: {0}, First Name: {1}, Last Name: {2}", 
                   new Object[]{request.getParameter("id"), request.getParameter("firstName"), request.getParameter("lastName")});
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://host.docker.internal:5432/university", "postgres", "12345");

            String sql = "INSERT INTO users (id, firstName, lastName) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.executeUpdate();

            ps.close();
            conn.close();

            LOGGER.log(Level.INFO, "User registered successfully: ID={0}, First Name={1}, Last Name={2}", 
                       new Object[]{id, firstName, lastName});
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error registering user", e);
        }

        doGet(request, response);
    }
}
