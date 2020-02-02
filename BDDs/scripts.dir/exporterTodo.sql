CREATE USER 'exporter'@'%' IDENTIFIED BY 'Mypass' WITH MAX_USER_CONNECTIONS 3;
GRANT ALL ON todo.* TO 'exporter'@'%' IDENTIFIED BY 'Mypass';
flush privileges;