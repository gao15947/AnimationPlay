package com.six.animationplay.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.six.animationplay.R;
import com.six.animationplay.maintasks.MainActivity;

/**
 * Created by Administrator on 2017/3/30.
 */

public class SplashActivity extends Activity {

    private ImageView mSplashView;

    // 动画执行时间
    private static final int ANIMATION_DURATION = 2000;

    // 缩放动画的结束值
    private static final float SCALE_END = 1.15F;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashView = (ImageView) findViewById(R.id.splash_iv);
        animateImage();
    }


    /**
     * 执行欢迎页加载动画
     */
    private void animateImage() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mSplashView, "scaleX", 0.95f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mSplashView, "scaleY", 0.95f, SCALE_END);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
