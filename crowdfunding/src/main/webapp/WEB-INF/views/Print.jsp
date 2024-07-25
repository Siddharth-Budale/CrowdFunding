<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Print Form</title>
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
      form {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
        margin-bottom: 20px;
      }
      label {
        display: block;
        margin-bottom: 10px;
        color: #495057;
      }
      input[type="text"] {
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
        width: 100px;
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
  <h1>Print</h1>
    <form action="./print" method="post">
      <label for="name">Name</label>
      <input type="text" name="name" id="name" required />
      <input type="submit" name="submit" id="submit" value="Submit" />
    </form>
    <button onclick="history.back()">Go Back</button>

    <h6>Note:</h6>
    <div class="alert alert-success">${message}</div>
    <div class="alert alert-danger">${error}</div>
  </body>
</html>
