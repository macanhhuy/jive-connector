Zuora Create Accounts Demo
=============================

INTRODUCTION
   This demo shows how to insert objects into Zuora and retrieve them 

HOW TO DEMO:
  1. Set the following environment variables:
  	* zuoraUsername the Zuora login username 
  	* zuoraPassword the Zuora login password
  	
  2. Run the ZuoraFunctionalTestDriver, or deploy this demo an a Mule Container. 
  	a. Create accounts passing attributes: 
  		Run the testCreateAccount test or alternatively hit 
  		http://localhost:9090/zuora-demo-create-accounts, passing as query params the account  attributes.
  		Example: http://localhost:9090/zuora-demo-create-accounts?name=...&currency=...&accountNumer=...
  	b. Get accounts: Run testSearch or hit http://localhost:9090/zuora-demo-search-accounts
 	
  
