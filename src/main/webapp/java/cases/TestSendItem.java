package cases;


import client.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JavaTestJDBC;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TestSendItem extends BaseTest {
    @BeforeMethod
    public void beforeTest() {
        shjcApi.setPath("pro/dealTakkk/getMoreInTablemx");
        super.beforeTest();
    }

    @Test(priority = 1)
    public void testLabObtainTest() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        String TOPIC_CODE=null;
        String PERIOD=null;
        JavaTestJDBC javaTestJDBC=new JavaTestJDBC();

        Map rest =javaTestJDBC.ChaRu();

        //将json格式转化为map格式，使用put方法，在将map转化为json
        String json = "{\"dataList\":[{\"TOPIC_CODE\":\""+rest.get("TOPIC_CODE").toString()+"\",\"PERIOD\":\""+rest.get("PERIOD").toString()+"\",\"ORG_NO\":\"61102\",\"execInitPer\":\"61102\",\"execInitPerName\":\"陕西\",\"startTime\":\"2020-06-07 22:43:07\",\"taskType\":\"01\",\"TOPIC_NAME\":\"数据有误\",\"demandFeebackTime\":\"2020-06-14\",\"execInitOrg\":\"61102\",\"execDealClaim\":\"处理时间为220\",\"taskYm\":\"202004\",\"detDataId\":5966,\"mxorgNo\":\"614024211\"}]}";
        //发送请求
        httpclient.PostRequest(url, json, headers);

        //返回状态码以及响应结果
        int code = httpclient.getResponseCode();
        String response = httpclient.getResponse();



        //断言
        Assert.assertEquals(code,200,"响应状态码正确");
        Assert.assertTrue(response.contains("success"),"响应结果正确");
        System.out.println(response);
        System.out.println("=======参数正常");

    }
    @Test(priority = 2)
    //主题标号为空
    public void LabObtainTest1() throws InterruptedException, IOException {

        String json = "{\"dataList\":[{\"TOPIC_CODE\":\"\",\"PERIOD\":\"03\",\"ORG_NO\":\"61102\",\"execInitPer\":\"61102\",\"execInitPerName\":\"陕西\",\"startTime\":\"2020-06-07 22:43:07\",\"taskType\":\"01\",\"TOPIC_NAME\":\"数据有误\",\"demandFeebackTime\":\"2020-06-14\",\"execInitOrg\":\"61102\",\"execDealClaim\":\"处理时间为220\",\"taskYm\":\"202004\",\"detDataId\":5966,\"mxorgNo\":\"614024211\"}]}";
        //发送请求
        httpclient.PostRequest(url, json, headers);

        //返回状态码以及响应结果
        int code = httpclient.getResponseCode();
        String response = httpclient.getResponse();



        //断言
        Assert.assertEquals(code,200,"响应状态码正确");
        Assert.assertTrue(response.contains("success"),"响应结果正确");
        System.out.println(response);
        System.out.println("=======主题标号为空");
    }

    @Test(priority = 3)
    //处理信息不输入
    public void LabObtainTest2() throws InterruptedException, IOException {

        String json = "{\"dataList\":[{\"TOPIC_CODE\":\"ZT0007\",\"PERIOD\":\"03\",\"ORG_NO\":\"61102\",\"execInitPer\":\"61102\",\"execInitPerName\":\"陕西\",\"startTime\":\"2020-06-07 22:43:07\",\"taskType\":\"01\",\"TOPIC_NAME\":\"数据有误\",\"demandFeebackTime\":\"2020-06-14\",\"execInitOrg\":\"61102\",\"execDealClaim\":\"\",\"taskYm\":\"202004\",\"detDataId\":5966,\"mxorgNo\":\"614024211\"}]}";
        //发送请求
        httpclient.PostRequest(url, json, headers);

        //返回状态码以及响应结果
        int code = httpclient.getResponseCode();
        String response = httpclient.getResponse();

        //断言
        Assert.assertEquals(code,200,"响应状态码正确");
        Assert.assertTrue(response.contains("success"),"响应结果正确");
        System.out.println(response);
        System.out.println("=======处理信息为空");

    }

}

