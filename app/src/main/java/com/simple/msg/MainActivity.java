package com.simple.msg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.simple.msg.config.Note;
import com.simple.msg.message.MsgFactory;
import com.simple.msg.message.MsgManager;
import com.simple.msg.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private MsgManager mMsgManager;

    EditText numEdit;
    Button addBtn;
    ListView userListView;
    List<User> list = new ArrayList<>();
    MyAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMsgManager = MsgFactory.getMsgManager(this);
        mMsgManager.init();

        initView();

        initDate();


    }

    private void initDate() {
        List<User> userGroup = Note.getInstance().getUserGroup();
        list.clear();
        list.addAll(userGroup);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        adapter = new MyAdapter();
        userListView = (ListView) findViewById(R.id.users);
        numEdit = (EditText) findViewById(R.id.phone);
        addBtn = (Button) findViewById(R.id.add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = numEdit.getText().toString();
                Note.getInstance().addUser(s, "luziqi123@gmail.com", Constant.SENT_TO_MSG);
                List<User> userGroup = Note.getInstance().getUserGroup();
                list.clear();
                list.addAll(userGroup);
                adapter.notifyDataSetChanged();
            }
        });
        userListView.setAdapter(adapter);
    }

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
            name.setText("用户");
            phone.setText(user.phoneNum);
            email.setText(user.email);
            status.setText(user.sendMode);
            return view;
        }
    }
}
