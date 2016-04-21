1.The file data\tomcat\config\myproject\myproject_service.properties needs to be placed at D drive or C drive on your machine
The location would be C:\data\tomcat\config\myproject\myproject_service.properties
or D:\data\tomcat\config\myproject\myproject_service.properties
logs will be stored at path
D:\data\tomcat\var\capservice\log\capservice.log
2. Please ignore the unrquired files in project.
3. MongoDb needs to be set up
4. Below are the tables which will be created in mongodb
users
movies
userlikes
userdislikes
similarity
recommendations
5. 
base url:-
http://localhost:8080/myprojectservice
6. Like service
POST
http://localhost:8080/myprojectservice/like
Sample request
{
	"requestMessageId": "M2",
	"userName": "U1",
	"userLikes": {
		"movieId":1
	}
}
Sample response
{"success":true,"errorMessage":null,"result":{}}
7. Dislike Service
POST
Sample request
http://localhost:8080/myprojectservice/dislike
{
	"requestMessageId": "M2",
	"userName": "U2",
	"userLikes": {
		"movieId":1
	}
}
Sample response
{"success":true,"errorMessage":null,"result":{}}
8. Process Recommendation service
POST
Sample request
http://localhost:8081/myprojectservice/processRecommendations

{
	"requestMessageId": "M2",
	"userName": "U2"
}
Sample response
{"success":true,"errorMessage":null,"result":{}}
9 Get recommendation service
GET
Sample request:-
http://localhost:8081/myprojectservice/recommendations/list?userName=U2
Sample response:-
{"success":true,"errorMessage":null,"result":{"recommendedMovies":[{"movieId":3}],"userName":"U2"}}
