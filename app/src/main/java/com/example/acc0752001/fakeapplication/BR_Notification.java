package com.example.acc0752001.fakeapplication;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;

public class BR_Notification extends BroadcastReceiver {
static int id = 7000;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String msg = intent.getStringExtra("KEY_MSG");
        Intent newintent = new Intent();
        newintent.setClass(context, NotiActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("KEY_NAME",msg);
        newintent.putExtras(bundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newintent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notify = newNotification(context, pendingIntent,
                "Hello",msg);
        NotificationManager notificationManager =(NotificationManager)context.
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id++, notify);


    }
    @SuppressLint("NewApi")
    private Notification newNotification(Context context, PendingIntent pi, String title, String msg) {
        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentTitle(title);
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pi);
        builder.setTicker(msg);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        Notification notify = builder.build();
        return notify;
    }

}
