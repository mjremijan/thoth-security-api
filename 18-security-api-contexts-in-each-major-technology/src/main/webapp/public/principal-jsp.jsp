<!DOCTYPE html>
<%@ page import="java.security.Principal" %>
<html>
    <head>
        <title><%= pageContext.findAttribute("maven.project.artifactId")%> Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
    <body>
        <h1>JSP</h1>
        <p>
            <code>&lt;% Principal p = request.getUserPrincipal(); %&gt;</code>
        </p>
        <% Principal p = request.getUserPrincipal();%>
        <p>
            <b>Principal name:</b> "<%= p.getName()%>"
        </p>
        <p>
            Principal created by TestHttpAuthenticationMechanism.java
        </p>
    </body>
</html>
