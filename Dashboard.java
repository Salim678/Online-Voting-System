<%
    if (session.getAttribute("voter") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<h2>Welcome to Online Voting System</h2>
<p>You are logged in as: ${voter.name}</p>

<a href="logout">Logout</a>
