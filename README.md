# EPICHUB-ENERGY-GATEWAY

This is the code repository of the EPICHUB ENERGY GATEWAY.

The ENERGY GATEWAY is part of the [EPICHUB][epichub1] project 

#Requirements

* Windows or Linux based OS
* Access to ports: 1527 (derby), 8888 (rest)

#Software base Installation
* Java version 1.7 or greater installed.  
* The environment; JAVA_HOME and PATH variables should be configured in order to make the java command available from the command line.



#ENERGY GATEWAY Installation

Windows 
* Unzip the archive /deployment/EH_Gateway-1.0.0_20160122.zip in the desired folder. 
* Rename run-openmuc.bat.winfile by removing it’s last suffix to run-openmuc.bat.  
* Execute the file run-openmuc.bat. When running the application for the first time, the firewall may ask for admin privileges in order to enable the use of different communication ports

Linux 
* Unzip the archive /deployment/EH_Gateway-1.0.0_20160122.zip in the desired folder. 
* The run-openmuc.sh file will be used in order to launch the gateway, but this file needs to be defined as executable first.  This can be done via the command line: 
```sh
chmod 755 run-openmuc.sh
```

#Configuration

Properties files : The ‘conf’ folder includes 3 different configuration files:

* config.properties : Include the properties related to the Apache Felix framework, and should NOT be modified.
* logback.xml : Include the logging configuration. It can change looging level, appenders, file location, etc…
* system.properties : Include properties used by the bundles in the gateway. Most of the file properties are related to the original openMUC bundles, but the next ones are used to configure properties of the EPIC-HUB bundles

```sh
. . .

//Different timeout and retry intervals 
epichub.driver_load_timeout=10000		//Timeout for drivers to load
epichub.connect_timeout=60000 		//Timeout for a connection
epichub.connect_retry_interval=60000		//Retry interval after a bad connection
epichub.status_check_retry_interval=2000	//Retry interval for checking a var

//Defines if the gateway should store the monitored data.
epichub.storeToDB=true

//Properties used in the plug-ins. As the default properties files, any property defined here will be accessible for all the gateway components org.openmuc.framework.driver.gdss.scenario=scn/scenario.scn epichub.generalwsntimeout=60000

//Time intervals to check the correct arrival of the data to middleware
//Period interval to check the data
epichub.check_variables_value_interval=3000000
//Threshold admitted between last data sent and checked to avoid temporal delays
epichub.check_variables_value_time_threshold=2000000

```

Database configuration 

* EpicHub Energy gateway will use a Derby database instead of the openmuc-config.xml file to store and configure drivers, devices, variables, subscriptions… 
* When running the gateway, one of the bundles will create an endpoint to connect to the Derby database. 
* The database will be accessible through jdbc:derby://localhost:1527/epichubdb. The user and password for accessing the database will be both "epichub" 
* Different SQL clients can be used to access the derby database, as long as they have jdbc support. 
* In our case "ij" has been used, the client provided along with the derby installation [Derby Database][epichub3] 
* Another alternative with a graphical user interface is [SQuirreL SQL][epichub4] 
* In order to populate the databases the use of SQL scripts is recommended, so it can be used to load specific configurations or if the database needs to be resettled. 
* Scripts should connect to the database, clear old data and write the new gateway configuration. 

```sh
Important! The database is dynamically started from one of the bundles, so the gateway NEEDS to be running in order to access it. If the gateway is stopped, the database won’t be accessible.
```


#Running

* Execute the run-openmuc launcher located in the EH_Gateway-1.0.0_20160122 folder (.sh for linux based systems and .bat or windows systems). 
* It will activate the Apache Felix server, which will load the bundles located in the /bundle folder. 
* The status of the bundles can be checked with the "lb" command. All the bundles should be in the ‘Active’ state. In order to list the available commands, use help. 

```sh
•	System  bundle: This is the main bundle, stopping it will exit the gateway.
EpicHUB - Core: Provides extra functionalities and manges the other EpicHUB bundles.
EpicHUB - Derby Management: Sets up Derby database in port 1527
•	EpicHUB - Derby Manager: manages the operations between the gateway and database
•	EpicHUB - Derby Model: Provides ORM classes for Derby database
EpicHUB Driver - XXX: Communication protocol plug-ins. 
•	EpicHUB Middleware Interfaces: Manages the interactions with the middleware.
•	EpicHUB Server: REST server launched on port 8888.
•	EpicHUB SPI: Packages the common interfaces of every epichub component
•	Logback & slf4j: Logging functionalities
•	OpenMUC bundles: Original openMUC bundles, used by EpicHUB bundles
•	Apache Felix bundles: Manage the apache felix OSGi container and provide various functionalities: shell, runtime, commands, event mangement…
•	Apache ServiceMix – derby: Connector bundle for derby support
```

* With the gateway running, use a SQL client to connect to the epichubdb database open in 1527 port. 
* In the example '/deployment/populate_db.sql' file, the connection is already included with the connect command 'jdbc:derby://localhost:1527/epichubdb', so the only instruction that is needed to be executed in "ij" is 'run populate_db.sql';

```sh
user@epichub:~EPIC_HUB/ ij
ij version 10.11
ij> run populate_db.sql;

```

#API Overview
For a detailed description of the Restful API services defined at ENERGY GATEWAY read the [User and Programmer Guide][epichub2] 

#Testing
* Execute run_openmuc shell file and check that bundles state is Active
* Check API rest home at endpoint http://localhost:8888/epichub/home and verify state of drivers, devices and variables are at state AVALIABLE and Start subscriptions if not at state STARTED (http://localhost:8888/epichub/core/sub/middleware)

#Build and Install 
* Source code is provided as java gradle projects, install Gradle before start  [Gradle User Guide][epichub5] 
* If any change at the supplied code is required, modify the java files with your java IDE 
* At command console go to folder "code" and execute the following command
```sh
gradle build

```
* The new compiled files will be generated at folder "code/build/libs"
* Copy the new generated jar files from folder "code/build/libs" to "EH_Gateway-1.0.0_20160122/bundle" folder 
* Execute again the run_openmuc command and verify that the applied changes are sucessful.


#License

EPICHUB ENERGY GATEWAY is licensed under Affero General Public License (GPL) version 3.

[epichub1]:http://www.epichub.eu/
[epichub2]:https://github.com/ik4tekniker/EPICHUB-ENERGY-GATEWAY/tree/master/documentation/EPICHUBEnergyGatewayAdministrationAndUserGuide.pdf
[epichub3]:http://db.apache.org/derby/papers/DerbyTut/ij_intro.html
[epichub4]:http://squirrel-sql.sourceforge.net/
[epichub5]:https://docs.gradle.org/current/userguide/userguide_single.html 
