Feature: Incident Management

Scenario: place a post request with body

Given setup the end point 
And set authentication with valid credentials
When user post the request 
Then verify the status code as 201
And verify the content type