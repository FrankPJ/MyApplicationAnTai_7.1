package com.example.admin.myapplicationantai_71;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.myapplicationantai_71.inject.DaggerMainComponent;
import com.example.admin.myapplicationantai_71.inject.ToastUtils;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //    MediaBrowserCompat.ConnectionCallback callback = new MediaBrowserCompat.ConnectionCallback() {
//        private static final String TAG = "MainActivity.callback";
//
//        @Override
//        public void onConnected() {
//            Log.e(TAG, "===onConnected=====");
//            browserCompat.subscribe(":main", new MediaBrowserCompat.SubscriptionCallback() {
//                private static final String TAG = "MainActivity.callback.Subscription";
//
//                @Override
//                public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaBrowserCompat.MediaItem> children) {
//
//                    Log.e(TAG,"==parentId=="+parentId);
//                }
//
//                @Override
//                public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaBrowserCompat.MediaItem> children, @NonNull Bundle options) {
//                    super.onChildrenLoaded(parentId, children, options);
//                }
//
//                @Override
//                public void onError(@NonNull String parentId) {
//                    super.onError(parentId);
//                }
//
//                @Override
//                public void onError(@NonNull String parentId, @NonNull Bundle options) {
//                    super.onError(parentId, options);
//                }
//            });
//        }
//
//
//        @Override
//        public void onConnectionFailed() {
//            Log.e(TAG, "===onConnectionFailed=====");
//
//        }
//
//        @Override
//        public void onConnectionSuspended() {
//            Log.e(TAG, "===onConnectionSuspended=====");
//
//
//        }
//    };
//    private MediaBrowserCompat browserCompat;
//    class DobackGroud extends AsyncTask<String, Integer, String> {
//        public DobackGroud() {
//            super();
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            return ",,";
//        }
//
//
//    }

    @Override
    protected void onStart() {
        super.onStart();

//        browserCompat.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        browserCompat.disconnect();
    }

    @BindView(R.id.tv_translate_result)
    TextView tv_translate_result;
    @BindView(R.id.et_target_translate)
    EditText et_target_translate;
    @BindView(R.id.btn_commit)
    Button btn_commit;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        sp.edit().putBoolean("b", true).apply();
        ;
//
        App app = (App) getApplication();
        DaggerMainComponent.builder()
                .appComponent(app.getAppComponent())
                .build()
                .infdt(this);

        List<Integer> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list1.add("a");
        list1.add("b");
        list1.add("c");

        Observable<List<Integer>> just = Observable.just(list);
        Observable<List<String>> just1 = Observable.just(list1);
        Observable<String> just2 = Observable.just("1", "1", "1", "2", "3", "4", "5", "6", "7", "8");

        just2.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {

            }
        }).subscribeOn(AndroidSchedulers.mainThread())/*指定主线程*/

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });

