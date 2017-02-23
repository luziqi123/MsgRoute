package com.simple.msg;

import android.app.Activity;
import android.os.Bundle;
import android.text.DynamicLayout;

import com.longface.lazyui.DynamicView.DynamicView;

/**
 * Created by L on 2017/2/23.
 */

public class TestActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        DynamicView listView = (DynamicView)findViewById(R.id.listview);
//        DynamicLayout
    }
}
