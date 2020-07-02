package cases;


import client.BaseTest;
import com.alibaba.fastjson.JSON;


import net.sf.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Data;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static client.BaseTest.shjcApi;

public class SendItemZH extends BaseTest {
    String sty=null;

    Data  datan=new Data();
    @BeforeMethod
    public void beforeTest() {
        shjcApi.setPath("pro/dealTakkk/getMoreInTablemx");
      //  dal.setCase_name("username");
        super.beforeTest();
    }

    @Test()

    public void LabObtainTest() throws InterruptedException, IOException {

        String TOPIC_CODE=null;
        String datanow=datan.dataObtain();
        String json = "{\"dataList\":[{\"TOPIC_CODE\":\"ZT0007\",\"PERIOD\":\"03\",\"ORG_NO\":\"61102\",\"execInitPer\":\"61102\",\"execInitPerName\":\"陕西\",\"startTime\":\""+datanow+"\",\"taskType\":\"01\",\"TOPIC_NAME\":\"数据有误\",\"demandFeebackTime\":\"2020-06-14\",\"execInitOrg\":\"61102\",\"execDealClaim\":\"处理时间为220\",\"taskYm\":\"202004\",\"detDataId\":5966,\"mxorgNo\":\"614024211\"}]}";
       //将字符串格式转化为json格式
        JSONObject object= JSONObject.fromObject(json);
//        Object  object1=object.getJSONObject("data").get("appNos");
//        System.out.println(object1.toString());



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
        //将响应结果转化为Json
        JSONObject resobj=JSONObject.fromObject(response);
        Object res=resobj.getJSONObject("data").get("appNos");
        sty=res.toString();
        System.out.println(sty);

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

