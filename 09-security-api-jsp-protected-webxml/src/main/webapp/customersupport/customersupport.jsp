<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= pageContext.findAttribute("maven.project.artifactId") %></title>
    </head>
    <body bgcolor="#C0C0C0">
        <h1>CustomerSupport JSP</h1>
        <p>
            <b>Yes!</b>.  If you are reading this, that's OK.  
            This JSP is protected by the <b>CustomerSupportRole</b> role,
            which you have.
        </p>
    </body>
</html>
