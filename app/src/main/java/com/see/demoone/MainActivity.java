package com.see.demoone;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.Settings;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class MainActivity extends Activity {
    private CustomDrawable customDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Notification notification;
        Notification.Builder builder = new Notification.Builder(getApplicationContext()).setTicker("hello word").setSmallIcon(R.mipmap.ic_launcher).setWhen(System.currentTimeMillis());
        //  notification.flags = Notification.FLAG_AUTO_CANCEL;
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification = builder.setContentIntent(pendingIntent).setContentTitle("title").setContentText("asdfasfdsa").build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification);
        //自定义Drawable
        customDrawable = new CustomDrawable();
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setBackground(customDrawable);

        //属性动画
        Button mButton = (Button) findViewById(R.id.button);
//        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.property_animator);
//        set.setTarget(mButton);
//        set.start();
//        ViewWrapper mButton = new ViewWrapper(button);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(     
                ObjectAnimator.ofFloat(mButton, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(mButton, "rotationY", 0, 180),
                ObjectAnimator.ofFloat(mButton, "rotation", 0, -90),
                ObjectAnimator.ofFloat(mButton, "translationX", 0, 90),
                ObjectAnimator.ofFloat(mButton, "translationY", 0, 90),
                ObjectAnimator.ofFloat(mButton, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(mButton, "scaleY", 1, 0.5f),
                ObjectAnimator.ofFloat(mButton, "alpha", 1, 0.25f, 1)
         //       ObjectAnimator.ofFloat(mButton,"width",500)

        );
        //  set.setTarget(imageView);
        set.setDuration(5 * 1000).start();

        LruCache<String ,Bitmap> lruCache ;

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println();
    }
    private static class ViewWrapper{
        private View mTarget;
        public ViewWrapper(View Target){
            mTarget = Target;
        }
        public int getWidth(){
            return mTarget.getLayoutParams().width;
        }
        public void setWidth(int width){
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }
}
