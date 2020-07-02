package cases;

import client.SendItemZH1;

import java.io.IOException;
import java.util.Map;

public   class  Test{

    @org.testng.annotations.Test
    public void test() throws IOException, InterruptedException {

    SendItemZH1 sendItemZH1=new SendItemZH1();
    sendItemZH1.beforeTest();
    Map  maps=sendItemZH1.LabObtainTest();
    String str=maps.get("appNos").toString();
    System.out.println(str);

    }
}
