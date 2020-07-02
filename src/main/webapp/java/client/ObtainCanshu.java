package client;

import org.testng.Assert;
import utils.JavaTestJDBC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ObtainCanshu extends  BaseTest{

    //发送请求获取行营结果的appno
    public String  testLabObtainTest() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        String TOPIC_CODE=null;
        String PERIOD=null;
        JavaTestJDBC javaTestJDBC=new JavaTestJDBC();

        Map rest =javaTestJDBC.ChaRu();

        //将json格式转化为map格式，使用put方法，在将map转化为json
        String json = "{\"dataList\":[{\"TOPIC_CODE\":\""+rest.get("TOPIC_CODE").toString()+"\",\"PERIOD\":\""+rest.get("PERIOD").toString()+"\",\"ORG_NO\":\"61102\",\"execInitPer\":\"61102\",\"execInitPerName\":\"陕西\",\"startTime\":\"2020-06-07 22:43:07\",\"taskType\":\"01\",\"TOPIC_NAME\":\"数据有误\",\"demandFeebackTime\":\"2020-06-14\",\"execInitOrg\":\"61102\",\"execDealClaim\":\"处理时间为220\",\"taskYm\":\"202004\",\"detDataId\":5966,\"mxorgNo\":\"614024211\"}]}";
        //发送请求
        httpclient.PostRequest(url, json, headers);

        String response = httpclient.getResponse();
        String[] strs = response.split("data");
        Map<String, String> m = new HashMap<String, String>();
        for(String s:strs){
            String[] ms = s.split("=");
            m.put(ms[0], ms[1]);
        }

       return  response;
    }
}
