package bean;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ApiConfigs {
    //设定主要的三个属性，主机访问地址（字符串），header集合（Map），参数集合（Map）
    private String rootUrl;
    Map<String,String> headersMap = new HashMap<String,String>();
    Map<String,String> paramsMap = new HashMap<String,String>();

    public String getRootUrl() {
        return rootUrl;
    }

    public Map<String, String> getHeadersMap() {
        return headersMap;
    }

    public Map<String, String> getParamsMap() {
        return paramsMap;
    }

   //定义apiConfigs的实例获取方式
    public ApiConfigs(String configXmlPath) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(configXmlPath);
        Element rootElement = document.getRootElement();
        //在rootUrl标签下获取主机访问地址
        rootUrl = rootElement.element("rootUrl").getTextTrim();
        //在headers标签下遍历header标签，然后将其存储到headersMap中
        @SuppressWarnings("unchecked")
        List<Element> headerElements = rootElement.element("headers").elements("header");
        headerElements.forEach((ele)->{
            headersMap.put(ele.attributeValue("name").trim(),ele.attributeValue("value").trim());
        });
        //在params标签下遍历param标签，然后将其存储到paramsMap中
        @SuppressWarnings("unchecked")
        List<Element> paramElements = rootElement.element("params").elements("param");
        paramElements.forEach((ele)->{
            paramsMap.put(ele.attributeValue("name").trim(), ele.attributeValue("value").trim());
        });
        //在projectName标签中获取项目名称，在log或报告中使用
//        Element project_name = rootElement.element("projectName");
//        if(project_name != null) {
//            reportUtil.setReportName(projectEle.getTextTrim());
//        }
    }
}