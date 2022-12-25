Feature:validating Place API's

Scenario Outline :Verify if Place is being successfully added using AddPlaceApi
Given Add place Payload with"< name>" "<language>" "< Address >"
When user calls "AddPlaceApi" with Post http request
Then API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"

Example:
|  name  |language  |     Address      |
|AAHouse |English   |World Cross Centre|