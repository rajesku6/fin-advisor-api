------------------------------------------------------------------------------

Execution Steps:
1. Checkout (https://github.com/rajesku6/fin-advisor-api.git) and Import the project in IDE (eg. STS).
2. Right click on Project, Select 'Run As' and  select 'Spring Boot App'
3. Open the URL in browser - http://localhost:8082/swagger-ui.html

------------------------------------------------------------------------------

Important Notes: 
1. Database will load automatically on server startup. 
2. System will load categories data on server startup and save it in cache.For future request, cache will serve the data.
3. Recursive method is being used to calculate custom portfolio.
4. Swagger to test the APIs.
5. CORs error handling.
6. Code reusability. 
7. JPA integrated
8. Inbuilt database, tables will be created automatically on server startup. 


------------------------------------------------------------------------------
Assumptions:

Assumed that the priority of categories level is 
Bonds > Large cap > Mid cap > Foreign > Small cap

------------------------------------------------------------------------------
APIs Details:

1. Fetch Risk All Levels - GET
Request URL: http://localhost:8082/riskLevels
[
  {
    "tolerance_level": 1,
    "bonds_share": 0,
    "large_cap_share": 0,
    "mid_cap_share": 20,
    "foreign_cap_share": 40,
    "small_cap_share": 40
  },
  {
    "tolerance_level": 2,
    "bonds_share": 0,
    "large_cap_share": 10,
    "mid_cap_share": 20,
    "foreign_cap_share": 40,
    "small_cap_share": 30
  },
  {
    "tolerance_level": 3,
    "bonds_share": 10,
    "large_cap_share": 10,
    "mid_cap_share": 20,
    "foreign_cap_share": 40,
    "small_cap_share": 20
  },
  {
    "tolerance_level": 4,
    "bonds_share": 20,
    "large_cap_share": 10,
    "mid_cap_share": 20,
    "foreign_cap_share": 40,
    "small_cap_share": 10
  },
  {
    "tolerance_level": 5,
    "bonds_share": 40,
    "large_cap_share": 20,
    "mid_cap_share": 20,
    "foreign_cap_share": 20,
    "small_cap_share": 0
  },
  {
    "tolerance_level": 6,
    "bonds_share": 30,
    "large_cap_share": 10,
    "mid_cap_share": 30,
    "foreign_cap_share": 30,
    "small_cap_share": 0
  },
  {
    "tolerance_level": 7,
    "bonds_share": 40,
    "large_cap_share": 20,
    "mid_cap_share": 30,
    "foreign_cap_share": 10,
    "small_cap_share": 0
  },
  {
    "tolerance_level": 8,
    "bonds_share": 40,
    "large_cap_share": 30,
    "mid_cap_share": 20,
    "foreign_cap_share": 10,
    "small_cap_share": 0
  },
  {
    "tolerance_level": 9,
    "bonds_share": 40,
    "large_cap_share": 40,
    "mid_cap_share": 10,
    "foreign_cap_share": 10,
    "small_cap_share": 0
  },
  {
    "tolerance_level": 10,
    "bonds_share": 50,
    "large_cap_share": 40,
    "mid_cap_share": 10,
    "foreign_cap_share": 0,
    "small_cap_share": 0
  }
]

2. Fetch Ideal Portfolio  - GET
Request URL: http://localhost:8082/getIdealPortfolio?riskToleranceScore=5&totalAmount=1000

Response:
{
  "tolerance_level": 5,
  "total_amount": 1000,
  "bonds_cal_val": 400,
  "large_cap_cal_val": 200,
  "mid_cap_cal_val": 200,
  "foreign_cap_cal_val": 200,
  "small_cap_cal_val": 0
}

3. Calculate Custom Portfolio - POST
Request URL: http://localhost:8082/calculateCustomPortfolio

Request Body: 
{
  "bonds_custom_val": 12,
  "foreign_cap_custom_val": 43,
  "large_cap_custom_val": 25,
  "mid_cap_custom_val": 33,
  "small_cap_custom_val": 22,
  "tolerance_level": 5
}


Response:
{
  "tolerance_level": 5,
  "bonds_custom_val": 12,
  "large_cap_custom_val": 25,
  "mid_cap_custom_val": 33,
  "foreign_cap_custom_val": 43,
  "small_cap_custom_val": 22,
  "bonds_diff_val": 42,
  "large_cap_diff_val": 2,
  "mid_cap_diff_val": -6,
  "foreign_cap_diff_val": -16,
  "small_cap_dif_val": -22,
  "idealPortfolioDTO": {
    "tolerance_level": 5,
    "total_amount": 135,
    "bonds_cal_val": 54,
    "large_cap_cal_val": 27,
    "mid_cap_cal_val": 27,
    "foreign_cap_cal_val": 27,
    "small_cap_cal_val": 0
  },
  "recommendedTransferList": [
    "Transfer ($22.00) from Small Cap to Small Cap.",
    "Transfer ($16.00) from Small Cap to Foreign.",
    "Transfer $4.00 from Foreign to Bonds.",
    "Transfer $2.00 from Foreign to Large Cap."
  ]
}



