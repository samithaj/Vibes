package com.stiggpwnz.vibes.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stiggpwnz.vibes.R;
import com.stiggpwnz.vibes.vk.models.Photo;

import javax.inject.Inject;

import dagger.Lazy;

public class PhotoView extends ImageView {

    @Inject Lazy<Picasso> picassoLazy;

    public Photo photo;

    public PhotoView(Context context) {
        super(context);
    }

    public PhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void setHeight(int w) {
        getLayoutParams().height = (int) (photo.getRatio() * w);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (oldw == 0 && w > 0) {
            setHeight(w);
        }
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;

        if (photo != null) {
            setVisibility(View.VISIBLE);

            int w = getWidth();
            if (w > 0) {
                setHeight(w);
            }

            picassoLazy.get().load(photo.getUrl(w))
                    .placeholder(R.drawable.placeholder)
                    .into(this);
        } else {
            setVisibility(View.GONE);
        }
    }
}