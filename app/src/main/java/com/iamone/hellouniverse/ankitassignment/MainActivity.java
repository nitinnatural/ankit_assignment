package com.iamone.hellouniverse.ankitassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mTextEdit;
    Button mAddBtn;
    LinearLayout linearLayout;
    int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        View v = getLayoutInflater().inflate(R.layout.odd_item, null);
//
//        ViewGroup.LayoutParams lParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//        TextView newView = new TextView(this);
//        newView.setText("heelloo this is new text");
//        newView.setLayoutParams(lParams);
//        v.setLayoutParams(lParams);

        mIndex = 0;
        linearLayout = (LinearLayout) findViewById(R.id.llList);

        mTextEdit = (EditText) findViewById(R.id.etText);
        mAddBtn = (Button) findViewById(R.id.btnAdd);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCustomView(isEven(mIndex));
                ++mIndex;

            }
        });
    }

    public void createCustomView(int id){
        ViewGroup.LayoutParams lParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View v = getLayoutInflater().inflate(id, null);
        TextView txtView = (TextView) v.findViewById(R.id.tv);

        // get the text from editText View
        String text = mTextEdit.getText().toString();
        txtView.setText(text);

        v.setLayoutParams(lParams);
        linearLayout.addView(v);

    }

    public int isEven(int index){
        if((index%2) == 0){
            return R.layout.even_item;
        } else {
            return R.layout.odd_item;
        }
    }
}
