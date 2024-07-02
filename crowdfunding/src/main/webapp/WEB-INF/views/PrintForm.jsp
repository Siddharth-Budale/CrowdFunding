<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Print Project</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
    <h1>Project Details</h1>
    <p>
        Name: ${name} <br>
        Description: ${description} <br>
        Current Budget: ${current_budget} <br>
        Required Budget: ${required_budget}
    </p>
    <button onclick="history.back()">Go Back</button>
</body>
</html>
