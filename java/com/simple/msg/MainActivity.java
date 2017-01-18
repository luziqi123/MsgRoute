package com.simple.msg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.simple.msg.message.MsgFactory;
import com.simple.msg.message.MsgManager;

public class MainActivity extends AppCompatActivity {

    private MsgManager mMsgManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMsgManager = MsgFactory.getMsgManager(this);
        mMsgManager.init();
    }

    public void add(View view){
        EditText viewById = (EditText) findViewById(R.id.phone);
        mMsgManager.haveNewMsg(viewById.getText().toString() , "--");
        mMsgManager.haveNewMsg(viewById.getText().toString() , "bind");
    }
}
