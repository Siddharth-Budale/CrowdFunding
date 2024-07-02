<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
     <!-- Link to the CSS file -->
         <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
  </head>
  <body>
    <h1>Creation form</h1>

    <form action="/api/project/submitForm" method="post">
      <div>
        <label for="name">name</label>
        <input type="text" name="name" id="name" /> <br />
        <label for="description">description</label>
        <input type="text" name="description" id="description" /> <br />
        <label for="current_budget">current_budget</label>
        <input type="number" name="current_budget" id="current_budget" /> <br />
        <label for="required_budget">required_budget</label>
        <input type="number" name="required_budget" id="required_budget" />
        <input type="submit" name="submitForm" id="submitForm" />
      </div>
    </form>
  </body>
</html>
