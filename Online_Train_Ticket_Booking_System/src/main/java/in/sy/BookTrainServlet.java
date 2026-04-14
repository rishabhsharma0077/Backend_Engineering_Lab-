package in.sy;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class BookTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int trainId = Integer.parseInt(req.getParameter("trainId"));
        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
              "INSERT INTO bookings(user_id,train_id,booking_date) VALUES(?,?,?)");
            ps.setInt(1, userId);
            ps.setInt(2, trainId);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();

            res.sendRedirect("success.html");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

