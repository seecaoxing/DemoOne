package com.see.demoone;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

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


    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println();
    }
}
