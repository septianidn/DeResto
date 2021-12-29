package com.example.deresto;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushNotificationService extends FirebaseMessagingService {

    public static final String CHANNEL_ID = "com.example.deresto.CH01";

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d("Xtokenfcm", s);
    }

    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();
        SendNotif(title, message);
    }

    public void SendNotif(String title, String message){
        //Toast.makeText(this, "Ini Notifikasi", Toast.LENGTH_SHORT).show();

        Intent mainIntent = new Intent(getApplicationContext(), Cart.class);

        PendingIntent mainPendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                12345,
                mainIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel =
                    new NotificationChannel(
                            CHANNEL_ID,
                            "Portal Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        Notification mynotification =
                new NotificationCompat.Builder(getApplicationContext(), "X123")
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setContentIntent(mainPendingIntent)
                        .addAction(R.drawable.ic_baseline_arrow_forward_ios_24, "Buka", mainPendingIntent)
                        .build();

        notificationManager.notify(123, mynotification);
    }


//    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
////        String title = remoteMessage.getNotification().getTitle();
////        String message = remoteMessage.getNotification().getBody();
//        ShowNotif();
//    }
//
//    public void ShowNotif(){
//        //Toast.makeText(this, "Ini Notifikasi", Toast.LENGTH_SHORT).show();
//
//        NotificationManager notificationManager = (NotificationManager)
//                getSystemService(NOTIFICATION_SERVICE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            NotificationChannel notificationChannel =
//                    new NotificationChannel(
//                            CHANNEL_ID,
//                            "Channel Notifikasi",
//                            NotificationManager.IMPORTANCE_DEFAULT);
//
//            notificationManager.createNotificationChannel(notificationChannel);
//        }
//
//        Intent cartIntent = new Intent(getApplicationContext(), Cart.class);
//
//        PendingIntent pendingCartIntent = PendingIntent.getActivity(
//                getApplicationContext(),
//                12345,
//                cartIntent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//
//        Notification mynotification =
//                new NotificationCompat.Builder(getApplicationContext(), "X123")
//                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
//                        .setContentTitle("title")
//                        .setContentText("message")
//                        .setContentIntent(pendingCartIntent)
//                        .addAction(R.drawable.ic_baseline_arrow_forward_ios_24, "Buka", pendingCartIntent)
//                        .build();
//
//        notificationManager.notify(123, mynotification);
//    }
}