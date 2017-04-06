package com.simple.msg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.flyco.dialog.widget.NormalDialog;
import com.simple.msg.base.BaseActivity;
import com.simple.msg.config.Note;
import com.simple.msg.dialog.AddDialog;
import com.simple.msg.dialog.OnKeyDownListener;
import com.simple.msg.message.MsgFactory;
import com.simple.msg.message.MsgManager;
import com.simple.msg.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends BaseActivity {

    private MsgManager mMsgManager;

    Button addBtn;
    ListView userListView;
    List<User> list = new ArrayList<>();
    MyAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 初始化短信管理
        mMsgManager = MsgFactory.getMsgManager(this);
        mMsgManager.init();

        initView();

        initData();

    }

    @Override
    public int getCentent() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        // 获取用户列表
        List<User> userGroup = Note.getInstance().getUserGroup();
        list.clear();
        list.addAll(userGroup);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initView() {
        adapter = new MyAdapter();
        userListView = (ListView) findViewById(R.id.users);
        addBtn = (Button) findViewById(R.id.add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 弹出对话框 填写信息
                new AddDialog(MainActivity.this, new OnKeyDownListener() {
                    @Override
                    public void onKeyDown(int keyEvent) {
                        if (keyEvent == OnKeyDownListener.KEY_OK){
                            initData();
                        }
                    }
                }).show();
            }
        });
        userListView.setAdapter(adapter);
        userListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO 长按删除
                return true;
            }
        });
    }

    /**
     * 简陋的适配器
     */
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_user, parent, false);
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView phone = (TextView) view.findViewById(R.id.num);
            TextView email = (TextView) view.findViewById(R.id.email);
            TextView status = (TextView) view.findViewById(R.id.status);
            User user = list.get(position);
            name.setText(user.name);
            phone.setText(user.phoneNum);
            email.setText(user.email);
            status.setText(user.sendMode);
            return view;
        }
    }
}
