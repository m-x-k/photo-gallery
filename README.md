# Responsive Photo Gallery

Responsive web photo gallery designed to work on mobiles, tablets etc ...

To add content just add '*.jpg' photos to '/opt/gallery/photos/'.

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

### Run the application

```./gradlew bootRun```

In a browser go to `http://localhost:8081/`.

### UI Development

For ease of frontend development you can build and run the 'ui' separately. 
See 'ui/README.md' for details. COR's has been enabled server side to allow REST api requests on different ports.

To run webpack and update the public files you can run the command: ```./gradlew updatePublicFiles``` (from the project root).