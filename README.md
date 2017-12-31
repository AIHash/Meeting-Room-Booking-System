# Meeting-Room-Booking-System
Meeting Room Booking System for Web Technologies

### You need a applicationDB.properties in the src/main/resources/. In it you have your own options about the database.

1. DDL mode. This is actually a shortcut for the "hibernate.hbm2ddl.auto" property. Default to "create-drop" when using an embedded database, "none" otherwise.  
- none - Disable DDL handling.
- validate - Validate the schema, make no changes to the database.
- update - Update the schema if necessary.
- create - Create the schema and destroy previous data.
- create-drop - Create and then destroy the schema at the end of the session.
###### spring.jpa.hibernate.ddl-auto=${your option}

2. the url, username and password
###### spring.datasource.url= ${your url}
###### spring.datasource.username= ${your username}
###### spring.datasource.password= ${your password}

3. the driver class name (ex: org.h2.Driver)
###### spring.datasource.driver-class-name= ${your option}
