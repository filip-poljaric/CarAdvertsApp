
This is car adverts app.
Hi! This is car adverts app. With this app you can make a car advert.

To make this application work, follow a few simple steps.

First download the app from my github account: https://github.com/filip-poljaric/CarAdvertApp.

Open the CarAdvertApp folder in a code editor.

Under resources folder in application.yml file you need to provide a valid uri:(valid URI), to connect with your database. You can get your mongoDB URI on: https://account.mongodb.com/account/login.

When you provide a valid mongoDB URI save the changes, and run the app.


When the app is running you can send:

-post request using: http://localhost:8080/car/adverts to post an car advert.
In request body you should use a json data type: 
 {
    "title": "",
    "fuelType": "",
    "price": ,
    "isNew": ,
    "mileage": ,
    "firstRegistration": "yyyy-mm-dd"
}

-get request using: http://localhost:8080/car/adverts to get all adverts, or http://localhost:8080/car/adverts/carId to get an advert by id. 
For sorting an adverts use http://localhost:8080/car/adverts?sortby=[field_name].

-put request using: http://localhost:8080/car/adverts/carId to update an car advert: 
In request body you should use a json data type:

{
    "carId": "",
    "title": "",
    "fuelType": "",
    "price":,
    "isNew": ,
    "mileage": ,
    "firstRegistration": "yyyy-mm-dd"
}

-delete request using http://localhost:8080/car/adverts/carId to delete an car advert.

To send a requests you can use Postman REST API client.
