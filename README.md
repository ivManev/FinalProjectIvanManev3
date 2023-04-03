This Java Maven test automation project is made for training purposes using TestNG and Selenium Webdriver. It is organized using Page Object Model design pattern and Page Factory.

Several tests are prepared against the following website using Chrome browser: http://training.skillo-bg.com:4200/posts/all.

Description of the tests:

1/ LoginTest: it validates a successful login with valid credentials.

2/ LikePostWithoutLoginTest: it validates that a post cannot be liked if the user is not logged in.

3/ DislikePostWithoutLoginTest: its purpose is to validate that a post cannot be disliked if the user is not logged in.

4/ CommentPostWithoutLoginTest: it validates that a post cannot be commented if the user is not logged in.

5/ CheckUserProfileWithoutLoginTest: its purpose is to validate that the profile of another user that has made a post cannot be checked if the current user is not logged in.

6/ ModifyYourProfileTest: it validates that public info can be successfully added.  