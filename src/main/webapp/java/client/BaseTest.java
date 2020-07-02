package client;


import config.ConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;


public class BaseTest {
    public static ShjcApi shjcApi = new ShjcApi();
    public static String url = null;
   // public static String host = null;
    public static RestfulClient httpclient = null;
    public String excelPath = null;
    public Properties prop;
    String host= ConfigData.url;
    String Cookie=ConfigData.Cookies;



    public HashMap<String, String> headers;

//    public BaseTest() {
//        try {
////          数据流的形式读取配置文件
//        prop = new Properties();
//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
//                "/src/main/resources/config.properties");
//        prop.load(fis);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//        excelPath = prop.getProperty("testData").replace("\\", File.separator);
//        if (ShjcApi.getHost()!=null){
//            host = prop.getProperty(ShjcApi.getHost());
//        }
//
//
//    }
//    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

//    public static UtDal dal = new UtDal();
//    @Value("${my.tester}")
//    private String tester;
//    @Value("${my.random_id}")
//    private String random_id;
//    @Value("${my.build_id}")



    public void beforeTest(){

        Properties pps=new Properties();
        FileInputStream fis= null;
      //  host="http://172.19.201.40:9080/shxjc-server/";

        /**
         * 小白注释：
         *         如果设置不合适的请求头，请求结果可能会失败。最好的办法是抓包，
         *         另外此处的headers 一定放的是request headers 千万不能添加不合适的response headers ,画蛇添足了
         */
        headers=new HashMap<String,String>();
       // headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
        headers.put("Cookie",Cookie);
       // headers.put("Accept", "*/*");
       // headers.put("Connection", "Keep-Alive");
        headers.put("Content-type", "application/json;charset=utf-8");
        url=host+shjcApi.getPath();
    }
    @AfterClass
    public static void afterClass() {
        httpclient.shutDownConnection();
    }
    @BeforeClass
    public static void beforeClass() {
        httpclient = new RestfulClient();

    }

}
