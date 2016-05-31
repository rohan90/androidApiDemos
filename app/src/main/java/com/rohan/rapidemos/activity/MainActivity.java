package com.rohan.rapidemos.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rohan.rapidemos.R;
import com.rohan.rapidemos.activity.lifecycle.SecondActivity;
import com.rohan.rapidemos.utils.Logger;

public class MainActivity extends BaseActivity {

    /**
     * Life cycle methods
     * <p/>
     * The state of an activity and its lifecyle methods are important,
     * when to attach or dettach dependencies and how to restore them based on
     * lifecycle events
     * <p/>
     * --onCreate
     * --onStart
     * --onResume                     [foreground and visible]
     * --onPause                      [ partially visible ...]
     * --onStop                       [ hidden ie background]
     * onRestart                 [ after onStop --> onRestart may happen --> onStart]
     * --onDestroy
     * <p/>
     * See the logs in Error mode [cause red is more visible o_o]
     * https://developer.android.com/training/basics/activity-lifecycle/starting.html
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.logError("inside A onCreate ");

        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.logError("inside A onStart ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.logError("inside A onStop ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.logError("inside A onPause ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.logError("inside A onResume ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.logError("inside A onRestart ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.logError("inside A onDestroy ");
    }


    /**
     * Menu items not explained now
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewActivity();
            }
        });
    }

    private void startNewActivity() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    private void showDialogForExample() {
        new AlertDialog.Builder(this)
                .setTitle("Random Dialog")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void showProgressFor(int timeInMillis) {
        showProgress();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideProgress();
            }
        }, timeInMillis);

    }

}
