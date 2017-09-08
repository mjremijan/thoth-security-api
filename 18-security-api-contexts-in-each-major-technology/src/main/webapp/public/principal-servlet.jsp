<!DOCTYPE html>
<html>
    <head>
        <title><%= pageContext.findAttribute("maven.project.artifactId")%> Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
    <body>
        <h1>Servlet</h1>
        <p>
            <code>Principal p = ((HttpServletRequest)request).getUserPrincipal();</code>
        </p>
        <p>
            <b>Principal name:</b> "<%= request.getAttribute("PrincipalServlet.principal.name")%>"
        </p>
        <p>
            Principal created by TestHttpAuthenticationMechanism.java
        </p>
    </body>
</html>
