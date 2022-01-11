package org.future.foodflix.RecyclerView;

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
        Bitmap bmp = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.flix1024);
        Notification.Builder builder = new Notification.Builder(context,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.flix1024).setContentTitle("Title")
                .setContentText("Notification Text")
                .setPriority(Notification.PRIORITY_MAX)
                .setLargeIcon(bmp)
                .setStyle(new Notification.BigPictureStyle().bigPicture(bmp));

    NotificationManagerCompat compat = NotificationManagerCompat.from(context);
    compat.notify(1,builder.build());

}
}


