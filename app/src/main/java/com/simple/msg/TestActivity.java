package com.simple.msg;

import android.app.Activity;
import android.os.Bundle;

import com.longface.lazyui.DynamicView.DynamicView;
import com.longface.lazyui.DynamicView.TypeTodo;
import com.longface.lazyui.DynamicView.TypeView;

import java.util.ArrayList;

/**
 * Created by L on 2017/2/23.
 */

public class TestActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        DynamicView listView = (DynamicView)findViewById(R.id.listview);
        listView.setData(new ArrayList<TypeView>());
        listView.setItemClickable(true);
        listView.bindType(R.layout.activity_main , new TextTodo());
    }
}
