# UNiDAYS Discounts Challenge Placement 2019/20
This repository is my solution for the technical challenged posed by UNiDAYS for the placement year of 2019/20.

## Running the program
### Running .jar file
Inside the folder: `out/artifacts/UNiDAYS_jar/` folder is a file called `UNiDAYS.jar`. Open a command line window to the same directory and run from command line using `java -jar UNiDAYS.jar`.
### Building project
Clone the project and open IDE of choice. Make sure the `resources` folder is marked as a `resource folder` in IDE of choice. Run the `Main.java` class.

#### Exporting jar from project
##### IntelliJ
You will need to configue the bulid artifact.
1. File -> Project Structure
2. Project Settings -> Artifects (on the left side)
3. Green Plus -> Jar -> From module with dependencies...
4. Select Main.java as the Main class
5. Change the MAINFEST.MF directory from xxx/src to xxx/resources
6. Click OK

You should now be able to build the jar from Build -> Build Artifact from the menu bar. It will be located in `out/artifacts/UNiDAYS_jar/`. Details on how to run [here](#running-.jar-file).

##### Eclipse
1. Right click on the project folder -> Export
2. Make sure the resources folder is added to the output
3. Select destination

The jar should be in the destination location. Open a command line window to the same directory and run from command line using `java -jar file_name_here.jar`.

#### JUnit tests
The JUnit java file is located under `test/me/grimlock257/unidayschallenge/`. Running this requires JUnit 4 to be installed.
### Version information
Java Version: `9.0.1`

Testing Dependency: `JUnit 4`

IDE: `IntelliJ IDEA 2017.3.1 Build #IU-173.3942.27, December 11, 2017`

## Approaching the problem
### Planning
Firstly based upon the problem description, I will need to represent items and a basket of some kind. As the program is about applying discounts to the basket, I will also need to represent discounts. I will start with the following classes:
- `Item` - Represent a item (containing `name` and `price`)
- `Basket` - Represent a basket (containing list of `Item`s)
- `Discount` - Represent a discount that can be applied to a basket (containing `item` to be applied to, `price` after discount on `quantity` of products)

From the initial problem description I know that the `Basket` class will need to have methods `addToBasket` and `calculateTotalPrice`.
- `addToBasket` will add an `Item` to the basket list
- `calculateTotalPrice` will need to calculate the total item cost and delivery cost and return them in a data structure

For this data structure I will create a class called `PriceResult` which will store these two pieces of information.

### Changes along the way
While coding my solution I made some additions to my original plans. I created two additional classes:
- `FileUtils` - a class containing a method to read a file in as a `String` object
- `UserInputUtils` - a class containing a method to retrieve and validate integer user input. This is simply as  perform the this task several times and it makes sense to have it saved as a method

I created `FileUtils	` as I decided I would read the available items and discounts from two `.txt` files, `items.txt` and `discounts.txt`, the class has a method to read files in as a String object so that I can manipulate the data within them and use it in my solution.

I added a menu system to interact with the program so that users can:
- add items (**as required**)
- remove items
- view basket
- view discounts
- view calculated price (**as required**)
- empty basket

### Test-driven approach
I used JUnit 4 to perform unit testing on my code to ensure that my program works correctly. I ran the unit tests after making changes to my basket, item and discount classes to ensure that the discounts are being correctly applied to the basket. This is to make sure that the program works as expected before continuing to improve the program.

The unit tests I created mirror the provided '**Example Test Cases**' in the original repository, and each test shows how the interface can be used in a similar fashion to the '**Interface**' section in the original repository.
