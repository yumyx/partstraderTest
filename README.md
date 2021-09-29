## Technical Stack

* Selenium WebDriver
* TestNG
* Extent Report
* Log4j
* Gson

### Software Installation :
* Install Java 11
* Install IntelliJ IDEA Community Edition （Optional）
* Install Maven

## If no Maven 
unzip the file
cd project folder

## Install Dependencies:
```hash
$ mvn install
```


## Running Locally:
```hash
$ npm run start
```

Visit: `http://localhost:3000/`

## Build
* Minimum 13.2G free  memory in your PC
```hash
$ npm run build
```

## Directories
```hash
├───lib          Browser Driver exe file
├───resources    test data
└───src 
    ├───pages      
    ├───Params      
    ├───test      
    ├───util        
└───test-output
    ├───log               log file
    └───extent-report
├───testng.xml
└───pom.xml
