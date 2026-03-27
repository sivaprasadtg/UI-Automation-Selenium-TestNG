# Selenium TestNG Suite

## Overview
A simple TestNG-based Selenium test that performs a search on Elgigantan.se.

## How to Run
1. Ensure Java and Maven are installed.
2. Run the following command in the project root:

```
mvn test -DsuiteXmlFile=testng.xml
```

## Test Covered
- Search for a product (e.g., laptop) and verify matching results are displayed.
- Check for elements on login page.
- Add products to cart from outlet page.
