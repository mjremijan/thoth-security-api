# thoth-security-api

Research and Development on EE Security API (JSR 375)

Areas of Research
------------------

* **01-security-api-embedded** - Get Security API code up and running embedded within a WAR.  
    Each request to this application runs the Security API code.  Watch log file
    to verify it's working.  Nothing actually protected.
  * Test URL: http://localhost:8080/security-api-embedded

* **02-security-api-goodneighbor** - When the Security API is being used by a WAR, 
            will it protect only the WAR it's in or every WAR 
            deployed to the server?
  * Test URL: http://localhost:8080/02-security-api-goodneighbor

* **02-security-api-helloworld** - This is a test application to be used
            with 02-security-api-goodneighbor.  Watch the log files of
            this application and you'll see that no Security API code
            is executed when this application is used.
  * Test URL: http://localhost:8080/02-security-api-helloworld

* **03-security-api-principal** - Can a Principal object be generated
            from `HttpServletRequest`?  No roles, just a Principal with 
            a given name?
  * Test URL: http://localhost:8080/03-security-api-principal

* **04-security-api-isuserinrole-webxml** - Can a Principal object be generated
            from `HttpServletRequest`?  Both name and roles come from `HttpServletRequest`. 
            The roles for the application are in `web.xml`.
  * Test URL: http://localhost:8080/04-security-api-isuserinrole-webxml

* **04-security-api-isuserinrole-glassfishwebxml** - Can a `Prinicpal` object be generated
            from HttpServletRequet?  Both name and identity-management groups
            come from `HttpServletRequest`.  The application uses application-specific
            roles in `web.xml`.  The identity-management groups are mapped to
            application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/04-security-api-isuserinrole-glassfishwebxml

* **05-security-api-isuserinrole-declareroles** - Can a Principal object be generated
            from `HttpServletRequest`?  Both name and roles come from `HttpServletRequest`. 
            The roles for the application are in `@DeclareRoles`.  No roles are
            in `web.xml`.
  * Test URL: http://localhost:8080/05-security-api-isuserinrole-declareroles

* **05-security-api-isuserinrole-glassfishwebxml** - Can a `Prinicpal` object be generated
            from HttpServletRequet?  Both name and identity-management groups
            come from `HttpServletRequest`.  The application uses application-specific
            roles in `@DeclareRoles` - no roles are in `web.xml`! The identity-management groups are mapped to
            application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/05-security-api-isuserinrole-glassfishwebxml

* **06-security-api-sessionid** - Can JSESSIONID be created on the 1st request and then remain constant?
  * Test URL: http://localhost:8080/06-security-api-sessionid

* **07-security-api-multiplerequests** - If request 'A' sets the principal, can I make requests 'B', 'C', and
            'D' and maintain that principal across the requests?
  * Test URL: http://localhost:8080/07-security-api-multiplerequests

