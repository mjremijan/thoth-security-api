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
            from HttpServletRequest?  No roles, just a Principal with 
            a given name?
  * Test URL: http://localhost:8080/03-security-api-principal

* **04-security-api-isuserinrole-webxml** - Can a Principal object be generated
            from HttpServletRequest?  Both name and roles come from HttpServletRequest. 
            The roles for the application are in web.xml.
  * Test URL: http://localhost:8080/04-security-api-isuserinrole-webxml

* **04-security-api-isuserinrole-glassfishwebxml** - Can a Prinicpal object be generated
            from HttpServletRequet?  Both name and identity-management groups
            come from HttpServletRequest.  The application uses application-specific
            roles in web.xml.  The identity-management groups are mapped to
            application-specific roles in glassfish-web.xml.
  * Test URL: http://localhost:8080/04-security-api-isuserinrole-glassfishwebxml

* **05-security-api-isuserinrole-declareroles** - Can a Principal object be generated
            from HttpServletRequest?  Both name and roles come from HttpServletRequest. 
            The roles for the application are in @DeclareRoles.  No roles are
            in web.xml.
  * Test URL: http://localhost:8080/05-security-api-isuserinrole-declareroles

* **05-security-api-isuserinrole-glassfishwebxml** - Can a Prinicpal object be generated
            from HttpServletRequet?  Both name and identity-management groups
            come from HttpServletRequest.  The application uses application-specific
            roles in @DeclareRoles - no roles are in web.xml! The identity-management groups are mapped to
            application-specific roles in glassfish-web.xml.
  * Test URL: http://localhost:8080/05-security-api-isuserinrole-glassfishwebxml

* **06-security-api-sessionid** - Can JSESSIONID be created on the 1st request and then remain constant?
  * Test URL: http://localhost:8080/06-security-api-sessionid

* **07-security-api-multiplerequests** - If request 'A' sets the principal, can I make requests 'B', 'C', and
            'D' and maintain that principal across the requests?
  * Test URL: http://localhost:8080/07-security-api-multiplerequests

Enjoy!

