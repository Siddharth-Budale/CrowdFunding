<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Crowdfunding Website</title>
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
      }
      h1 {
        text-align: center;
        background-color: #343a40;
        color: white;
        padding: 1em 0;
        margin: 0;
      }
      section {
        padding: 20px;
        margin: 20px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      }
      h3 {
        color: #495057;
      }
      p {
        color: #6c757d;
        line-height: 1.6;
      }
      div a {
        display: block;
        margin: 10px 0;
        padding: 10px;
        color: #007bff;
        text-decoration: none;
        background-color: #e9ecef;
        border-radius: 4px;
        transition: background-color 0.3s;
      }
      div a:hover {
        background-color: #ced4da;
      }
    </style>
  </head>
  <body>
    <h1>Welcome ${username}</h1>
    <section>
      <h3>Crowdfunding</h3>
      <p>
        This is a small description of the webpage. This is a crowdfunding
        website, so here's some information. Lorem ipsum dolor sit amet,
        consectetur adipisicing elit. Dolor at, possimus quibusdam consequuntur
        aperiam voluptate reiciendis culpa eius, debitis atque perferendis
        maiores cupiditate officiis nostrum architecto deserunt sequi modi sed?
      </p>
    </section>
    <section>
      <h3>Links</h3>
      <div>
        <a href="./create">Creation Form</a>
        <a href="./print">Print Form</a>
        <a href="./update">Update Form</a>
        <a href="./fundBrowser">Fund Browser</a>
        <a href="./logout">Logout</a>
      </div>
    </section>
  </body>
</html>
