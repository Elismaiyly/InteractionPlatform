<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire d'inscription</title>
    
   
</head>
<body>
   
  
     <h1>Formulaire d'inscription</h1>
    <form action="UserServlet" method="POST">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required><br><br>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" required><br><br>

        <label for="numero_tel">Numéro de téléphone :</label>
        <input type="text" id="numero_tel" name="numero_tel" required><br><br>

        <label for="email">Email :</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="username">Nom d'utilisateur :</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="confirmation_password">Confirmation du mot de passe :</label>
        <input type="password" id="confirmation_password" name="confirmation_password" required><br><br>

        <input type="submit" value="S'inscrire">
    </form>

</body>
</html>