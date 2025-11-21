
<%@ page import="com.voting.dao.CandidateDAO,com.voting.dao.ElectionDAO,com.voting.model.Voter"%>
<%@ page session="true" %>
<%
    Voter voter = (Voter) session.getAttribute("voter");
    if (voter == null) { response.sendRedirect("login.jsp"); return; }
    CandidateDAO cdao = new CandidateDAO();
    ElectionDAO edao = new ElectionDAO();
    java.util.List candidates = cdao.findAll();
    java.util.List elections = edao.findAll();
%>
<html><head><title>Vote</title></head><body>
  <h2>Cast Your Vote</h2>
  <p>Hello, <b><%= voter.getName() %></b></p>
  <form action="vote" method="post">
    Election:
    <select name="electionId">
      <% for (Object o : elections) {
           com.voting.model.Election e = (com.voting.model.Election)o; %>
         <option value="<%= e.getElectionId() %>"><%= e.getTitle() %></option>
      <% } %>
    </select><br/>
    Candidate:
    <select name="candidateId">
      <% for (Object o : candidates) {
           com.voting.model.Candidate c = (com.voting.model.Candidate)o; %>
         <option value="<%= c.getCandidateId() %>"><%= c.getName() %> (<%= c.getParty() %>)</option>
      <% } %>
    </select><br/>
    <button type="submit">Submit Vote</button>
  </form>
  <p><a href="results.jsp">View Results</a></p>
</body></html>
