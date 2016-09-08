package com.sf.app;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

import com.sf.largeimage.LongImageView;
import com.sf.largeimage.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class MainActivity extends Activity {

    private LongImageView mLongImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int  mScreenHeight = metric.heightPixels - 1167;
        mLongImageView = (LongImageView)findViewById(R.id.longLargeView);
        mLongImageView.setImageViewHeight(mScreenHeight);
        mLongImageView.setImage(getFileUrl());
    }
    public static boolean isSDCardAvaiable() {
        String sdStatus = Environment.getExternalStorageState();
        return sdStatus.equals(Environment.MEDIA_MOUNTED);
    }

    public String  getFileUrl(){
        String path = "";
        if(isSDCardAvaiable()){
            File sd = Environment.getExternalStorageDirectory();
            boolean w = sd.canRead();
            System.out.println(w + "+++++++++++" + sd.canWrite()+ android.os.Environment.getExternalStorageDirectory().getPath());
            path = android.os.Environment.getExternalStorageDirectory().getPath()+"/XCDDownload/images/87f95fb7-2771-48f0-8641-ef50afe31d90.jpeg";
//            path = android.os.Environment.getExternalStorageDirectory().getPath()+"/XCDDownload/images/";
            Toast.makeText(this,"path: "+ path,Toast.LENGTH_LONG).show();

        }
        return  path;
    }
    public void init(){
        getImageByReflect("b");
    }

    private void getImageByReflect(String imageName){
        ApplicationInfo appInfo = getApplicationInfo();
        int resID = getResources().getIdentifier(imageName, "drawable", appInfo.packageName);
        String str=Integer.toHexString(resID);
        try {
//            Field field = Class.forName("com.sf.app.R$drawable").getField(imageName);
            Bitmap bt = BitmapFactory.decodeResource(getResources(), resID);
            saveBitmap(bt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 保存方法 */
    public void saveBitmap(Bitmap bitmap) {
        File f = new File("/mnt/sdcard/", "a.jpeg");
//        File f = new File(path, "a.jpeg");
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("@@@@@@@@@@");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("@@@@@@@@@@");
            e.printStackTrace();
        }
    }
}
