Feature: Api

Scenario: User gets the code 200 while retrieving weather from site
Given Get weather from site for city New York
Then Status_code equals 200