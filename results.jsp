<%@ page import="java.sql.*,com.voting.util.DBConnection,dao.VoteDAO" %>
<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("role") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String role = session.getAttribute("role").toString();
%>

<html>
<head>
    <title>Voting Results</title>
</head>
<body>

<h2>Election Results</h2>

<table border="1">
    <tr>
        <th>Candidate</th>
        <th>Party</th>
        <th>Votes</th>
    </tr>

<%
    try (Connection con = DBConnection.getConnection();
         ResultSet rs = VoteDAO.getResults(con)) {

        while (rs.next()) {
%>
        <tr>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("party") %></td>
            <td><%= rs.getInt("votes") %></td>
        </tr>
<%
        }
    } catch (Exception e) {
%>
        <tr>
            <td colspan="3">Unable to fetch results</td>
        </tr>
<%
    }
%>
</table>

<br/>

<%-- Role-based navigation --%>
<% if ("admin".equalsIgnoreCase(role)) { %>
    <a href="admin.jsp">Back to Admin Dashboard</a>
<% } else { %>
    <a href="vote.jsp">Back to Vote</a>
<% } %>

<br/><br/>
<a href="logout">Logout</a>

</body>
</html>
