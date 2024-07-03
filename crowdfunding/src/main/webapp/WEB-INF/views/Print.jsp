<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <form action="./print" method="post">
      <label for="name">Name</label>
      <input type="text" name="name" id="name" />
      <input type="submit" name="submit" id="submit" />
    </form>
    <button onclick="history.back()">Go Back</button>

    <h6>Note:</h6>

          <div class="alert alert-success">${message}</div>
          <div class="alert alert-danger">${error}</div>
  </body>
</html>
