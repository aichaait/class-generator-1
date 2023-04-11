
CREATE TABLE  Class1 (
	ID INT PRIMARY KEY ,
	attribute1 INT ,  
	attribute2 VARCHAR(50) ,  
	attribute3 FLOAT 
);

CREATE TABLE  Class2 (
	ID INT PRIMARY KEY ,
	attribute4 INT ,  
	attribute5 VARCHAR(50) ,  
	attribute6 FLOAT 
);

CREATE TABLE  Class3 (
	ID INT PRIMARY KEY ,
	attribute1 INT ,  
	attribute2 VARCHAR(50) ,  
	attribute4 FLOAT 
);

CREATE TABLE  Class4 (
	ID INT PRIMARY KEY ,
	attribute1 INT ,  
	attribute2 VARCHAR(50) ,  
	attribute4 FLOAT 
);
CREATE TABLE AGREGATION ( 
  	 class1_ID INT ,
	 class2_ID INT ,
	 PRIMARY KEY (class1_ID,class2_ID),
 	 FOREIGN KEY (class1_ID) REFERENCES class1(ID),
	 FOREIGN KEY (class2_ID) REFERENCES class2(ID)
);
 
 ALTER TABLE class1 ADD class3_ID INT ; 

 ALTER TABLE class1 ADD FOREING KEY(class3_ID)REFERENCES class3(ID) ;

 ALTER TABLE class3 ADD class2_ID INT ; 

 ALTER TABLE class3 ADD FOREING KEY(class2_ID)REFERENCES class2(ID);CREATE TABLE AGREGATION ( 
  	 class2_ID INT ,
	 class4_ID INT ,
	 PRIMARY KEY (class2_ID,class4_ID),
 	 FOREIGN KEY (class2_ID) REFERENCES class2(ID),
	 FOREIGN KEY (class4_ID) REFERENCES class4(ID)
);
 