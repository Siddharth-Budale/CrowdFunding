<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Stylish Page</title>
  <style>
    /* Reset some default styles */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Body styles */
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    /* Container styles */
    .container {
      text-align: center;
      background-color: #ffffff;
      padding: 40px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      max-width: 600px;
      width: 100%;
    }

    /* Heading styles */
    h2 {
      color: #333333;
      font-size: 2.5rem;
      margin-bottom: 20px;
    }

    /* Button styles */
    .btn {
      display: inline-block;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      text-decoration: none;
      border-radius: 5px;
      transition: background-color 0.3s ease;
    }

    .btn:hover {
      background-color: #45a049;
    }

    /* Alert styles */
    .alert {
      margin-top: 20px;
      padding: 10px;
      border-radius: 5px;
      font-size: 1rem;
    }

    .alert-success {
      background-color: #dff0d8;
      color: #3c763d;
    }

    .alert-danger {
      background-color: #f2dede;
      color: #a94442;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Welcome!</h2>
    <p>The requested item is not found.</p>
    <a href="/api/project/print" class="btn">Explore More</a>

    <!-- Display messages if present -->
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
  </div>
</body>
</html>
