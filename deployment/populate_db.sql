DELETE FROM EPICHUB.GATEWAY_SUBSCRIPTION_GATEWAY_VARIABLE;
DELETE FROM EPICHUB.GATEWAY_VALUE;
DELETE from EPICHUB.GATEWAY_VARIABLE;
DELETE FROM EPICHUB.GATEWAY_DEVICE;
DELETE FROM EPICHUB.GATEWAY_DRIVER;
DELETE FROM EPICHUB.GATEWAY_SUBSCRIPTION;
DELETE FROM EPICHUB.GATEWAY_SUBSCRIBER;
DELETE FROM EPICHUB.GATEWAY_HOST;


insert into EPICHUB.gateway_host(DBID,ID,URL,STATE,DESCRIPTION) VALUES (1,'urn:rixf:eu.epichub/consumer/gateway','http://localhost:5678/epichub','AVAILABLE','Demo gateway');
insert into EPICHUB.gateway_subscriber(DBID,ID,NAME,RESPONSEURL) VALUES (1,'urn:rixf:eu.epichub/consumer/middleware','Epichub Middleware','http://localhost:8080/cxf/unifiedServiceEndpoint');

insert into EPICHUB.gateway_driver(DBID,FK_GATEWAY_HOST,ID,NAME,STATE,DESCRIPTION,SUBSCRIPTIONS) VALUES (1,1,'dummy','Dummy Driver','AVAILABLE','Demo Dummy Driver',false);

insert into EPICHUB.gateway_device(DBID,FK_GATEWAY_DRIVER,ID,DESCRIPTION,STATE,TYPE,DEVICEADDRESS,INTERFACEADDRESS) VALUES (1,1,'urn:rixf:eu.epichub/devices/tekniker/dummy-device1','Sample Device for OPENMUC Dummy driver','AVAILABLE','Dummy Device','dummy/device/address/1','dummy/interface/address/1');
insert into EPICHUB.gateway_variable(DBID,FK_GATEWAY_DEVICE,ID,DESCRIPTION,PHYTYPE,DIGTYPE,UNIT,STATE,ACCESSTYPE,PATH,EXPIRATIONDATE,SAMPLINGINTERVAL,ABSOLUTEERROR,PERCENTAGEERROR) VALUES (1,1,'urn:rixf:eu.epichub/resource/variables/bec_center/VoltageChannel','Dummy Voltage','VOLTAGE','DOUBLE','V','AVAILABLE','RW','dummy/channel/address/voltage',0,5000,0,0);
insert into EPICHUB.gateway_variable(DBID,FK_GATEWAY_DEVICE,ID,DESCRIPTION,PHYTYPE,DIGTYPE,UNIT,STATE,ACCESSTYPE,PATH,EXPIRATIONDATE,SAMPLINGINTERVAL,ABSOLUTEERROR,PERCENTAGEERROR) VALUES (2,1,'urn:rixf:eu.epichub/resource/variables/bec_center/CurrentChannel','Dummy Current','CURRENT','DOUBLE','kW','AVAILABLE','RW','dummy/channel/address/current',0,5000,0,0);
insert into EPICHUB.gateway_subscription(DBID,FK_GATEWAY_SUBSCRIBER,ID,MININT,MAXINT,STATE) VALUES (1,1,'urn:rixf:eu.epichub/subscriptions/middleware',10000,120000,'STOPPED');
insert into EPICHUB.gateway_subscription_gateway_variable(FK_GATEWAY_SUBSCRIPTION,FK_GATEWAY_VARIABLE) VALUES (1,1);
insert into EPICHUB.gateway_subscription_gateway_variable(FK_GATEWAY_SUBSCRIPTION,FK_GATEWAY_VARIABLE) VALUES (1,2);