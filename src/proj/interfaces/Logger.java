package proj.interfaces;

import java.util.Map;

public interface Logger{
    public static String TRACE = "TRACE";
    public static String DEBUG = "DEBUG";
    public static String INFO = "INFO";
    public static String WARN = "WARN";
    public static String ERROR = "ERROR";
    public static String FATAL = "FATAL";
    public void mapMessaging(Map<String, Territory> map, String level, String comment);
}
