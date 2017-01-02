UI photo gallery
================

* Frontend-UI: React, React Photo Gallery, npm, webpack

Requires:
---------

* npm (e.g. brew install npm)
* webpack (e.g. npm install webpack -g)

Setup:
------

```npm install```

Run:
----

```npm start```

http://localhost:8080/

Package:
--------

Run the command ```webpack``` in order to produce 'index.js'


Configuration:
--------------

By default the UI will run on port 8080 and try to connect to the same host and port for the backend serverside images.

You can override this behaviour in the 'webpack.config.js' file by changing the APP_URL and DEV_MODE=true.

Please note that any changes to this file can be copied over to the main application resources/public folder if you are not careful.
