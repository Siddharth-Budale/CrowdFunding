<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project List</title>
    <style>
        .project {
            border: 1px solid #ddd;
            padding: 10px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <h1>Project List</h1>


    <!-- Container where the projects will be rendered -->
    <div id="projectContainer"></div>

    <script>
        // Get the JSON data from the JSP
        const projectsJson = '<%= request.getAttribute("projectsJson") %>';

        // Parse the JSON data
        const projects = JSON.parse(projectsJson);

        // Function to render projects
        function renderProjects() {
            const container = document.getElementById("projectContainer");

            if (projects && projects.length > 0) {
                projects.forEach(project => {
                    console.log("parsed project name : ",project.name);
                    const projectDiv = document.createElement("div");
                    projectDiv.className = "project";
                    projectDiv.innerHTML = `
                        <p><strong>Name:</strong> ${project.description}</p>
                        <p><strong>Description:</strong> ${project.description}</p>
                        <p><strong>Current Budget:</strong> ${project.currentBudget}</p>
                        <p><strong>Required Budget:</strong> ${project.requiredBudget}</p>
                    `;
                    container.appendChild(projectDiv);
                });
            } else {
                container.innerHTML = "<p>No projects found.</p>";
            }
            console.log("Parsed projects:", projects);

        }

        // Render the projects on page load
        renderProjects();
    </script>
</body>
</html>
