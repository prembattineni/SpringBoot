INSERT INTO users(username,password,enabled) 
	       values('newuser','userpwd',true);

INSERT INTO users(username,password,enabled) 
	       values('newadmin','adminpwd',true);

INSERT INTO authorities(username,authority) 
	       values('newuser','ROLE_USER');

INSERT INTO authorities(username,authority) 
	       values('newadmin','ROLE_ADMIN');