# File Upload to DB - API
## Repository to upload file and save the data in DB

This repository is a util project for uploading any kind of data from file formats (Excel, CSV, XML) to database. Currently this repository supports Excel file. This repository also extends cronjob as well where you can just write the logic inside your files inside job package and set the time, based on which it will run your customized logic.

## Prerequisite before working
- Java 11 (You can go for Open JDK - https://openjdk.org/projects/jdk/11/)
- Spring Boot
- Hibernate

## How to Run ?

- Import this project to your local system
- Run the main application file i.e. `FileUploadSpringBootApplication.java`
- Once the server is started it will run few jobs as well. If you want to disable them please remove the `@Scheduled` annotation from the classes under job package.
- Go to Postman and hit the below URL with POST :
```sh
POST : http://localhost/api/v1/excel/upload
```
- Go to `Body` -> `form-data` -> pass key as "file" and on the key column towards the right end you will see a dropdown to choose "text" or "file".
- Choose "file" from dropdown and in the value upload your excel file.
- Sample file is added inside resources directory of this repo. Customize as you need.
- Send the request and BOOOM!!! Data will be uploaded.
- Don't forget to change the database connection properties as your local mysql connection

## Need to add/customize the data ?
- There is a model class `ProductModel.java`, change the attribute to whatever you need and generate getters setters for that. It's a Hibernate Entity so customize as you need, no requirement to create table/columns in DB.
- Go to `UploadValidator.java` class and inside `convertExcelToListOfProduct` method, there's a switch case, change it to whatever you need. I will try to modify this logic later on but as of now this will also work.

Feel free to raise Pull Request for further code improvement/bug fix.