//        just2.distinct()/*过滤重复数据*/
//                .subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e(TAG,"=s===="+s);
//
//            }
//        });
//        just2.throttleFirst(3, TimeUnit.SECONDS).subscribe(new Consumer<String>() {/*三秒内只第一次*/
//            @Override
//            public void accept(String s) throws Exception {
//
//            }
//        });
//        just2.buffer(2).subscribe(new Consumer<List<String>>() {/*每两个数打包在一起逐个发送*/
//            @Override
//            public void accept(List<String> strings) throws Exception {
//                Log.e(TAG,"====---------------=");
//                for (String s :
//                        strings) {
//                    Log.e(TAG,"=s===="+s);
//                }
//
//            }
//        });
//
//        just2.doOnNext(new Consumer<String>() {/*onNext前调用*/
//            @Override
//            public void accept(String s) throws Exception {
//                /*缓存数据*/
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@io.reactivex.annotations.NonNull String s) {
//
//            }
//
//            @Override
//            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//        just2.skip(3).subscribe(new Consumer<String>() {/*跳过前三个*/
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e(TAG,"=s==="+s);
//            }
//        });
//        just2.first("a").subscribe(new Consumer<String>() {/*只发送第一个*/
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e(TAG,"=s==="+s);
//            }
//        });
//        just2.takeLast(3).subscribe(new Consumer<String>() {/*取后三个*/
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e(TAG,"=s==="+s);
//            }
//        });
//
//        just2.take(3).subscribe(new Consumer<String>() {/*取前三个*/
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e(TAG,"=s==="+s);
//            }
//        });

//        just.filter(new Predicate<List<Integer>>() {/*过滤*/
//            @Override
//            public boolean test(@io.reactivex.annotations.NonNull List<Integer> integers) throws Exception {
//
//
//
//                return false;
//            }
//        });


//        just.scan(new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {/*累加*/
//            @Override
//            public List<Integer> apply(@io.reactivex.annotations.NonNull List<Integer> integers, @io.reactivex.annotations.NonNull List<Integer> integers2) throws Exception {
//                return null;
//            }
//        });
//        Observable<List<String>> zip = Observable.zip(just, just1, new BiFunction<List<Integer>, List<String>, List<String>>() {/*合并数据并对数据进行操作*/
//            @Override
//            public List<String> apply(@io.reactivex.annotations.NonNull List<Integer> integers, @io.reactivex.annotations.NonNull List<String> strings) throws Exception {
//                List<String> strings1 = new ArrayList<String>();
//                for (int i = 0; i < integers.size(); i++) {
//                    strings1.add(integers.get(i) + strings.get(i));
//                }
//
//
//                return strings1;
//            }
//        });
//        zip.subscribe(new Consumer<List<String>>() {
//            @Override
//            public void accept(List<String> strings) throws Exception {
//                for (int i = 0; i < strings.size(); i++) {
//                    Log.e(TAG,"=strings===="+strings.get(i));
//                }
//
//            }
//        });


//        Observable<? extends List<? extends Serializable>> merge = Observable.merge(just, just1);/*合并两个被观察着*/
//
//        Disposable subscribe = merge.subscribe(new Consumer<List<? extends Serializable>>() {
//            @Override
//            public void accept(List<? extends Serializable> serializables) throws Exception {
//                for (int i = 0; i < serializables.size(); i++) {
//
//                    Log.e(TAG,"======"+serializables.get(i));
//                }
//            }
//        });
//        subscribe.dispose();/*取消订阅*/
    }
//        FindViewByReflection.initBindView(this);
//        btn_commit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Editable text = et_target_translate.getText();
//                if (!TextUtils.isEmpty(text)) {
//                    startTranslate(text.toString())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribeOn(Schedulers.io())
//
//                            .subscribe(new Observer<Translation1>() {
//
//
//                                @Override
//                                public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
//
//                                }
//
//                                @Override
//                                public void onNext(@io.reactivex.annotations.NonNull Translation1 translation1) {
//                                    tv_translate_result.setText(translation1.getTranslateResult().get(0).get(0).getTgt());
//
//                                }
//
//                                @Override
//                                public void onError(@io.reactivex.annotations.NonNull Throwable e) {
//
//                                }
//
//                                @Override
//                                public void onComplete() {
//
//                                }
////                                @Override
////                                public void accept(Translation1 translation1) throws Exception {
////                                    tv_translate_result.setText(translation1.getTranslateResult().get(0).get(0).getTgt());
////                                }
//                            })
//
//                    ;
//                }
//            }
//        });
//        call.observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<Translation1>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Translation1 translation1) {
//                        Log.e(TAG, "======response======" + translation1.getTranslateResult().get(0).get(0).getTgt());
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                })
//        ;


