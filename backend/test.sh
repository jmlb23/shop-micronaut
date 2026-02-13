
curl localhost:8080/user/login -X POST -H "Content-Type: application/json" -d '{ "username": "jmlb23", "password": "def456.." }'

curl -X GET localhost:8080/product -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJibG9nIiwic3ViIjoiam1sYjIzIiwibmJmIjoxNzcwOTc3MTgzLCJleHAiOjE3NzA5NzgwODMsImlhdCI6MTc3MDk3NzE4Mywicm9sZXMiOltdfQ.K3Usx2gYlUZ18pxeecLYaU-XKFhsox-C3Stb0XRiIVI" --verbose
