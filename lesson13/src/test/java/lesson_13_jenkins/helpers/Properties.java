package lesson_13_jenkins.helpers;

public class Properties {

    public static String browser() {
        return System.getProperty("browser", "edge");
    }

    public static String browserVersion() {
        return System.getProperty("browserVersion", "100");
    }

    public static String browserSize() {
        return System.getProperty("browserSize", "1920x1080");
    }

    public static String remoteUrl() {
        return System.getProperty("remoteUrl", "");
    }
}