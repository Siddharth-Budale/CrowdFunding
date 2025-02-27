<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Print Project</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
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
      p {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 600px;
        text-align: left;
        line-height: 1.6;
        color: #495057;
        word-wrap: break-word;
      }
      img {
        max-width: 80%;
        height: auto;
        border: 8px solid red;
        border-radius: 50px;
        display: block;
        margin: 10px 0;
      }
      button {
        margin-top: 20px;
        padding: 10px 20px;
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
      @media (max-width: 600px) {
        p {
          width: 95%;
        }
      }
    </style>
</head>
<body>
    <h1>Project Details</h1>
    <p>
        <strong>Name:</strong> ${name} <br>
        <strong>Description:</strong> ${description} <br>
        <strong>Current Budget:</strong> ${current_budget} <br>
        <strong>Required Budget:</strong> ${required_budget}<br>
        <c:if test="${not empty image}">
            <img src="data:image/jpeg;base64,${image}" alt="Project Image">
        </c:if>

    </p>
    <button onclick="history.back()">Go Back</button>
</body>
</html>
