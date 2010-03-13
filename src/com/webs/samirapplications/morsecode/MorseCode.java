package com.webs.samirapplications.morsecode;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;



public class MorseCode extends Activity
{



    private TextView mTextView;

    ;

    @Override
	protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.morse_code);


        findViewById(R.id.button).setOnClickListener(mClickListener);


        mTextView = (TextView)findViewById(R.id.text);
    }


    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {

            String text = mTextView.getText().toString();

            long[] pattern = MorseCodeConverter.pattern(text);


            Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(pattern, -1);
        }
    };
    
    public void onClick(View v) {
        switch (v.getId()) {

        case R.id.exit_button:
           finish();
           break;
           
        }

}}