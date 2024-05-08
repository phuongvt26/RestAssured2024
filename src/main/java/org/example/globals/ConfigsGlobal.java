package org.example.globals;

import org.example.helpers.PropertiesHepler;

public class ConfigsGlobal {
    public static String URI = PropertiesHepler.getValue("URI");
    public static String USERNAME = PropertiesHepler.getValue("USERNAME");
    public static String PASSWORD = PropertiesHepler.getValue("PASSWORD");
    public static int PASSED_TOTAL;
    public static int FAILED_TOTAL;
}
