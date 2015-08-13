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

    /*
    * This method accept layoutId(R.layout) and create a new view inside the liner layout
    * */
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

    /*
    * this method will check the index for odd/even and retun the
    * layout id depending upon odd or even
    * */
    public int isEven(int index){
        if((index%2) == 0){
            return R.layout.even_item;
        } else {
            return R.layout.odd_item;
        }
    }
}