//        call.enqueue(new Callback<Translation1>() {
//            @Override
//            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
//             Log.e(TAG,"======response======"+response.body().getTranslateResult().get(0).get(0).getTgt());
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Translation1> call, Throwable t) {
//                Log.e(TAG,"======Failue======");
//
//            }
//        });


    private Observable<Translation1> startTranslate(String Str) {
        Get get = retrofit.create(Get.class);

//        Call<Translation1> call = get.getCall("Fuck you!");
        return get.getCall(Str);
    }


    public interface Get {
        @POST(value = "translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
        @FormUrlEncoded
        Observable<Translation1> getCall(@Field("i") String s);

    }


    public static class Translation1 {

        private String type;
        private int errorCode;
        private int elapsedTime;
        private List<List<TranslateResultBean>> translateResult;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public int getElapsedTime() {
            return elapsedTime;
        }

        public void setElapsedTime(int elapsedTime) {
            this.elapsedTime = elapsedTime;
        }

        public List<List<TranslateResultBean>> getTranslateResult() {
            return translateResult;
        }

        public void setTranslateResult(List<List<TranslateResultBean>> translateResult) {
            this.translateResult = translateResult;
        }

        public static class TranslateResultBean {
            /**
             * src : merry me
             * tgt : 我快乐
             */

            public String src;
            public String tgt;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getTgt() {
                return tgt;
            }

            public void setTgt(String tgt) {
                this.tgt = tgt;
            }
        }

    }
//        Log.e(TAG, "==onCreate===mSpUtils==null====" + (mSpUtils == null));

//        mTostUtils.ShowMsg("ooodsodsd");

//        Student panjun = new Student("panjun", "24", "170", "122");
//
//        try {
//            ObjectOutputStream outputStream = new ObjectOutputStream(
//
//                    new FileOutputStream(new File(Environment.getExternalStorageDirectory() + "/serilize"))
//
//            );
//
//            outputStream.writeObject(panjun);
//            mTostUtils.ShowMsg("写入成功！！");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(Environment.getExternalStorageDirectory() + "/serilize")));
//            try {
//              Student student= (Student) objectInputStream.readObject();
//
//                Log.e(TAG,"==student=="+student.name);
//                Log.e(TAG,"==student=="+student.age);
//                Log.e(TAG,"==student=="+student.height);
//                Log.e(TAG,"==student=="+student.weight);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    static class Student implements Parcelable {
//
//
////        private static final long serialVersionUID = 630907180238371889L;
//
//        private String name = "";
//        private String age = "";
//        private String height = "";
//        private String weight = "";
//
//
//        protected Student(Parcel in) {
//
//            name = in.readString();
//            age = in.readString();
//            height = in.readString();
//            weight = in.readString();
//        }
//
//        public static final Creator<Student> CREATOR = new Creator<Student>() {
//            @Override
//            public Student createFromParcel(Parcel in) {
//                return new Student(in);
//            }
//
//            @Override
//            public Student[] newArray(int size) {
//                return new Student[size];
//            }
//        };
//
//        public Student(String name, String age, String height, String weight) {
//            this.name = name;
//            this.age = age;
//            this.height = height;
//            this.weight = weight;
//        }
//
//        @Override
//        public int describeContents() {
//            return 0;
//        }
//
//        @Override
//        public void writeToParcel(Parcel dest, int flags) {
//
//            dest.writeString(name);
//            dest.writeString(age);
//            dest.writeString(height);
//            dest.writeString(weight);
//        }
//    }

    //    @Inject
//    SpUtils mSpUtils;
    @Inject
    ToastUtils mTostUtils;


    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BindView {
        int value() default 0;
    }

    //
//
    public static class FindViewByReflection {


        public static void initBindView(@NonNull Activity activity) {

            //noinspection unchecked
            Class<Activity> activityClass = (Class<Activity>) activity.getClass();
            java.lang.reflect.Field[] fields = activityClass.getDeclaredFields();
            for (java.lang.reflect.Field f :
                    fields) {

                if (f.isAnnotationPresent(BindView.class)) {
                    BindView annotation = f.getAnnotation(BindView.class);
                    int value = annotation.value();
                    if (value != 0) {

                        f.setAccessible(true);
                        try {
                            f.set(activity, activity.findViewById(value));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

        }
//
//
    }
// abstract   class Person{
//       protected abstract void setName(@NonNull String name);
//
//   }
//
//    class Man extends Person{
//
//
//        @Override
//        protected void setName(@NonNull String name) {
//
//        }
//    }
//    private void printlnStr(String print){
//
//        Log.e(TAG,"===print==="+print);
//
//    }
//        browserCompat = new MediaBrowserCompat(this,
//                new ComponentName(this, MusicService.class),
//                callback, null);
//        FolderLoader.getFoldersWithSong(this)
//                .observeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<FolderInfo>>() {
//                    @Override
//                    public void call(List<FolderInfo> folderInfos) {
//                        Log.e(MainActivity.this.getClass().getSimpleName(),"====");
//
//                        for (int i = 0; i < folderInfos.size(); i++) {
//
//                            Log.e(MainActivity.this.getClass().getSimpleName(),
//
//                                    "==folderInfos=="+folderInfos.get(i).folderPath
//                            );
//
//                            Log.e(MainActivity.this.getClass().getSimpleName(),
//
//                                    "==folderName=="+folderInfos.get(i).folderName
//                            );
//
//                            Log.e(MainActivity.this.getClass().getSimpleName(),
//
//                                    "==songCount=="+folderInfos.get(i).songCount
//                            );
//                        }
//                    }
//                })
//
//        ;
//
//
//        SongLoader.getAllSongs(MainActivity.this)
//                .observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<Song>>() {
//                    @Override
//                    public void call(List<Song> songs) {
//
//                        for (int i = 0; i <songs.size(); i++) {
//                            Log.e(MainActivity.this.getClass().getSimpleName(),
//
//                                    "==songs.get(i).title=="+songs.get(i).title
//                            );
//                        }
//
//
//                    }
//                })
////        ;
//        MediaScanFile.scanFile(this, new String[]{"/storage/usb_storage"}, null, new MediaScannerConnection.OnScanCompletedListener() {
//            @Override
//            public void onScanCompleted(String path, Uri uri) {
//                Log.e(TAG, "=======path==" + path);
//                Log.e(TAG, "=======uri==" + uri);

//                Cursor cursor = getContentResolver().query(uri,
//                        new String[]{"_id", "title", "artist", "album", "duration", "track", "artist_id", "album_id", MediaStore.Audio.Media.DATA},
//                        MediaStore.Audio.Media.DATA + "=?", null,
//                        MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
//
//                getSongsForCursor(cursor).observeOn(Schedulers.io())
//                        .subscribeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Action1<List<Song>>() {
//                            @Override
//                            public void call(List<Song> songs) {
//                                for (int i = 0; i <songs.size(); i++) {
//                                    Log.e(MainActivity.this.getClass().getSimpleName(),
//
//                                            "==songs.get(i).title=="+songs.get(i).title
//                                    );
//                                }
//                            }
//                        })
//                ;
//    }
//        });

//        String selection = MediaStore.Audio.Media.DATA + "=?";
//        String[] selectionArgs = new String[]{"/storage/usb_storage"+ "%"};

//        SongLoader.getSongListInFolder(this, "/storage/usb_storage/").observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<Song>>() {
//                    @Override
//                    public void call(List<Song> songs) {
//                        for (int i = 0; i < songs.size(); i++) {
//                            Log.e(MainActivity.this.getClass().getSimpleName(),
//
//                                    "==songs.get(i).title==" + songs.get(i).title
//                            );
//                        }
//
//                }
//    }
//
//    )
    ;


//    private Observable<List<Song>> getSongsForCursor(final Cursor cursor) {
//        return Observable.create(new Observable.OnSubscribe<List<Song>>() {
//            @Override
//            public void call(Subscriber<? super List<Song>> subscriber) {
//                List<Song> arrayList = new ArrayList<Song>();
//                if ((cursor != null) && (cursor.moveToFirst()))
//                    do {
//                        long id = cursor.getLong(0);
//                        String title = cursor.getString(1);
//                        String artist = cursor.getString(2);
//                        String album = cursor.getString(3);
//                        int duration = cursor.getInt(4);
//                        int trackNumber = cursor.getInt(5);
//                        long artistId = cursor.getInt(6);
//                        long albumId = cursor.getLong(7);
//                        String path = cursor.getString(8);
//
//                        arrayList.add(new Song(id, albumId, artistId, title, artist, album, duration, trackNumber, path));
//                    }
//                    while (cursor.moveToNext());
//                if (cursor != null) {
//                    cursor.close();
//                }
//                subscriber.onNext(arrayList);
//                subscriber.onCompleted();
//            }
//        });
//    }
}
