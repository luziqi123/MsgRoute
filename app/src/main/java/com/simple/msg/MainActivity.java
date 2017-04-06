package com.simple.msg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.simple.msg.base.BaseActivity;
import com.simple.msg.config.Note;
import com.simple.msg.dialog.AddDialog;
import com.simple.msg.dialog.EditDialog;
import com.simple.msg.dialog.OnKeyDownListener;
import com.simple.msg.message.MsgFactory;
import com.simple.msg.message.MsgManager;
import com.simple.msg.sender.SenderOfEmail;
import com.simple.msg.util.ToastMaker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private MsgManager mMsgManager;

    Button addBtn;
    ListView userListView;
    List<User> list = new ArrayList<>();
    MyAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new SenderOfEmail().sent("" , "");
                }
            }).start();
            return;
        }
        // 初始化短信管理
        mMsgManager = MsgFactory.getMsgManager(this);
        mMsgManager.init();
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
                new AddDialog(MainActivity.this, new OnKeyDownListener() {
                    @Override
                    public void onKeyDown(int keyEvent) {
                        if (keyEvent == OnKeyDownListener.KEY_OK){
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    initData();
                                }
                            });
                        }
                    }
                }).show();
            }
        });
        userListView.setAdapter(adapter);
        userListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new EditDialog(MainActivity.this, new OnKeyDownListener() {
                    @Override
                    public void onKeyDown(int keyEvent) {
                        switch (keyEvent){
                            case OnKeyDownListener.KEY_OK:
                                ToastMaker.showLongToast("不能编辑");
                                break;
                            case OnKeyDownListener.KEY_NO:
                                Note.getInstance().deleUser(list.get(position).phoneNum);
                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        initData();
                                    }
                                });
                                break;
                        }
                    }
                }).show();
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
