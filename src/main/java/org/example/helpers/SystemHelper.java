package org.example.helpers;

import java.io.File;
 // tạo class SystemHelper để khai báo hàm getCurrentDir() để lấy đường dẫn của thư mục từ ổ đĩa.
public class SystemHelper {
    public static String getCurrentDir(){
        return System.getProperty("user.dir") + File.separator;
    }
}
