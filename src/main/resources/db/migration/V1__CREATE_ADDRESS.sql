CREATE TABLE ADDRESS (
	RECORD_ID INT NOT NULL AUTO_INCREMENT,
	ALL_REGIN_PUBLIC_COMPANY VARCHAR(5) NOT NULL,
	OLD_ZIPCODE VARCHAR(5) NOT NULL,
	ZIPCODE VARCHAR(7) NOT NULL,
	PREFECTURE_NAME_KANA VARCHAR(256) NOT NULL,
	MUNICIPALITY_NAME_KANA VARCHAR(256) NOT NULL,
	TOWN_NAME_KANA VARCHAR(256) NOT NULL,
	PREFECTURE_NAME VARCHAR(256) NOT NULL,
	MUNICIPALITY_NAME VARCHAR(256) NOT NULL,
	TOWN_NAME VARCHAR(256) NOT NULL,
	PRIMARY KEY (`RECORD_ID`)
);