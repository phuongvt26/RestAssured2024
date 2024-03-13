package RestAssured.Bai10_ReadpropertiesFile;

import org.example.helpers.PropertiesHepler;
import org.testng.annotations.Test;

public class DemoReadProperties {
    @Test
    public void testReadFile(){
        //Gọi hàm loadAllFiles trước tiên để load tất cả các file properties vào chung bộ nhớ
        PropertiesHepler.loadAllFiles();
        //gọi hàm getValue để lấy giá trị theo tên key
        System.out.println("URI: "+PropertiesHepler.getValue("URI"));
        System.out.println("USERNAME: "+PropertiesHepler.getValue("USERNAME"));
        System.out.println("PASSWORD: "+PropertiesHepler.getValue("PASSWORD"));
    }
    @Test
    public void tesstWriteValue(){
        //Trước tiên chỉ định file cần set giá trị vào
        //Dùng đường dẫn tương đối
        //Ví dụ file configs.properties
        PropertiesHepler.setFile("src/test/resources/config/configs.properties");
        //Gọi hàm setValue để gán giá trị theo key
        PropertiesHepler.setValue("author","Anh Tester");
    }
}
