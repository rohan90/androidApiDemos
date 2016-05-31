package com.rohan.rapidemos.utils;

/**
 * Created by rohan on 19/5/16.
 */
import android.util.Log;

public class Logger {
    private static final boolean isLoggerOn = true;
    private static final String TAG = "rapidemos";

    public static void logError(String message) {
 //       if (MiscUtils.isLoggerOn())
            Log.e(TAG, message);
    }

    public static void logInfo(String message) {
 //       if (MiscUtils.isLoggerOn())
            Log.d(TAG, message);
    }
}
