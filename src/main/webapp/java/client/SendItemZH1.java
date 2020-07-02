package client;


import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SendItemZH1 extends BaseTest {

    RestfulClient  httpclient=new RestfulClient();

    public void beforeTest() {
        shjcApi.setPath("pro/dealTakkk/getMoreInTablemx");
        //  dal.setCase_name("username");
        super.beforeTest();
    }


    public Map  LabObtainTest() throws InterruptedException, IOException {
        String json = "{\"dataList\":[{\"TOPIC_CODE\":\"ZT0007\",\"PERIOD\":\"03\",\"ORG_NO\":\"61102\",\"execInitPer\":\"61102\",\"execInitPerName\":\"陕西\",\"startTime\":\"2020-06-07 22:43:07\",\"taskType\":\"01\",\"TOPIC_NAME\":\"数据有误\",\"demandFeebackTime\":\"2020-06-14\",\"execInitOrg\":\"61102\",\"execDealClaim\":\"处理时间为220\",\"taskYm\":\"202004\",\"detDataId\":5966,\"mxorgNo\":\"614024211\"}]}";
        //将字符串格式转化为json格式
        JSONObject object = JSONObject.fromObject(json);
        //发送请求
        httpclient.PostRequest(url, json, headers);

        String response = httpclient.getResponse();


        //将响应结果转化为Json
        JSONObject resobj = JSONObject.fromObject(response);
        String appNos = resobj.getJSONObject("data").get("appNos").toString();
        String taskNo = resobj.getJSONObject("data").get("taskNo").toString();

        Map<String,String>  map=new HashMap<>();
        map.put("appNos",appNos);
        map.put("taskNo",taskNo);
        return  map;
    }

}