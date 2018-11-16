DROP DATABASE IF EXISTS Copie de ECOLE;

CREATE DATABASE IF NOT EXISTS Copie de ECOLE;
USE Copie de ECOLE;
# -----------------------------------------------------------------------------
#       TABLE : COURSE_SESSION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURSE_SESSION
 (
   ID INTEGER NOT NULL  ,
   COURSE_CODE CHAR(5) NOT NULL  ,
   LOCATION_ID INTEGER NOT NULL  ,
   START_DATE DATE NOT NULL  ,
   END_DATE DATE NOT NULL  ,
   MAX INTEGER NULL  
   , PRIMARY KEY (ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE COURSE_SESSION
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_COURSE_SESSION_COURSE
     ON COURSE_SESSION (COURSE_CODE ASC);

CREATE  INDEX I_FK_COURSE_SESSION_LOCATION
     ON COURSE_SESSION (LOCATION_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   ID INTEGER NOT NULL  ,
   LAST_NAME VARCHAR(128) NOT NULL  ,
   FIRST_NAME VARCHAR(128) NOT NULL  ,
   ADDRESSE VARCHAR(128) NOT NULL  ,
   PHONE CHAR(10) NOT NULL  ,
   EMAIL VARCHAR(128) NULL  
   , PRIMARY KEY (ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COURSE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURSE
 (
   CODE CHAR(5) NOT NULL  ,
   TITLE VARCHAR(128) NOT NULL  
   , PRIMARY KEY (CODE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : LOCATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOCATION
 (
   ID INTEGER NOT NULL  ,
   CITY VARCHAR(128) NOT NULL  
   , PRIMARY KEY (ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTICIPE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTICIPE
 (
   CLIENT_ID INTEGER NOT NULL  ,
   COURSE_SESSION_ID INTEGER NOT NULL  
   , PRIMARY KEY (CLIENT_ID,COURSE_SESSION_ID) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PARTICIPE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PARTICIPE_CLIENT
     ON PARTICIPE (CLIENT_ID ASC);

CREATE  INDEX I_FK_PARTICIPE_COURSE_SESSION
     ON PARTICIPE (COURSE_SESSION_ID ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE COURSE_SESSION 
  ADD FOREIGN KEY FK_COURSE_SESSION_COURSE (COURSE_CODE)
      REFERENCES COURSE (CODE) ;


ALTER TABLE COURSE_SESSION 
  ADD FOREIGN KEY FK_COURSE_SESSION_LOCATION (LOCATION_ID)
      REFERENCES LOCATION (ID) ;


ALTER TABLE PARTICIPE 
  ADD FOREIGN KEY FK_PARTICIPE_CLIENT (CLIENT_ID)
      REFERENCES CLIENT (ID) ;


ALTER TABLE PARTICIPE 
  ADD FOREIGN KEY FK_PARTICIPE_COURSE_SESSION (COURSE_SESSION_ID)
      REFERENCES COURSE_SESSION (ID) ;

