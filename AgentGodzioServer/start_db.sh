docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=agent_godzio -p 3306:3306 -d mysql:latest