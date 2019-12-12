![new york](https://user-images.githubusercontent.com/43714418/70740688-ae914300-1ce7-11ea-85ac-839abda0da08.jpg)




# GUI_Project
GUI Project
Kevin Kenny 

Week 1

Create JavaFX project IntelliJ Help Share to private repository on GitHub Create README, use https://stackedit.io/, review markdown 

Week 2
Add a tab view with three tabs: Product Line, Record Production, and Production Log Quality expectations, Inspect code, FindBugs Style expectations, Google Style, Formatter, CheckStyle Javadoc and other documentation expectations 

Week 3
Add a button to each tab For now, just have the button print to the console (System.out.println) 

Week 4
Install database software if necessary Create database Similar to... create table Product ( id int auto_increment, name varchar, type varchar, manufacturer varchar ); create unique index Product_id_uindex on Product (id); alter table Product add constraint Product_pk primary key (id); create table ProductionRecord ( production_num int auto_increment, product_id int, serial_num varchar, date_produced datetime ); Connect to database SELECT 

Week 5
Other database operations Prepare for submission Sprint 2

Sprint 2
Week 6
Issue 1 - Product

All items will have a pre-set type. Currently there are 4 types. Create an enum called ItemType that will

store the following information.

Type

Audio

Visual

AudioMobile

VisualMobile

Code

AU

VI

AM

VM

Create a ComboBox to allow the user to select a type.

Create an interface called Item that will force all classes to implement the following functions.

A method getId that would return an int A method setName that would have one String parameter A method getName that would return a String A method setManufacturer that would have one String parameter A method getManufacturer that would return a String Create an abstract type called Product that will implement the Item interface. Product will implement the basic functionality that all items on a production line should have. Add the following fields to Product

int id String type String manufacturer String name Complete the methods from the interface Item.

Add a constructor that will take in the name of the product and set this to the field variable name.

Add a toString method that will return the following: (example data shown).

Name: iPod Manufacturer: Apple Type: AM Create a database table for Product.

To test the Product class, temporarily create a Widget class that extends Product. Store a created Widget object to the database and a productLine collection.

Week 7 Inheritance

Issue 2 - AudioPlayer

All of the items on this production line will have basic media controls. Create an interface called MultimediaControl that will define the following methods which don't need to return anything.

play() stop() previous() next(); We require a concrete class that will allow us to capture the details of an audio player. Create a class called AudioPlayer that is a subclass of Product and implements the MultimediaControl interface.

The class will have 2 fields

String audioSpecification String mediaType Create a constructor that will take in 3 parameters – name, manufacturer, and audioSpecification.

The constructor should call its parents constructor and also setup the media type.

Implement the methods from the MultimediaControl interface by simply writing the action to the console.

E.g. in play System.out.println("Playing"); Normally we would have code that would instruct the media player to play, but we will simply display a message.

Create a toString method that will display the superclass's toString method, but also add rows for Audio Spec and Type.

Create a driver class for AudioPlayer that will test to see whether we can instantiate occurrences of it, use the media controls and print out their details to the console.

Week 8

Week 8 and 9 Polymorphism

Issue 3 - Production

MonitorType 

The production facility will also create portable movie players. The main difference between these and the audio players is that they contain screens. Create an enum called MonitorType that will store

Type

LCD

LED

ScreenSpec

Create an interface called ScreenSpec. This will define 3 methods:

public String getResolution();
public int getRefreshRate();
public int getResponseTime();
Screen 

Create a class called Screen that implements ScreenSpec. Add three fields

String resolution
int refreshrate
int responsetime
Complete the methods from the ScreenSpec interface.

Add a toString method that will return the details of the 3 fields in the same format as the Product class.

MoviePlayer 

Create a class called MoviePlayer that extends Product and implements MultimediaControl.

Add 2 fields to this class called screen and monitorType and assign appropriate types to them.

Create a constructor that accepts the name, manufacturer, a screen, and a monitor type. The constructor can set the item type to VISUAL. 

Complete the methods from the MultimediaControl interface in a similar fashion to the AudioPlayer.

Create a toString method that calls the Product toString and displays the monitor and the screen details.

MultimediaControl 

The audio players and the movie players share the same control interface on the physical devices. The control interface does not care if the device is a video player or an audio player. 


Week 10 Encapsulation

Issue 5 - Production enhancement

Add the ability for the program to generate a unique serial number for each produced product. 


Week 11 Lists and ArrayLists

Issue 6 - TableView

Show all Products in the Product Line tab TableView. 

Create an ObservableList named productLine to hold all of the Products that can be produced. For now, when the Add Product button is clicked, add to this list.
Set the items of the TableView to the ObservableList
You can do this in a setupProductLineTable that also sets the columns and does the setCellValueFactory
Show all Products in the Produce tab ListView.

Use the selected item from the ListView as the item used to record production.
Show the production log in the Production Log tab TextArea. 


Sprint 3 Coming Soon...

![ezgif com-gif-maker](https://user-images.githubusercontent.com/43714418/70740965-56a70c00-1ce8-11ea-92cc-6c4bbec1777f.gif)
