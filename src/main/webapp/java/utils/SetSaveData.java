package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SetSaveData {

    /**
     * 公共参数数据池（全局可用）
     */
    private static Map<String, String> saveDatas = new HashMap<String, String>();

    /**
     * 替换符，如果数据中包含“${}”则会被替换成公共参数中存储的数据
     */
    protected Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");

    /**
     * 获取公共数据池中的数据
     *
     * @param key 公共数据的key
     * @return 对应的value
     */
    protected String getSaveData(String key) {
        if ("".equals(key) || !saveDatas.containsKey(key)) {
            return null;
        } else {
            return saveDatas.get(key);
        }
    }

    protected void setSaveDatas(Map<String, String> map) {
        saveDatas.putAll(map);
    }

}