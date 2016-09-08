package com.sf.rxjava.request;





/**
 * 应用的通讯相关的Url和参数封装
 */
public class Protocol {
    // 断点续传返回ok
    public static final int PROTOCOL_BREAKPOINT_OK = 206;

    private static final int CONNECTION_TIMEOUT = 10 * 1000;//连接超时

    private static final int SO_TIMEOUT = 10 * 1000;//数据传输超时

    public static final int HEARTBEAT_PORT = 8890;

    /**
     * 服务定义
     */
    public static final String WEATHER_PREFIX = "http://php.weather.sina.com.cn/xml.php?city="; // 新浪天气接口
    public static final String WEATHER_PASSWORD = "&password=DJOYnieT8234jlsK&day=0";// 请求的key及显示哪天天气
    public static final String FILE_DOWN_LOCAL = "/api/fileDownload/?ip=";//本地下载地址
    public static final String FILE_DOWN_REMOT = "&id=";//服务器下载地址

//
//    /**
//     * 数据请求调用
//     */
//    public static void requestUrlTask(Context context, String url, int num, String postParame, boolean isPost, Handler handler) {
//        NetWorkManager.init(context);
//        if (NetWorkManager.getInstance(context).isConnect()) {
//            TaskManager.getInstance().submit(new TaskRequest(context, Task.TASK_PRIORITY_HEIGHT, url, num, postParame, isPost, handler));
//        } else {
//            handler.sendEmptyMessage(Constants.REQUEST_MESSAGE_WHAT_NETWORK_NOT_CONNECTED);
//        }
//    }

    /**
     * 获取网络数据
     */
//    private static String getServiceData(HttpGet httpGet) throws ConnectTimeoutException, HttpHostConnectException, Exception {
//        HttpClient httpClient = new DefaultHttpClient();
//        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, CONNECTION_TIMEOUT);//连接时间
//        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);//数据传输时间
//        String result = null;
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//        int statusCode = httpResponse.getStatusLine().getStatusCode();
//        if (statusCode == HttpStatus.SC_OK || statusCode == Protocol.PROTOCOL_BREAKPOINT_OK) {
//            InputStream in = httpResponse.getEntity().getContent();
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            int len = -1;
//            while ((len = in.read(buff)) != -1) {
//                os.write(buff, 0, len);
//            }
//            in.close();
//            byte[] contentByteArray = os.toByteArray();
//            os.close();
//            result = new String(contentByteArray);
//        }
//        return result;
//    }
//

}