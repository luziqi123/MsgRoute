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
public class EditDialog extends BaseDialog {

    private Button ok , no;

    private OnKeyDownListener mListener;

    public EditDialog(Context context , OnKeyDownListener listener) {
        super(context);
        widthScale(0.8f);
        heightScale(0.6f);
        setCanceledOnTouchOutside(false);
        mListener = listener;
    }

    @Override
    public View onCreateView() {
        View view = View.inflate(mContext, R.layout.dialog_edit, null);
        ok = (Button) view.findViewById(R.id.ok);
        no = (Button) view.findViewById(R.id.no);
        return view;
    }

    @Override
    public void setUiBeforShow() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onKeyDown(OnKeyDownListener.KEY_OK);
                EditDialog.this.dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditDialog.this.dismiss();
                if (mListener != null) {
                    mListener.onKeyDown(OnKeyDownListener.KEY_NO);
                }
            }
        });
    }
}
