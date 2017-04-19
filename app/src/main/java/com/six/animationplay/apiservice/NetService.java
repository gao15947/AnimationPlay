package com.six.animationplay.apiservice;

import com.six.animationplay.model.BangumiIndexBean;
import com.six.animationplay.model.BiliLiveIndexBean;
import com.six.animationplay.model.RecommendListBean;
import com.six.animationplay.model.SearchResultBean;
import com.six.animationplay.model.VideoDetailBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/31.
 */

public class NetService extends RetrofitService {
    //创建实现接口调用
    private static final ApiService service = getRetrofit().create(ApiService.class);
    private static final LiveApiService liveService = getBiliRetrofit().create(LiveApiService.class);

    private interface ApiService {
        @GET("recommend")
        Observable<RecommendListBean> getRecommendList();

        @GET("list")
        Observable<BangumiIndexBean> getBangumiIndex(@Query("appkey") String appKey,
                                                     @Query("order") String order,
                                                     @Query("tid") String tid,
                                                     @Query("sign") String sign);

        @GET("search")
        Observable<SearchResultBean> searchVideoByKeyWord(@Query("appkey") String appKey,
                                                          @Query("keyword") String keyword,
                                                          @Query("sign") String sign);

        @GET("view")
        Observable<VideoDetailBean> getVideoDetailById(@Query("appkey") String appkey,
                                                       @Query("id") String aid,
                                                       @Query("page") String page,
                                                       @Query("sign") String sign);
    }

    private interface LiveApiService {
        @GET("AppIndex/home?_device=android&_hwid=51e96f5f2f54d5f9&_ulv=10000&access_key=563d6046f06289cbdcb472601ce5a761&appkey=c1b107428d337928&build=410000&platform=android&scale=xxhdpi&sign=fbdcfe141853f7e2c84c4d401f6a8758")
        Observable<BiliLiveIndexBean> getBiliLiveIndex();
    }

    public static void getRecommends(Observer<RecommendListBean> observer) {
        setSubscribe(service.getRecommendList(), observer);
    }

    public static void getBiliLiveIndex(Observer<BiliLiveIndexBean> observer) {
        setSubscribe(liveService.getBiliLiveIndex(), observer);
    }

    public static void searchVideoByKeyWord(String appkey, String keyWord, String sign,
                                            Observer<SearchResultBean> observer) {
        setSubscribe(service.searchVideoByKeyWord(appkey, keyWord, sign), observer);
    }

    public static void getVideoDetailById(String appkey, String id, String page, String sign,
                                          Observer<VideoDetailBean> observer) {
        setSubscribe(service.getVideoDetailById(appkey, id, page, sign), observer);
    }

    private static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }
}
