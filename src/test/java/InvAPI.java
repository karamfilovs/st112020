import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InvAPI {
    private static final String EMAIL = "karamfilovs@gmail.com";
    private static final String PASSWORD = "123456";
    private static final String ITEMS_URL = "items";
    private static final String ITEM_URL = "item";
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    static {
        RestAssured.baseURI = "https://st2016.inv.bg";
        RestAssured.basePath = "/RESTapi";
        RestAssured.authentication = RestAssured.preemptive().basic(EMAIL, PASSWORD);
    }

    public void deleteAllItems() {
        Response response = getAllItems();
        List<String> ids = JsonPath.read(response.body().asString(), "$..id");
        ids.forEach(id -> deleteItem(id));
    }

    public Response getAllItems() {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(ITEMS_URL);
        System.out.println("============================");
        response.prettyPrint();
        return response;
    }

    public Response getItem(String id) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(ITEM_URL + "/" + id);
        System.out.println("============================");
        response.prettyPrint();
        return response;
    }

    public Response createItem(Item item){
        Response response = RestAssured
                .given()
                .body(GSON.toJson(item))
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .post(ITEM_URL);
        System.out.println("============================");
        response.prettyPrint();
        return response;
    }

    public Response deleteItem(String id) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete(ITEM_URL + "/" + id);
        System.out.println("============================");
        response.prettyPrint();
        return response;
    }



}
