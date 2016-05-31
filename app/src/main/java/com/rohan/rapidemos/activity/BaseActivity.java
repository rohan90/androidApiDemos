package com.rohan.rapidemos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.rohan.rapidemos.R;
import com.rohan.rapidemos.customview.ProgressDialog;

/**
 * Created by rohan on 19/5/16.
 */
public class BaseActivity extends AppCompatActivity {

    protected final ProgressDialog progress;

    public BaseActivity() {
        progress = ProgressDialog.newInstance(R.string.dialogue_please_wait);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void toastCustom(String message, int gravity, int duration) {
        Toast toast = Toast.makeText(this, message, duration);
        toast.setGravity(gravity, 0, 0);
        toast.show();
    }

    public synchronized void showProgress() {
        if (!progress.isAdded()) {
            progress.show(getFragmentManager(), null);
        }
    }

    public synchronized void hideProgress() {
        if (progress != null && progress.getActivity() != null) {
            progress.dismissAllowingStateLoss();
        }
    }
}
