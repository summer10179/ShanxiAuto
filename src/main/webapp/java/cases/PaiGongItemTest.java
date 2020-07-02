package cases;

import client.BaseTest;
import client.SendItemZH1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaiGongItemTest  extends BaseTest {
    @BeforeMethod
    public void  befortest(){
        shjcApi.setPath("pro/dispatch/prodispatch/invoke");
        super.beforeTest();
    }
    @Test
    public void PaigongTest() throws IOException, InterruptedException {
        SendItemZH1 sendItemZH1=new SendItemZH1();
        sendItemZH1.beforeTest();
        String taskNo=sendItemZH1.LabObtainTest().get("taskNo").toString();
        String json="{\"taskNo\":\""+taskNo+"\",\"topicCode\":\"ZT0007\",\"taskCycle\":\"03\",\"taskYm\":\"202004\",\"statusNo\":\"010101\",\"statusName\":\"省稽查专责派工\",\"dispNo\":\"61102\",\"dispName\":\"陕西\",\"dispTime\":\"2020-06-23 17:56:34\",\"execDealClaim\":\"123456\",\"dataList\":[{\"issName\":[\"西安01\"],\"issNames\":[{\"issName\":\"西安01\",\"issNo\":\"61401_01\"}],\"orgName\":\"市区城东供电所\",\"orgNo\":\"614015103\",\"issNo\":[\"61401_01\"],\"issRoles\":\"ROLE_15844333180644C4Wyj5xBN\",\"cn\":1,\"exceNum\":1,\"rn\":1,\"issRoless\":[{\"issRolesName\":\"省稽查专责\",\"issRoles\":\"ROLE_1584433225792eDJKrptNCz\"},{\"issRolesName\":\"市稽查专责\",\"issRoles\":\"ROLE_15844333180644C4Wyj5xBN\"}]}],\"type\":1,\"processNo\":\"01\",\"vn\":\"1\",\"method\":\"judgeSendDispInfo\"}";
        httpclient.PostRequest(url,json,headers);
        String  str=httpclient.getResponse();
        System.out.println(str);
    }

}
