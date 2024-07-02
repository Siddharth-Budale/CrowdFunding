
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Personalized Greeting</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 0;
            text-align: center;
        }
        section {
            background: white;
            padding: 20px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<header>
    <h1>Welcome</h1>
</header>

<section>
    <h2>Personalized Greeting</h2>
    <p>Hello, <%= request.getAttribute("username") %>!</p>
</section>

</body>
</html>
