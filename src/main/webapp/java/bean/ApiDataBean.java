package bean;


public class ApiDataBean extends BaseBean {
    private boolean run; //是否运行
    private String desc; // 接口描述
    private String method;//访问方法
    private String url; //接口访问url

    //header的情况相对复杂，可以设置公共header，也可以针对个别请求来设定访问的header。
    private String header;
    private String body;//接口请求时的body
    private boolean contains; //是否对返回的json字符串中作包含判定（针对接口返回内容较多，不好具体制定路径的情况）
    private int status; //返回状态
    private String verify;//判定内容
    private String save; //需要保存的内容
    private String param; //接口发送需要的参数
    private int sleep; //暂停时间
    public boolean isRun() {
        return run;
    }
    public void setRun(boolean run) {
        this.run = run;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public boolean isContains() {
        return contains;
    }
    public void setContains(boolean contains) {
        this.contains = contains;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getVerify() {
        return verify;
    }
    public void setVerify(String verify) {
        this.verify = verify;
    }
    public String getSave() {
        return save;
    }
    public void setSave(String save) {
        this.save = save;
    }
    public String getParam() {
        return param;
    }
    public void setParam(String param) {
        this.param = param;
    }
    public int getSleep() {
        return sleep;
    }
    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("desc:%s,method:%s,url:%s,param:%s", this.desc,
                this.method, this.url, this.body);
    }
}