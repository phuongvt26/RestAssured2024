package RestAssured.Report;

import io.qameta.allure.Attachment;

public class AllureManager {
    public class Alluremanager {
        //Add text to report
        @Attachment(value = "{0}", type = "text/plain")
        public static String saveTextLog(String message) {
            return message;
        }
    }
}
