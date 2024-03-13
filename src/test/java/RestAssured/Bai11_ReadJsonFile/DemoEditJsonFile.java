package RestAssured.Bai11_ReadJsonFile;

import RestAssured.Common.BaseTest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DemoEditJsonFile extends BaseTest {
    public void testUpdateDataDataJson() {

    }

    // câpj nhật giá trị trường additionalneeds
    @Test
    public void testUpdateValueInJso01() {
        loginUser();
        Reader reader;
        String filePath = "src/test/resources/testdata/TestUpdateUser01.json";

        try {
            reader = Files.newBufferedReader(Paths.get(filePath));

            Gson gson = new Gson();
            //Convert Json file to Json Object
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            System.out.println("Original JSON: " + jsonObject);

            //Update value if exist key
            jsonObject.addProperty("additionalneeds", "Update");

            System.out.println("Modified JSON: " + jsonObject);

            //Store new Json data to new file
            File jsonFile = new File("src/test/resources/testdata/TestJsonFile01.json");
            OutputStream outputStream = new FileOutputStream(jsonFile);
            outputStream.write(gson.toJson(jsonObject).getBytes());
            outputStream.flush();

            //Close reader
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    // Cập nhật giá trị trường checkout
    public void testUpdateFileJson02() {
        loginUser();
        Reader reader;
        String filePath = "src/test/resources/testdata/TestJsonFile02.json";
        try {
            reader = Files.newBufferedReader(Paths.get(filePath));

            Gson gson = new Gson();
            //Convert Json file to Json Object
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            System.out.println("Original JSON: " + jsonObject);

            //Update value if exist key
            //hàm getAsJsonObject để tìm thuộc tính cha trước sau đó mới add thuộc tính con vào sau.
            jsonObject.getAsJsonObject("bookingdates").addProperty("checkout", "2024-04-10");
            System.out.println("Modified JSON: " + jsonObject);
            //Store new Json data to new file
            File jsonFile = new File("src/test/resources/testdata/TestJsonFile02.json");
            OutputStream outputStream = new FileOutputStream(jsonFile);
            outputStream.write(gson.toJson(jsonObject).getBytes());
            outputStream.flush();

            //Close reader
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAddNewPropertyInJson() {
        loginUser();
        Reader reader;
        String filePath = "src/test/resources/testdata/TestJsonFile01.json";
        try {
            reader = Files.newBufferedReader(Paths.get(filePath));

            Gson gson = new Gson();
            //Convert Json file to Json Object
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            System.out.println("Original JSON: " + jsonObject);

            //Add key:{object}
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("name", "Anh Tester");
            objectMap.put("age", 27);
            JsonElement jsonElement = gson.toJsonTree(objectMap);
            jsonObject.add("student", jsonElement);

            System.out.println("Modified JSON: " + jsonObject);

            //Store new Json data to old file
            File jsonFile = new File("src/test/resources/testdata/TestJsonFile01Edited.json");
            OutputStream outputStream = new FileOutputStream(jsonFile);
            outputStream.write(gson.toJson(jsonObject).getBytes());
            outputStream.flush();

            //Close reader
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRemoveUserInJson() {
        Reader reader;
        String filePath = "src/test/resources/testdata/TestRemoveProperty.json";
        try {
            reader = Files.newBufferedReader(Paths.get(filePath));

            Gson gson = new Gson();
            //Convert Json file to Json Object
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            System.out.println("Original JSON: " + jsonObject);

            jsonObject.remove("age");
            //Xác định vị trí của property cần xoá
            //Xác định vị trí của property cần xoá
            JsonObject positionObject = jsonObject
                    .get("department").getAsJsonObject()
                    .get("position").getAsJsonObject();
            //Xoá key "years" trong cấu trúc propert
            positionObject.remove("years");

            System.out.println("Modified JSON: " + jsonObject);

            //Store new Json data to new file
            File jsonFile = new File("src/test/resources/testdata/TestJsonFile02Edited.json");
            OutputStream outputStream = new FileOutputStream(jsonFile);
            outputStream.write(gson.toJson(jsonObject).getBytes());
            outputStream.flush();

            //Close reader
            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
