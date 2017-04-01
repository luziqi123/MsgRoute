package com.simple.msg;

import android.app.Activity;
import android.os.Bundle;


/**
 * Created by L on 2017/2/23.
 */

public class TestActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
//        DynamicView listView = (DynamicView)findViewById(R.id.listview);
//        listView.setData(new ArrayList<TypeView>());
//        listView.setItemClickable(true);
//        listView.setItemAnimator();
//        listView.bindType(R.layout.activity_main , new TypeTodo());
    }
}
