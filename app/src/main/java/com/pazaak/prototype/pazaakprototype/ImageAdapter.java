package com.pazaak.prototype.pazaakprototype;

import android.content.Context;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {

    private Context myContext;
    private int[] myImagesIds = new int[] {R.drawable.tutorial01, R.drawable.tutorial04, R.drawable.tutorial05, R.drawable.tutorial06, R.drawable.tutorial07, R.drawable.tutorial08, R.drawable.tutorial9, R.drawable.tutorial10, R.drawable.tutorial11};

    ImageAdapter(Context context)
    {
        myContext = context;
    }

    @Override
    public int getCount() {
        return myImagesIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        ImageView imageView = new ImageView(myContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(myImagesIds[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
