CREATE USER 'exporter'@'%' IDENTIFIED BY 'mypass' WITH MAX_USER_CONNECTIONS 3;
GRANT ALL ON todo.* TO 'exporter'@'%' IDENTIFIED BY 'mypass';
flush privileges;