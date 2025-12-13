<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>

<h2>Admin - Add Candidate</h2>

<form action="admin" method="post">
    <input type="hidden" name="action" value="addCandidate"/>

    Name:
    <input type="text" name="name" required/><br/><br/>

    Party:
    <input type="text" name="party" required/><br/><br/>

    <button type="submit">Add Candidate</button>
</form>

<br/>
<a href="logout">Logout</a>

</body>
</html>
