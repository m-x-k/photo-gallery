[![Build Status](https://travis-ci.org/m-x-k/photo-gallery.svg?branch=master)](https://travis-ci.org/m-x-k/photo-gallery)
[![codecov](https://codecov.io/gh/m-x-k/photo-gallery/branch/master/graph/badge.svg)](https://codecov.io/gh/m-x-k/photo-gallery)

# Responsive Photo Gallery

[https://responsive-photo-gallery.herokuapp.com/](https://responsive-photo-gallery.herokuapp.com/)

Responsive web photo gallery designed to work on mobiles, tablets etc ...

To add content just add '*.jpg' photos to '/app/photos/'.

## Sub-folders
* src/: spring boot application code
* ui/: Folder for frontend development

## Requirements

* JDK version 7+

### Compile and run tests

```./gradlew clean build test```

### IDE Setup

#### Intellij

```./gradlew cleanIdea idea```

### Run

#### Run locally

```PORT=8081 ./gradlew bootRun```

In a browser go to `http://localhost:8081/`.

#### Run remotely via heroku

Assuming you have a heroku account you can setup and remotely deploy the application by running the following:
```
heroku login
heroku create
git push heroku master
heroku ps:scale web=1
heroku open
heroku logs --tail
```

### UI Development

For ease of frontend development you can build and run the 'ui' separately. 
See 'ui/README.md' for details. COR's has been enabled server side to allow REST api requests on different ports.

To run webpack and update the public files you can run the command: ```./gradlew updatePublicFiles``` (from the project root).
