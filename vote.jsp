<%@ page import="java.util.*,model.Candidate,dao.CandidateDAO" %>
<html>
<head>
    <title>Vote</title>
</head>
<body>

<h2>Cast Your Vote</h2>

<form action="vote" method="post">

<%
    List<Candidate> list = CandidateDAO.getAllCandidates();
    for (Candidate c : list) {
%>
    <input type="radio" name="candidateId" value="<%=c.getId()%>" required />
    <%= c.getName() %> (<%= c.getParty() %>) <br/>
<%
    }
%>

<br/>
<button type="submit">Submit Vote</button>
</form>

<br/>
<a href="logout">Logout</a>

</body>
</html>
