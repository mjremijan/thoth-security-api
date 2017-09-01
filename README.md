# thoth-security-api

Research and Development on EE Security API (JSR 375)

Areas of Research
------------------

* **01-security-api-embedded** - Get Security API code up and running embedded within a WAR.  
    Each request to this application runs the Security API code.  Watch log file
    to verify it's working.  Nothing actually protected.
  * Test URL: http://localhost:8080/security-api-embedded

* **02-security-api-goodneighbor** - When the Security API code is running embedded witin a WAR, 
    make sure only that WAR is protected and not every WAR deployed to the server.
  * Test URL: http://localhost:8080/02-security-api-goodneighbor


Enjoy!

