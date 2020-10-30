# SoftwareEnterprises


Create your hibernate.xml.cfg file, contents should look like this:

<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration SYSTEM 
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

```
<hibernate-configuration>
	<session-factory>
	    <!-- The dialect specifies the type of database used in hibernate so that hibernate generate appropriate type of SQL statements. -->
		<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
		<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="hibernate.connection.url">jdbc:mysql://{VM ADDRESS}:3306/SoftwareEnterprises</property>
		<property name="hibernate.connection.username">{remote username}</property>
		<property name="hibernate.connection.password">{remote password}</property>
		<!-- you can create and update the table if it is not in DB. If create, it create new table everytime-->
		<property name="hibernate.hbm2ddl.auto">update</property>
		<!-- True you will see sql in console -->
		<property name="show_sql">false</property>
		<mapping class="" />
	</session-factory>
</hibernate-configuration>
```
