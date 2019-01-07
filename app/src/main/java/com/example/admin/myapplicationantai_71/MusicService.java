package com.example.admin.myapplicationantai_71;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringDef;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

public class MusicService extends MediaBrowserServiceCompat {
    private static final String TAG = "MusicService";
    private PlaybackStateCompat playbackStateCompat;
    private MediaSessionCompat mediaSessionCompat;

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e(TAG, "==onCreate=====");

        mediaSessionCompat = new MediaSessionCompat(this, "fj.net");

        playbackStateCompat = new PlaybackStateCompat.Builder().setState(PlaybackStateCompat.STATE_NONE, -1, 1.0f).build();
        mediaSessionCompat.setPlaybackState(playbackStateCompat);

        mediaSessionCompat.setCallback(mediaSsionCallback);
        setSessionToken(mediaSessionCompat.getSessionToken());

    }

    MediaSessionCompat.Callback mediaSsionCallback = new MediaSessionCompat.Callback() {
        @Override
        public void onCommand(String command, Bundle extras, ResultReceiver cb) {
            super.onCommand(command, extras, cb);
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {


        Log.e(TAG, "====onGetRoot==");
        return new BrowserRoot(":main", null);
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.detach();
//        MediaDescriptionCompat description = new MediaDescriptionCompat
//                .Builder()
//                .setMediaId("mediaId")
//                .setTitle("mediaId")
//                .setSubtitle("title")
//                .build();
       List<MediaMetadataCompat> datas=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            MediaMetadataCompat build = new MediaMetadataCompat
                    .Builder()
                    .putBitmap(MediaMetadataCompat.METADATA_KEY_ART,BitmapFactory.decodeFile(""))
                    .build();

            datas.add(build);
        }
        List<MediaBrowserCompat.MediaItem> mediaItems = MediaBrowserCompat.MediaItem.fromMediaItemList(datas);

        Log.e(TAG, "====onLoadChildren=parentId=" + parentId);
        result.sendResult(mediaItems);


    }





//    static final int METADATA_TYPE_LONG = 0;
//    static final int METADATA_TYPE_TEXT = 1;
//    static final int METADATA_TYPE_BITMAP = 2;
//    static final int METADATA_TYPE_RATING = 3;
//
//  static final ArrayMap<String,Integer> MATA_KEY_TYPE;
//    /**
//     * The album title for the media.
//     */
//    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
//
//    /**
//     * The author of the media.
//     */
//    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
//    public static final String METADATA_KEY_ID = "android.media.metadata.ID";
//    static {
//        MATA_KEY_TYPE=new ArrayMap<>();
//        MATA_KEY_TYPE.put(METADATA_KEY_ALBUM,METADATA_TYPE_TEXT);
//        MATA_KEY_TYPE.put(METADATA_KEY_AUTHOR,METADATA_TYPE_TEXT);
//        MATA_KEY_TYPE.put(METADATA_KEY_ID,METADATA_TYPE_LONG);
//
//    }
//     void putBitMap(@BitmapKey String key,String value){
//
//         if (MATA_KEY_TYPE.containsKey(key)){
//
//             if (MATA_KEY_TYPE.get(key)!=METADATA_TYPE_TEXT){
//                 throw new IllegalArgumentException("The " + key
//                         + " key cannot be used to put a Bitmap");
//             }
//         }
//
//
//
//
//     }
//
//    /**
//     * @hide
//     */
//    @Documented // 表示开启Doc文档
//    @RestrictTo(LIBRARY_GROUP)
//    @StringDef({METADATA_KEY_ALBUM, METADATA_KEY_AUTHOR, METADATA_KEY_ID})
//    @Retention(RetentionPolicy.SOURCE) //表示注解所存活的时间,在运行时,而不会存在 .class 文件中
//    @Target({
//            ElementType.PARAMETER,
//            ElementType.FIELD,
//            ElementType.METHOD,
//    }) //表示注解作用范围，参数注解，成员注解，方法注解
//
//    public @interface BitmapKey {}
}
