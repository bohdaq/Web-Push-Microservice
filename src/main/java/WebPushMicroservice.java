import com.google.gson.Gson;
import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import org.apache.http.HttpResponse;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import java.security.Security;

import static spark.Spark.*;

public class WebPushMicroservice {
    public static final Logger logger = LoggerFactory.getLogger(WebPushMicroservice.class);

    public static String VAPID_PUBLIC_KEY;
    public static String VAPID_PRIVATE_KEY;
    public static String SUBJECT;
    public static PushService pushService;

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) throws Exception {

        VAPID_PUBLIC_KEY = args[0];
        VAPID_PRIVATE_KEY = args[1];
        SUBJECT = args[2];

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });

        pushService = new PushService(VAPID_PUBLIC_KEY, VAPID_PRIVATE_KEY, SUBJECT);


        post("/notify", (req, res) -> {

            NotificationPayload payload = new Gson().fromJson(req.body(), NotificationPayload.class);
            logger.info(payload.toString());

            Notification notification = new Notification(payload.endpoint, payload.publicKey, payload.auth, req.body().getBytes("UTF8"));

            HttpResponse response = pushService.send(notification);
            logger.info(response.getStatusLine().getStatusCode() + "");

            return "ok";
        });
    }
}
