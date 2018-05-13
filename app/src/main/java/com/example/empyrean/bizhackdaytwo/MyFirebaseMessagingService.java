package com.example.empyrean.bizhackdaytwo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //Method To Generate Notification.
        FirebaseCloudMessageFunction("clever stadium Arsenal", remoteMessage.getNotification().getBody());

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        boolean result= Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT_WATCH&&powerManager.isInteractive()|| Build.VERSION.SDK_INT< Build.VERSION_CODES.KITKAT_WATCH&&powerManager.isScreenOn();

        if (!result){
            PowerManager.WakeLock wl = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK |PowerManager.ACQUIRE_CAUSES_WAKEUP |PowerManager.ON_AFTER_RELEASE,"MH24_SCREENLOCK");
            wl.acquire(10000);
            PowerManager.WakeLock wl_cpu = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"MH24_SCREENLOCK");
            wl_cpu.acquire(10000);
        }
    }

    // Function to Generate Push Notification After Receiving Response from Server.
    private void FirebaseCloudMessageFunction(String messageTitle, String messageBody) {

        Log.d("test4", messageTitle);
        Log.d("test5", messageBody);
        // Creating Intent.
        Intent intent = new Intent(this, MainActivity.class);

        // Device vibrate pattern.
        long[] pattern = {500,500,500,500,500};

        // Adding FLAG_ACTIVITY_CLEAR_TOP to intent.
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Creating Pending Intent object.
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0 , intent,PendingIntent.FLAG_UPDATE_CURRENT);


        // Creating URI to access the default Notification Ringtone.
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Converting drawable icon to bitmap for default notification ICON.
        Bitmap DefaultIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.stadium);

        // Building Notfication.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)

                // Adding Default Icon to Notification bar.
               .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.stadium))

                // Setting up Title.
                .setContentTitle(messageTitle)
                .setSmallIcon(R.drawable.stadium)

                // Setting the default msg coming from server into Notification.
                .setContentText(messageBody)

                .setAutoCancel(true)

                .setVibrate(pattern)

                .setSound(defaultSoundUri)

                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, builder.build());
    }
}