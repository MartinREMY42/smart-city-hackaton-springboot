# Goal

Simple demonstration application using Spring boot 2 and aws JDK.

# Requirements

JDK 8
Maven 3

An aws account with permission on DynamoDB.

A DynamodDB table caled `Places` with following structure :
```	
municipality_Fr:String
municipality_Nl:String
Number:String
place_name_Fr:String
place_name_Nl:String
placeId:String
postalCode:String
street_Fr:String
street_Nl:String
userId:String
x:String
y:String
```

A file in `%USER_HOME%\USER_NAME\.aws\credentials` with following content :
```
[default]
aws_access_key_id = YOUR_ACCESS_KEY
aws_secret_access_key = YOUR_SECRET
```

A file in `%USER_HOME%\USER_NAME\.aws\config` with following content :
``` 
[default]
output = json
region = eu-central-1
```

# Compilation

> mvn clean install

# Run

> java -jar target/dynamodb-connection-0.1.0.jar

# Test

Go to `http://localhost:8080/places?placeId=PLACE_ID` 
