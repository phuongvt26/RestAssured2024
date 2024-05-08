package RestAssured.model.data;

import java.util.ArrayList;

public class BookPojo {
        private String name;
        private int category_id;
        private int price;
        private  String release_date;
        private ArrayList<Integer> image_ids;
        private boolean status;


    public BookPojo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setImage_ids(ArrayList<Integer> image_ids) {
        this.image_ids = image_ids;

    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
