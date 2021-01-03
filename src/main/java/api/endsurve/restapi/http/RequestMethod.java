package api.endsurve.restapi.http;

public enum RequestMethod {
    GET("GET"),
    POST("POST");

    RequestMethod(String name) {
        this.name = name;
    }

    private final String name;

    public String toString() {
        return name;
    }

}
