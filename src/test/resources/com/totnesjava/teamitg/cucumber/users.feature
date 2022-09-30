#Author: ian.hunter.personal@gmail.com
#Keywords Summary : User Login Authentication

Feature: User Admin and Logging in/out
  
  This feature is about managing authorisation and authentication of users to the system.
  The customer can log in giving their credentials and be granted an authentication token for
  further access to the system.

	Background:
		Given I clear the 'users' database
		And I have 0 users
		
  ##@tag1
  Scenario: Create a new user
  
    Given I have 0 users

    When I create users
			| id   | name         | email         | password |
			| p1   | Ian          | ian@email.com | password |

		Then I have 1 users
		And User exists
			| id   | name         | email         | password |
			| p1   | Ian          | ian@email.com | password |

  Scenario: Delete a user
  
    Given I create users
			| id   | name         | email         | password |
			| p1   | Ian          | ian@email.com | password |
    And I have 1 users

		When I delete user with email 'ian@email.com'
		Then I have 0 users

	Scenario: List some users
	
		Given I create users
			| id    | name         | email           | password  |
			| id1   | User1        | user1@email.com | password1 |
			| id2   | User2        | user2@email.com | password2 |
			| id3   | User3        | user3@email.com | password3 |
			
		When I list all users
		
		Then I get users
			| id    | name         | email           | password  |
			| id1   | User1        | user1@email.com | password1 |
			| id2   | User2        | user2@email.com | password2 |
			| id3   | User3        | user3@email.com | password3 |
			

		