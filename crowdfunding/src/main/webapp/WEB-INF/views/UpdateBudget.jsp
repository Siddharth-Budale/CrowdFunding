<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Update Budget</title>
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
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
      }
      h1 {
        color: #343a40;
        margin-bottom: 20px;
      }
      form {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: left;
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
        margin-top: 20px;
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
      h6 {
        margin-top: 20px;
        color: #343a40;
      }
      .alert {
        padding: 10px;
        margin-top: 10px;
        border-radius: 4px;
        width: 300px;
        text-align: center;
      }
      .alert-success {
        background-color: #d4edda;
        color: #155724;
      }
      .alert-danger {
        background-color: #f8d7da;
        color: #721c24;
      }
    </style>
  </head>
  <body>
    <h1>Update Budget</h1>

    <form action="./updateBudget" method="post">
      <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name" required /> <br />
        <label for="current_budget">Current Budget</label>
        <input type="number" name="current_budget" id="current_budget" required />
        <input type="submit" name="update" id="update" value="Update" />
      </div>
    </form>
    <button onclick="history.back()">Go Back</button>

    <h6>Note:</h6>
    <div class="alert alert-success">${message}</div>
    <div class="alert alert-danger">${error}</div>
  </body>
</html>
