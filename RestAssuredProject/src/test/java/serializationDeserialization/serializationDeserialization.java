package serializationDeserialization;

//import io.restassured.mapper.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

//pojo -serilization- json object-deserilization->pojo
public class serializationDeserialization {

    @Test
    void convertPojo2Json() throws JsonProcessingException {

        //created java object usng pojo class
        pojo_postrequest data=new pojo_postrequest();

        data.setName("krishant");
        data.setLocation("kop");
        data.setPhone("123453");
        String courseArr[]={"python","c"};
        data.setCourses(Arrays.toString(courseArr));

        //convert java object --> json object

        ObjectMapper objemapper =new ObjectMapper();
          String jsondata=  objemapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(data);
        System.out.println(jsondata);
    }

    @Test
    void convertJson2Pojo() throws JsonProcessingException {

        String  jasondata = "{\n" +
                "  \"name\" : \"krishanta\",\n" +
                "  \"location\" : \"kop\",\n" +
                "  \"phone\" : \"123453\",\n" +
                "  \"courses\" : \"[python, c]\"\n" +
                "}";

        //conver json data into pojo object

        ObjectMapper stuObj =new ObjectMapper();

        pojo_postrequest stu = stuObj.readValue(jasondata,pojo_postrequest.class);

        System.out.println(stu.getName());
        System.out.println(stu.getLocation());
        System.out.println(stu.getPhone());
        System.out.println(stu.getCourses());


    }
}
