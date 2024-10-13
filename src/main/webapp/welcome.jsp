<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.List" %>
<%@page import ="OurPackage.PublicatioNN" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Accueil</title>
</head>
<body>

<h2>Accueil</h2>
<form action="Publication" method="POST">
    <label for="monChampTexte">Votre Publication :</label><br>
    <textarea id="monChampTexte" name="monChampTexte" rows="8" cols="80" maxlength="2000"></textarea><br>
    <input type="submit" value="Post">
</form>

<h1>
    <% 
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = now.format(formatter);
    out.println(formattedDateTime);
    %>
</h1>

<h2>
    <%
    List<PublicatioNN> myCommentList = (List<PublicatioNN>) session.getAttribute("commentList");
    if (myCommentList != null) {
        for (PublicatioNN publication : myCommentList) {
    %>
    <ul>
        <li>
            <%= publication.getContenu() %> - <%= publication.getAuteur() %> - <%= publication.getTempsPublication() %>
        </li>
    </ul>
    <%
        }
    }
    %>
</h2>

</body>
</html>
