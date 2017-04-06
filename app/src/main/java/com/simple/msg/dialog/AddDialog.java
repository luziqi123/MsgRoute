package com.simple.msg.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.flyco.dialog.widget.base.BaseDialog;
import com.simple.msg.R;
import com.simple.msg.config.Note;
import com.simple.msg.util.Constant;

/**
 * 添加用户的Dialog
 * Created by Mr.LongFace on 2017/4/5.
 */
public class AddDialog extends BaseDialog {

    private EditText eName , ePhone , eEmail;

    private Button ok , no;

    private OnKeyDownListener mListener;

    public AddDialog(Context context , OnKeyDownListener listener) {
        super(context);
        widthScale(0.8f);
        heightScale(0.6f);
        mListener = listener;
    }

    @Override
    public View onCreateView() {
        View view = View.inflate(mContext, R.layout.dialog_add, null);
        eName = (EditText) view.findViewById(R.id.name);
        ePhone = (EditText) view.findViewById(R.id.phone);
        eEmail = (EditText) view.findViewById(R.id.email);
        ok = (Button) view.findViewById(R.id.ok);
        no = (Button) view.findViewById(R.id.no);
        return view;
    }

    @Override
    public void setUiBeforShow() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialog.this.dismiss();
                if (mListener != null)
                    mListener.onKeyDown(OnKeyDownListener.KEY_OK);
                // TODO 对话框中的内容
                String name = eName.getText().toString();
                String phone = ePhone.getText().toString();
                String email = eEmail.getText().toString();
                Note.getInstance().addUser(name , phone, email , Constant.SENT_TO_MSG);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialog.this.dismiss();
                if (mListener != null) {
                    mListener.onKeyDown(OnKeyDownListener.KEY_NO);
                }
            }
        });
    }
}
