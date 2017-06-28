# Web-Push-Microservice

### Configuration
In order to send notifications you need to specify VAPID public and private key as well as subject in pom.xml
To get VAPID keys, visit [link](https://web-push-codelab.appspot.com/)

Sample pom.xml
```
<vapid.public.key>BEvH8oMZ98JQ6oOHaJfhrr9SfLufhi9VJFjG5qCiD8coU0OdMhVdvOjaQNO9Y8sJjNUz8iE9ZB9t0bNnQ2f7Zlw</vapid.public.key>
<vapid.private.key>bB4C_PGUJgaFwVmdHOi8S3jpOMj_UO0GfRTvnWbHzRk</vapid.private.key>
<subject>mailto:bohdaq@gmail.com</subject>
```

### Run microservice
```
mvn compile && mvn exec:java
``` 


### To send Web Push Notification you need a POST request to /notify with JSON body in following format:

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

## Specify vapid.public.key on front end:

```
const subscribeOptions = {
  userVisibleOnly: true,
  applicationServerKey: urlBase64ToUint8Array(
	'BEvH8oMZ98JQ6oOHaJfhrr9SfLufhi9VJFjG5qCiD8coU0OdMhVdvOjaQNO9Y8sJjNUz8iE9ZB9t0bNnQ2f7Zlw'
  )
};
```

## Demo
<img src="https://github.com/bohdaq/Web-Push-Microservice/blob/master/screenshot.png?raw=true">

:envelope: Built on [Spark Java Framework](http://sparkjava.com/) and [webpush-java](https://github.com/web-push-libs/webpush-java) library
