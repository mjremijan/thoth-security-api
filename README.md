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
  * Test URL: http://localhost:8080/security-api-principal

Enjoy!

