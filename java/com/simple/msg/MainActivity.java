package com.simple.msg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.simple.msg.manager.IMsgManager;
import com.simple.msg.manager.MsgFactory;

public class MainActivity extends AppCompatActivity {

    private IMsgManager mMsgManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMsgManager = MsgFactory.getMsgManager(this);
        mMsgManager.init();
    }
}