* **08-security-api-servlet-protected-annotations** - Can there be a servlet that's protected 
            which is accessible only by a certain application-specific role?  The servlet 
            is protected by `@ServletSecurity`.  The application uses 
            application-specific roles in `@DeclareRoles`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`. `web.xml` is 
            essentially empty.
  * Test URL: http://localhost:8080/08-security-api-servlet-protected-annotations

* **08-security-api-servlet-protected-webxml** - Can there be a servlet that's protected 
            which is accessible only by a certain application-specific role?  The servlet 
            is protected by <security-constraint> in `web.xml`.  The application uses 
            application-specific roles in `web.xml`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/08-security-api-servlet-protected-webxml

* **09-security-api-jsp-protected-annotations** - Can there be a JSP that's protected 
            which is accessible only by a certain application-specific role?  The JSP 
            is protected by <security-constraint> in `web.xml`.  The application uses 
            application-specific roles in `@DeclareRoles`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/09-security-api-jsp-protected-annotations

* **09-security-api-jsp-protected-webxml** - Can there be a JSP that's protected 
            which is accessible only by a certain application-specific role?  The JSP 
            is protected by <security-constraint> in `web.xml`.  The application uses 
            application-specific roles in `web.xml`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/09-security-api-jsp-protected-annotations

* **10-security-api-unprotected-to-protected** - If the application has a public 
            servlet that attempts to forward to either a protected servlet or JSP, 
            will the forward request be denied?
  * Test URL: http://localhost:8080/10-security-api-unprotected-to-protected

* **11-security-api-get-cdi-bean-identitystorehandler** - When I get to the important code 
            (the code I write to create
            the Principal and groups) can I use CDI to get an
            instance of some object which will help me get the principal 
            and group information?
  * Test URL: http://localhost:8080/11-security-api-get-cdi-bean-identitystorehandler

* **12-security-api-ejb-integration** - If I have an EJB which is protected by `@RolesAllowed`,
            will an EJB method call fail if I don't have that role?
            Will an EJB method call succeed if I do have that role?
  * Test URL: http://localhost:8080/12-security-api-ejb-integration

* **13-security-api-wrapping-request-doesnt-work** - Does proxying the 
            `HttpServletRequest` with a `@WebFilter` work just as well?
  * Test URL: http://localhost:8080/13-security-api-wrapping-request-doesnt-work

* **14-security-api-jsf-page-protected-webxml** - Can there be a JSF page that's protected 
            which is accessible only by a certain application-specific role?  The JSF page
            is protected by `<security-constraint>` in `web.xml`.  The application uses 
            application-specific roles in `@DeclareRoles`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/14-security-api-jsf-page-protected-webxml

* **15-security-api-jsf-managedbean-protected-webxml** - If my JSF page tries to call 
            a method on a managed bean which it should not have access to, will the 
            method call fail? The application uses 
            application-specific roles in `@DeclareRoles`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/15-security-api-jsf-managedbean-protected-webxml

* **16-security-api-jsf-ajax-protected-webxml** - 
            Can there be a JSF AJAX call that's protected 
            which is accessible only by a certain application-specific role?
            The JSF AJAX call 
            is protected by `<security-constraint>` in `web.xml`.  The application uses 
            application-specific roles in `@DeclareRoles`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/16-security-api-jsf-ajax-protected-webxml

* **17-security-api-jaxrs-protected-ejb-annotations** - 
            Can there be a JAX-RS client call that's protected 
            which is accessible only by a certain application-specific role?
            The JAX-RS client 
            is protected by `@RolesAllowed` (without the use of proprietary Jersey code).  
            The application uses 
            application-specific roles in `@DeclareRoles`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/17-security-api-jaxrs-protected-ejb-annotations

* **17-security-api-jaxrs-protected-jersey-annotations** - 
            Can there be a JAX-RS client call that's protected 
            which is accessible only by a certain application-specific role?
            The JAX-RS client 
            is protected by `@RolesAllowed` (without the use of standard EJBs).  
            The application uses 
            application-specific roles in `@DeclareRoles`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/17-security-api-jaxrs-protected-jersey-annotations

* **17-security-api-jaxrs-protected-webxml** - 
            Can there be a JAX-RS client call that's protected 
            which is accessible only by a certain application-specific role?
            The JAX-RS client 
            is protected by `<security-constraint>` in `web.xml`
            (without the use of standard EJBs or proprietary Jersey code).  
            The application uses 
            application-specific roles in `@DeclareRoles`.  The identity-management groups are 
            mapped to application-specific roles in `glassfish-web.xml`.
  * Test URL: http://localhost:8080/17-security-api-jaxrs-protected-webxml

* **18-security-api-contexts-in-each-major-technology** - 
How do you get the Principle from each major technology?
  * JSP
  * Servlet
  * EJB
  * JSF
  * JAX-RS
  * Test URL: http://localhost:8080/18-security-api-contexts-in-each-major-technology

* **20-security-api-customprincipal-web** - Can I create my own custom `MyPrincipal` object?
            The ideas is the custom `MyPrincipal` object can contain more information
            about the user whose logged in than a normal `Principal` object.  In addition,
            can the `MyPrincipal#toString()` method be 
            overloaded to return a JSON representation of the principal data?  This way,
            as features are developed, code doesn't need to typecast and be 
            coupled to the `MyPrincipal` object.  Instead, features can use the 
            JSON representation to build their own object to use internally.
  * Test URL: http://localhost:8080/20-security-api-customprincipal-web

* **21-security-api-identitystorehandler** - Can I create my own 
        `IdentityStore`, `Credential`, and `Principal` and have
        `IdentityStoreHandler` validate the request?
    * Test URL: http://localhost:8080/21-security-api-identitystorehandler

* **XX-multiple-identitystores**

pom.xml
package rename
security replace
index.xhtml question
principal.xhtml
template.xhtml

Enjoy!

