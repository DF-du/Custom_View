package com.dlf.custom_view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SpinnerView extends RelativeLayout {

    private ImageView img_arrow;
    private EditText et_content;
    private ArrayList<String> list;
    private PopupWindow pw = null;

    public SpinnerView(Context context) {
        super(context);
    }

    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
        initView(context);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("数据" + i);
        }
    }

    private void initView(final Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_spinner, null);
        this.addView(view);
        img_arrow = view.findViewById(R.id.img_arrow);
        et_content = view.findViewById(R.id.et_content);
        img_arrow.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPop(context);
            }
        });
    }

    private void showPop(Context context) {
        if (pw == null) {
            pw = new PopupWindow(et_content.getWidth(), 400);
        }

        ListView listView = new ListView(context);
        listView.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = list.get(position);
                et_content.setText(s);
                et_content.setSelection(s.length());
                pw.dismiss();
            }
        });
        pw.setContentView(listView);
        pw.setBackgroundDrawable(new ColorDrawable());
        pw.setOutsideTouchable(true);
        pw.showAsDropDown(et_content);
    }
}
