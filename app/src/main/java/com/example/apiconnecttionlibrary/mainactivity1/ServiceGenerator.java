package com.example.apiconnecttionlibrary.mainactivity1;

import com.example.apiconnecttionlibrary.ApiInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <T> T createServiceFull(Class<T> serviceClass) {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }

    /**
     * Việc khởi tạo T khi sử dụng phương thức này là bị lỗi vì T không tồn tại. nó chỉ có ý nghĩa với
     * trình biên dịch kiểm soát code của người lập trình().Mọi kiểu <T> đều như nhau nó được hiểu là
     * Object tại thời điểm chạy của Java. Muốn khởi tạo đối tượng generic <T> bạn cần cung cấp cho
     * Java đối tượng Class<T>, Java sẽ tạo đối tượng <T> tại thời điểm runtime bằng Java Reflection.
     * <p>
     * Phương thức này chỉ có tác dụng kết nối retrofit mà chưa có thể ghi log cũng như là xử lý kết
     * nối mạng, bắt lỗi và exception, kiểm soát kích thước file download
     * và thời gian download file đó...vv.
     *
     * @param <T>
     * @return
     */
    public static <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
    //    public static ApiInterface createService() {
//        return retrofit.create(ApiInterface.class);
//    }
}
