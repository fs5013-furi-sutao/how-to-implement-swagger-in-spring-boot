CREATE TABLE covid_19_case ( 
  id bigint NOT NULL AUTO_INCREMENT
  , name varchar(255) DEFAULT NULL
  , gender varchar(255) DEFAULT NULL
  , age int DEFAULT NULL
  , address varchar(255) DEFAULT NULL
  , city varchar(255) DEFAULT NULL
  , country varchar(255) DEFAULT NULL
  , status varchar(255) DEFAULT NULL
  , created_at date DEFAULT NULL
  , updated_at date DEFAULT NULL
  , PRIMARY KEY (id)
) ENGINE = InnoDB AUTO_INCREMENT = 0 
DEFAULT CHARSET = utf8mb4 
COLLATE = utf8mb4_0900_ai_ci
;
