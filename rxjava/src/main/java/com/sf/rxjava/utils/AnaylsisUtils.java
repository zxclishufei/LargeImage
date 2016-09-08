package com.sf.rxjava.utils;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.sf.rxjava.analysis.FrameBaiDuNews;
import com.sf.rxjava.analysis.FrameContentListBean;
import com.sf.rxjava.analysis.FrameImageUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shufei.li on 2016/9/7.
 */
public class AnaylsisUtils extends AsyncTask<String,String,String> {
    private FrameBaiDuNews mFrameBaiDuNews;
        @Override
        protected String doInBackground(String... params) {
            return request();
        }
        @Override
        protected void onPostExecute(String data) {
            super.onPostExecute(data);
            try {
                parseFrameContentData(data);
            } catch (Exception e) {
                System.out.println("exception:" + e.getMessage());
                e.printStackTrace();
            }
        }
    /**
     * 解析新闻数据
     * @param data
     */
    private void parseFrameContentData(String data) throws JSONException {
        if (mFrameBaiDuNews == null) {
            mFrameBaiDuNews = new FrameBaiDuNews();
        }
        JSONObject jsonObject = new JSONObject(data);
        int res_code = jsonObject.getInt("showapi_res_code");
        if (res_code != 0) {
            return;
        }
        String contentObject = jsonObject.getString("showapi_res_body");
        JSONObject jsonObject1 = new JSONObject(contentObject);
        int ret_codes = jsonObject1.getInt("ret_code");
        if (ret_codes != 0) {
            return;
        }
        String pageBean = jsonObject1.getString("pagebean");
        if (pageBean.equals("")) {
            return;
        }
        JSONObject jsonObject2 = new JSONObject(pageBean);
        String contentList = jsonObject2.getString("contentlist");
        if (contentList.equals("")) {
            return;
        }
        JSONArray jsonArray = new JSONArray(contentList);
        if(jsonArray != null && jsonArray.length() > 0){
            List<FrameContentListBean> contentLists = new ArrayList<>();
            for (int i = 0;i < jsonArray.length(); i++ ){
                contentLists.add(parserContentList(jsonArray.get(i).toString()));
            }
            mFrameBaiDuNews.setContentlist(contentLists);
        }
    }

    /**
     * 解析contentList
     * @param s
     * @return object
     */
    private FrameContentListBean parserContentList(String s) throws JSONException{
        FrameContentListBean frameContentListBean = null;
        if(!(s).equals("")){
            frameContentListBean = new FrameContentListBean();
            JSONObject jsonObject = new JSONObject(s);
            frameContentListBean.setChannelId(jsonObject.getString("channelId"));
            frameContentListBean.setChannelName(jsonObject.getString("channelName"));
            frameContentListBean.setDesc(jsonObject.getString("desc"));
            frameContentListBean.setLink(jsonObject.getString("link"));
            frameContentListBean.setTitle(jsonObject.getString("title"));
            frameContentListBean.setPubDate(jsonObject.getString("pubDate"));
            frameContentListBean.setSource(jsonObject.getString("source"));
            JSONArray imageUrls = jsonObject.getJSONArray("imageurls");
            JSONArray allList = jsonObject.getJSONArray("allList");
            Gson gson = new Gson();
            if(imageUrls.length() > 0 ){
                List<FrameImageUrl> frameImageUrlList = new ArrayList<>();
                for(int i = 0; i < imageUrls.length(); i++){
                    FrameImageUrl frameImageUrlBean = gson.fromJson(imageUrls.get(i).toString(),FrameImageUrl.class);
                    frameImageUrlList.add(frameImageUrlBean);
                }
                frameContentListBean.setImageurls(frameImageUrlList);
            }
            if(allList.length() > 0 ){
                List<Object> allListUrl = new ArrayList<>();
                for(int i = 0; i < allList.length(); i++){
                    String str = allList.get(i).toString();
                    if(str.contains("url")){
                        JSONObject jsonObject1 = new JSONObject(str);
                        FrameImageUrl  FrameImageUrlBean = gson.fromJson(jsonObject1.toString(),FrameImageUrl.class);
                        allListUrl.add(FrameImageUrlBean);
                    }else{
                        allListUrl.add(str);
                    }
                }
                frameContentListBean.setAllList(allListUrl);
            }
        }
        return frameContentListBean;
    }

    /**
     * 请求数据封装
     * @return result
     */
    public  String request() {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        String  httpUrl = "http://apis.baidu.com/showapi_open_bus/channel_news/search_news?channelId=5572a109b3cdc86cf39001db";
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url .openConnection();
            connection.setRequestMethod("GET");
            // 填入apiKey到HTTP header
            connection.setRequestProperty("apikey", "53cd6a65797fa4eb742ce8795631e02c");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
