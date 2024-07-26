<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Creation Form</title>
    <!-- Link to the CSS file -->
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/styles.css"
    />
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f8f9fa;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }
      h1 {
        text-align: center;
        color: #343a40;
      }
      form {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
      }
      div {
        margin-bottom: 15px;
      }
      label {
        display: block;
        margin-bottom: 5px;
        color: #495057;
      }
      input[type="text"],
      input[type="number"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ced4da;
        border-radius: 4px;
      }
      input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
      }
      input[type="submit"]:hover {
        background-color: #0056b3;
      }
      button {
        width: 100%;
        padding: 10px;
        background-color: #6c757d;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
      }
      button:hover {
        background-color: #5a6268;
      }
      .settings-container {
                  position: absolute;
                  top: 20px;
                  right: 20px;
                  display: inline-block;
              }
              .settings-icon {
                  font-size: 32px;
                  cursor: pointer;
              }
              .dropdown-content {
                  display: none;
                  position: absolute;
                  right: 0;
                  background-color: #f9f9f9;
                  min-width: 200px;
                  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                  z-index: 1;
              }
              .dropdown-content a {
                  color: black;
                  padding: 12px 16px;
                  text-decoration: none;
                  display: block;
              }
              .dropdown-content a:hover {
                  background-color: #f1f1f1;
              }
              .settings-container:hover .dropdown-content {
                  display: block;
              }
    </style>
  </head>
  <body>
  <div class="settings-container">
      <span class="settings-icon">&#9881;</span>
      <div class="dropdown-content">
          <a href="http://localhost:8080/api/project/home">Home</a>
          <a href="https://www.example.com/link2">Profile</a>
          <a href="https://www.example.com/link3">Reference Link 3</a>
          <a href="https://www.example.com/link4">Reference Link 4</a>
          <a href="http://localhost:8080/api/project/logout">Logout</a>
      </div>
  </div>
    <div>
      <h1>Creation form: ${username}</h1>
      <form action="./create" method="post">
        <div>
          <label for="name">Name</label>
          <input type="text" name="name" id="name" required /> <br />
          <label for="description">Description</label>
          <input type="text" name="description" id="description" required /> <br />
          <label for="current_budget">Current Budget</label>
          <input type="number" name="current_budget" id="current_budget" required /> <br />
          <label for="required_budget">Required Budget</label>
          <input type="number" name="required_budget" id="required_budget" required />
          <input type="submit" name="create" id="create" value="Create" />
        </div>
      </form>
      <button onclick="history.back()">Go Back</button>
    </div>
  </body>
</html>
