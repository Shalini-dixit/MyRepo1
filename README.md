# Car-portal
<b>Car Portal</b>

The is an application with basic features like :
1. Retrieving and viewing a list of cars.
2. Click on any row of car & get redirected to next view.
3. The next view contain three panel:Car Panel, Ride Car, Car Setting Panel.
4. Car panel show effect of all the attributes.
5. Ride Car allows to start/stop & change speed of car.
6. Car Setting Panel allows to turn on/off lights & left/right signal.
7. Changes to the car can be stored to database using Save button.

<b>Some assumptions/notes about the design/code</b>
1. UI design is kept simple, main focus is on front-end, backend apis & their integration
2. There are additional end-points for creation of car & updation of attributes one to one, but that is not in the scope of UI.
3. Swagger implementation is done for documentation of Rest apis.

<b>This repository contains following :</b>
1. car-portal-api (Spring boot rest api)
2. car-portal-ui (Angular 7 UI app)
3. Planning docs (API doc generated via swagger)
4. Screen Designs (Screenshot of working app with all features)

<b>Tech-stack :</b>

UI
A single-page-application based on Angular 7.

API
RESTful API using Java-Spring, Spring boot.
Used in memory DB H2 config via spring boot to store car data.

<b>How to use/test the code?</b>

<b>Getting Started</b>

<b>Pre Requisites</b>
jdk1.8.0
angular CLI 7
maven

<b>To Test</b>
1. Go to car-portal-api/RUN_API.bat and wait for it to build and deploy API
2. You can test API is working via http://localhost:9090/cars
3. You can see API docs via http://localhost:9090/swagger-ui.html
3. Go to car-portal-ui/RUN_UI.bat and wait for it to build and deploy UI application
4. http://localhost:4200/
5. You will see the app running.

<b>To Use</b>
1. You can import api project as an existing maven app in eclipse
2. You can open ui project in ide like visual studio code 


### Design

* Screen Designs
 


For any questions/comments feel free to reach me at <b>shalinidixit.stkhlm@gmail.com</b>
<b>Author</b>
Shalini Dixit.
