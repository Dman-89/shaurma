package com.example.android.shaurma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Drawable mIcon= ContextCompat.getDrawable(this, R.drawable.roll2);
//        mIcon.mutate().setColorFilter(0xFF007F66, PorterDuff.Mode.MULTIPLY);
//
//        ImageView mImageView  = (ImageView) findViewById(R.id.roll);
//
//        mImageView.setImageDrawable(mIcon);
    }

    public void toMap (View view) {
        CharSequence buf = "Russia, Vladimir oblast, Raduzhniy, 1 block, 62/3"; // 62/3
        SpannableString spanStr = new SpannableString(buf.toString());
        spanStr.setSpan(new UnderlineSpan(), 0, spanStr.length(), 0);
        TextView tv = (TextView) findViewById(R.id.address);
        tv.setText(spanStr);

        Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+tv.getText().toString()));
        startActivity(geoIntent);
    }
}
