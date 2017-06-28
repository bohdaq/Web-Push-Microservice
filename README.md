# Web-Push-Microservice

## To run microservice in root folder:
```
mvn compile && mvn exec:java
``` 


## To send Web Push Notification you need to send a POST request to /notify with JSON body in following format:

```
{
	"endpoint": "$endpoint",
	"publicKey": "$p256dhKey",
	"auth": "$authKey,
	"title": "$title",
	"icon": "$iconLink",
	"message": "$message"
}
```

```
POST /notify HTTP/1.1
Host: 0.0.0.0:4567

{"endpoint":"https:\/\/fcm.googleapis.com\/fcm\/send\/dVVizEHb6bU:APA91bHuHM0Bhy8nsNduGVPzRlLwjGpnp1knE8mEy_ErJn9BIcL7nkGlKctz2PO4Zzxzew3NwBHjHZRfhqQTmlGSSUV5r5lcSRQ_HbIXGW6Th3xBFrrv5CqGyIooYHg71Pfg7mWGf7Wu","auth":"Wi9maVRy4tbubXzCTOdljg==","icon":"\/public\/shop_logo\/402881575ce3234b015ce32351bf000b\/29457102-2ed0-4e11-90e9-bc69a8b39eb8.jpg","publicKey":"BJ2I814DWItGOiJTQR8x3puAZ7tUe3cngAfQumfj5pXdiSvIEZQw_19hRbp9l80VdfVcvN8nm7Y2qoWzN64AoS0=","title":"WebPushDemo","message":"Received Push Notification"}
```

:envelope: Built on Spark Java Framework and webpush-java library
