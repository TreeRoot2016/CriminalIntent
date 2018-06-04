package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * <pre>
 *     author : tree_root
 *     e-mail : xxx@xx
 *     time   : 2018/06/04
 *     desc   :picture 工具类--图片缩略图
 *     version: 1.0
 * </pre>
 */
public class PictureUtils {

    public static Bitmap getScaleBitmap(String path, int destWidth, int destHeight){
        //Read in the dimensions of the image on disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        BitmapFactory.decodeFile(path, options);
        int srcWidth = options.outWidth;
        int srcHeight = options.outHeight;

        //Figure out how much to scale down by
        int inSampleSize = 1;
        if(srcWidth > destWidth || srcHeight > destHeight){
            float scaleWidth = srcWidth / destWidth;
            float scaleHeight = srcHeight / destHeight;
            inSampleSize = Math.round(scaleWidth > scaleHeight ? scaleWidth : scaleHeight);
        }

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;
        //Read in and create final bitmap
        return BitmapFactory.decodeFile(path, options);
    }

    public static Bitmap getScaleBitmap(String path, Activity activity){
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);

        return getScaleBitmap(path, point.x, point.y);
    }
}
