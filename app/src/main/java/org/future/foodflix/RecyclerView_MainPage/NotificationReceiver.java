package org.future.foodflix.RecyclerView_MainPage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;

import org.future.foodflix.R;

@RequiresApi(api = Build.VERSION_CODES.O)
public class NotificationReceiver extends BroadcastReceiver {
    public final String CHANNEL_ID = "1";
    @Override
    public void onReceive(Context context, Intent intent) {
    NotificationManager manager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
    NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"1",NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);
        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.flix1024);
        Notification.Builder builder = new Notification.Builder(context,CHANNEL_ID);
        Bitmap bitmapNull = null;
        builder .setLargeIcon(bmp)
                .setContentTitle("Off the couch, time to cook!")
                .setContentText("Browse our recipes for the most delicious food.")
                .setSmallIcon(R.drawable.flix1024)
                .setPriority(Notification.PRIORITY_MAX)
                .setStyle(new Notification.BigPictureStyle().bigPicture(bmp).bigLargeIcon(bitmapNull));

    NotificationManagerCompat compat = NotificationManagerCompat.from(context);
    compat.notify(1,builder.build());
}}