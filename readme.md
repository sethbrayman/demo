# Coding Challenge

A simple searchable table of products that can be viewed in a web page or accessed via API.

## Getting Started

Clone or otherwise download the project from github.

### Prerequisites

* MariaDB or Mysql installed and admin access. I used MariaDB.
* A database management tool for the DB type you choose that can import CSV's. Most can, I used MySQL Workbench.
* A java IDE to run the application from, I used Intellij.
  *  Note: If you would rather deploy the WAR file, and know what you are doing, its located in the target directory.

### Installing

1. Load the project into your IDE.
2. Edit the application.properties file with your own connection string and credentials.
3. Run the application, main method is in DemoApplication.java class. This will create a database called demo and a 
table called product.
4. Import the contents of the Products.csv file into the demo.product table using whatever method you choose.

The data should now be accessible via the web browser or via a REST call.

### View

I used the default address of localhost:8080 for the view. If everything went right and you don't have anything else 
running there that should show a table with the products and a search field.

The search will look for a partial match on any data in any column, so be specific if you want to see a smaller subset
i.e. if you search for "1" you are going to get matches on last solds, shelf lifes, xFors, and costs.

### API Calls

http://localhost:8080/api will return all products in a json format.

http://localhost:8080/api/getProductsByCriteria?criteria="some_criteria_you_want_to_search_by" will do the same thing as 
the search box.

#### Notes and Questions
Stuff that would matter more if this was a real user story for an enterprise app.

* I see some typos in product descriptions, inconsistent column name and product name conventions. Fix, ignore, 
or retain and pass on to users as is?

* Are id's unique? If not then create an auto-incrementing column for the products. Maybe just do this anyway and only
use those unique ids internally.

* Is it expected that new data will be added to this DB? If so then create a method to take another csv file or calls 
to add products. Find out what other ways they might want to add products. Full CRUD likely too.

* Are prices always in USD? If so lose the dollar signs and make it a float or whatever mysql wants for that.

* Lastsold should probably be a stored as a date, but is not in a mysql date format for direct csv import. Easy fix is 
to process the dates in from the csv programmatically, convert to a sql format when stored, and format like csv 
when displayed.

* Readme doc could be a lot better with detailed deployment instructions, well formatted API documentation, 
attributions, license info, etc. I'm making some assumptions about the app consumer's level of technical knowledge.

* Auto generated java docs can be found in the docs folder.


