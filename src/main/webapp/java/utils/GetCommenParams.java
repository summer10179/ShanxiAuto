package utils;

import org.testng.Assert;

import java.util.regex.Matcher;

public class GetCommenParams {


    SetSaveData setSaveData=new SetSaveData();

    /**
     * 取公共参数 并替换参数，处理${}
     * @param param
     * @return
     */
    protected String getCommonParam(String param) {
//        if (stringUtil.isEmpty(param)) {     //stringUtil后续进行说明
//            return "";
//        }
        Matcher m =setSaveData.replaceParamPattern.matcher(param); // 取公共参数正则
        while (m.find()) {
            String replaceKey = m.group(1);
            // 如果公共参数池中未能找到对应的值，该用例失败。
            Assert.assertNotNull(replaceKey,
                    String.format("格式化参数失败，公共参数中找不到%s。", replaceKey));
            String value;
            // 从公共参数池中获取值
            value = setSaveData.getSaveData(replaceKey);

            //如果值不为空，则将参数替换为公共参数池里读取到的value的值。
            if(null != value) {
                param = param.replace(m.group(), value);
                //如果值为空，则将参数替换为字符串“null”
            }else {
                param = param.replace(m.group(), "null");
            }
        }
        return param;
    }
}
