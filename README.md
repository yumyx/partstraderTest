## Technical Stack
* Windows 10  (Not tested in Mac, Linux)
* Chrome Version 94.0.4606.61
* Selenium WebDriver 
* TestNG
* Extent Report
* Log4j
* Gson

### Software Installation :
* Install Java 11
* Install IntelliJ IDEA Community Edition （Optional）
* Install Maven （Optional）

## Run java 
```hash
unzip partstraderTest-main.zip
```
```hash
cd partstraderTest-main
```
```hash
java -jar automation-0.0.1-SNAPSHOT.jar
```

## Run in Maven:
```hash
cd partstraderTest-main
```
```hash
mvn install
```


## Directories
```hash
├───lib                    
└───resources              
    └───testShoppingCart.json    input test data
└───src 
    ├───pages      
    ├───Params      
    ├───test      
    └───util        
└───test-output
    ├───log                     log file
    └───extent-report.html      test report
├───testng.xml             
├───pom.xml
├───automation-0.0.1-SNAPSHOT.jar
├───Test_Green_Dress.OrderSummary.png       screenshot of Test_Green_Dress 
└───Test_Yellow_Dress.OrderSummary.png      screenshot of Test_Yellow_Dress