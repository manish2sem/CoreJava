package CoreJava.J_Elementry.enumConcepts;

public enum AuthenticationType {

    PASSWORD("password"),
    PUBLIC_KEY("publicKey");
    private final String value;

    AuthenticationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuthenticationType fromValue(String v) {
        for (AuthenticationType c: AuthenticationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
