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
    <h1>Update</h1>

    <form action="/api/project/updateBudget" method="post">
      <div>
        <label for="name">name</label>
        <input type="text" name="name" id="name" /> <br />
        <label for="current_budget">current_budget</label>
        <input type="number" name="current_budget" id="current_budget" />
        <input type="submit" name="updateBudget" id="updateBudget" />
      </div>
    </form>
  </body>
</html>
