package com.example.shaohui.oneselfall.common.http;

import android.content.Context;
import android.util.Log;

import com.example.shaohui.oneselfall.MyApplication;
import com.example.shaohui.oneselfall.common.util.DataUtil;
import com.example.shaohui.oneselfall.common.util.SignUtils;
import com.yanzhenjie.nohttp.FileBinary;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.CacheMode;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.Map;

public class NetWorkStringRequest {

    private static NetWorkStringRequest netWorkStringRequest;

    public void AddNetWorkStringRequest(final Context context, int what, final String url, Map<String, String> paramsMap, RequestMethod requestMethod, final OnNetWorkResponse onNetWorkResponse) {

        final Request<String> request = NoHttp.createStringRequest(url, requestMethod);
        //设置为带缓存的网络请求
        request.setCacheMode(CacheMode.ONLY_REQUEST_NETWORK);

        try {
            paramsMap.put("onceToken", MyApplication.getInstance().getOnceToken());
            paramsMap.put("timePoint", System.currentTimeMillis() / 1000 + "");
            String sign1 = SignUtils.createLinkString(paramsMap);
            String sign = SignUtils.createSign(sign1);
            paramsMap.put("sign", sign);
            for (String key : paramsMap.keySet()) {
                request.add(key, paramsMap.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String name : paramsMap.keySet()) {
            String value = paramsMap.get(name);
//            paramsMap.put(name, value);
            Log.d("参数:", name + "..." + value);
        }

        CallServer.getRequestInstance().add(context, what, request, new HttpListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) throws JSONException {
                int responseCode = response.getHeaders().getResponseCode();// 服务器响应码
                JSONObject jsonObject = null;

                if (responseCode == 200) {

                    jsonObject = new JSONObject(response.get());

                    if (onNetWorkResponse != null) {
                        if (!DataUtil.isSpecialEmpty(jsonObject.getString("onceToken"))) {
                            MyApplication.getInstance().setOnceToken(jsonObject.getString("onceToken"));
                        }
                        onNetWorkResponse.onSuccess(what, response);
                    }
                } else {
                    if (onNetWorkResponse != null) {
                        onNetWorkResponse.onResponseCodeError(responseCode, what, response);
                    }

                }

            }

            @Override
            public void onFailed(int what, Response<String> response) throws JSONException {
                if (onNetWorkResponse != null) {
                    onNetWorkResponse.onFailed(what, response);
                }
            }
        }, true, false);
    }


    public void AddNetWorkFileRequest(Context context, int what, String url, File binary, RequestMethod requestMethod, final OnNetWorkResponse onNetWorkResponse) {

        final Request<String> request = NoHttp.createStringRequest(url, requestMethod);
        if (request != null) {
//            BasicBinary binary = new BitmapBinary(bitmap, "userHead.jpg");// 或者：BasicBinary binary2 = new BitmapBinary(file2, null);
            request.add("image2", new FileBinary(binary));
            // 添加到请求队列
        }

        CallServer.getRequestInstance().add(context, what, request, new HttpListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) throws JSONException {
                Log.d("inparkLog", response.get());
                int responseCode = response.getHeaders().getResponseCode();// 服务器响应码

                if (responseCode == 200) {

                    if (onNetWorkResponse != null) {
//                            JSONObject jsonObject=new JSONObject(response.get());
//                            if (! DataUtil.isSpecialEmpty(jsonObject.getString("onceToken"))) {
//                                MyApplication.getInstance().setOnceToken(jsonObject.getString("onceToken"));
//                            }
                        onNetWorkResponse.onSuccess(what, response);
                    }
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) throws JSONException {
                if (onNetWorkResponse != null) {
                    onNetWorkResponse.onFailed(what, response);
                }
            }
        }, true, false);
    }

    public interface OnNetWorkResponse {

        void onSuccess(int what, Response<String> response);

        void onFailed(int what, Response<String> response);

        void onResponseCodeError(int responseCode, int what, Response<String> response);
    }

    /**
     * 请求队列.
     */
    public synchronized static NetWorkStringRequest getRequestInstance() {
        if (netWorkStringRequest == null) {
            netWorkStringRequest = new NetWorkStringRequest();
        }
        return netWorkStringRequest;
    }

    public void AddNetWorkStringRequestNos(final Context context, int what, final String url, Map<String, String> paramsMap, RequestMethod requestMethod, final OnNetWorkResponse onNetWorkResponse) {
        final Request<String> request = NoHttp.createStringRequest(url, requestMethod);
        //设置为带缓存的网络请求
        request.setCacheMode(CacheMode.ONLY_REQUEST_NETWORK);
        //加密运算

        JSONObject jsonObject = new JSONObject();
        //
        for (String key : paramsMap.keySet()) {
//            request.add(key, paramsMap.get(key));
            try {
                jsonObject.put(key, paramsMap.get(key));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        request.setDefineRequestBodyForJson(jsonObject);

        for (String name : paramsMap.keySet()) {
            String value = paramsMap.get(name);
//            paramsMap.put(name, value);
            Log.d("参数:", name + "..." + value);
        }
        CallServer.getRequestInstance().add(context, what, request, new HttpListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) throws JSONException {
//                Log.d("inparkLog", response.get());
                int responseCode = response.getHeaders().getResponseCode();// 服务器响应码
                JSONObject jsonObject = null;
                if (responseCode == 200) {
                    jsonObject = new JSONObject(response.get());
                    if (onNetWorkResponse != null) {
                        onNetWorkResponse.onSuccess(what, response);
                    }
                } else {
                    if (onNetWorkResponse != null) {
                        onNetWorkResponse.onResponseCodeError(responseCode, what, response);
                    }
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) throws JSONException {
                if (onNetWorkResponse != null) {
                    onNetWorkResponse.onFailed(what, response);
                }
            }


        }, true, false);
    }

}