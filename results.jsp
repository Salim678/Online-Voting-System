
<%@ page import="java.sql.*,com.voting.util.DBConnection" %>
<html><head><title>Results</title></head><body>
  <h2>Results</h2>
  <table border="1">
    <tr><th>Candidate</th><th>Party</th><th>Votes</th></tr>
    <% 
      String sql = "SELECT c.name, c.party, COUNT(v.vote_id) as votes FROM candidates c LEFT JOIN votes v ON c.candidate_id=v.candidate_id GROUP BY c.candidate_id";
      try (Connection con = DBConnection.getConnection();
           java.sql.PreparedStatement ps = con.prepareStatement(sql);
           java.sql.ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          out.println("<tr><td>"+rs.getString("name")+"</td><td>"+rs.getString("party")+"</td><td>"+rs.getInt("votes")+"</td></tr>");
        }
      } catch (Exception e) { out.println("<tr><td colspan='3'>Error</td></tr>"); }
    %>
  </table>
  <p><a href="vote.jsp">Back to Vote</a></p>
</body></html>
