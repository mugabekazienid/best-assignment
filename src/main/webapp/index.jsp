<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        color: #333;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
    }

    h1 {
        color: #0056b3;
    }

    label {
        display: block;
        margin-top: 10px;
        text-align: left;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="submit"] {
        background-color: #0056b3;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }

    input[type="submit"]:hover {
        background-color: #003d80;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Enter Your Information</h1>
        <form action="RegisterServlet" method="post">
            <label for="id">ID:</label>
            <input type="text" id="id" name="id">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName">
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
