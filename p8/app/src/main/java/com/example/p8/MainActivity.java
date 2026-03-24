package com.example.p8;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    int[] mobileImages = {
            R.drawable.image1,
            R.drawable.images2,
            R.drawable.images3,
            R.drawable.images4,
            R.drawable.images5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {

        Context context;

        ImageAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return mobileImages.length;
        }

        @Override
        public Object getItem(int position) {
            return mobileImages[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView;

            if(convertView == null){
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 350));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8,8,8,8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mobileImages[position]);

            return imageView;
        }
    }
}