# VkApiTest
The test performs some actions to test the user's page

For run this test you need to write some cred for login in /resources/config.json, also in file config you may set browser (browser -> type)

TestCase:

[UI] Go to https://vk.com/
[UI] Login
[UI] Go to "My Page"
[API] Create a post with randomly generated wall text using an API request and get the post id from the response
[UI] Without refreshing the page, make sure that a post with the right text from the right user appears on the wall
[API] Edit post via API request - change text and add (upload) any picture.
[UI] Without refreshing the page, make sure that the text of the message has changed and the uploaded picture has been added (make sure that the pictures are the same)
[API] Using an API request to add a comment to a post with random text
[UI] Without refreshing the page, make sure that a comment from the correct user has been added to the desired post
[UI] Via UI to leave a like to the record.
[API] Through an API request, make sure that the post has a like from the correct user
