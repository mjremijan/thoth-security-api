<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= pageContext.findAttribute("maven.project.artifactId") %></title>
    </head>
    <body bgcolor="red">
        <h1>Executive JSP</h1>
        <p>
            <b>Yikes!</b>.  If you are reading this, that's no good.  
            This JSP is protected by the <b>ExecutiveRole</b> role.
        </p>
    </body>
</html>
