public class NotificationPayload {
    String endpoint;
    String auth;
    String icon;
    String publicKey;
    String title;
    String message;

    @Override
    public String toString() {
        return  "\nEndpoint: " + this.endpoint +
                "\nPublic Key: " + this.publicKey +
                "\nAuth: " + this.auth +
                "\nTitle: " + this.title +
                "\nMessage: " + this.message +
                "\nIcon: " + this.icon;
    }
}
