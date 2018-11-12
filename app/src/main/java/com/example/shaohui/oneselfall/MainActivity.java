package com.example.shaohui.oneselfall;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.bigkoo.svprogresshud.SVProgressHUD;
import com.example.shaohui.oneselfall.base.BasicActivity;
import com.example.shaohui.oneselfall.base.setbar.StatusBarUtil;
import com.example.shaohui.oneselfall.been.UserInfo;
import com.example.shaohui.oneselfall.common.clock.CountShowedClockView;
import com.example.shaohui.oneselfall.common.config.Constant;
import com.example.shaohui.oneselfall.common.config.SysConfig;
import com.example.shaohui.oneselfall.common.http.NetWorkStringRequest;
import com.example.shaohui.oneselfall.common.view.StateButton;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BasicActivity {

    @BindView(R.id.sbt_one)
    StateButton sbtOne;
    @BindView(R.id.csc_show)
    CountShowedClockView cscShow;

    private String count = "99900000";

    private SVProgressHUD mSVProgressHUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSVProgressHUD = new SVProgressHUD(this);

        StatusBarUtil.setRootViewFitsSystemWindows(this, false);

        mSVProgressHUD.showWithStatus("加载中...");

        initView();
        initData();

    }

    private void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSVProgressHUD.showSuccessWithStatus("加载完成");
                mSVProgressHUD.dismissImmediately();
            }
        }, 2000);

    }

    private void initData() {

    }

    @OnClick({R.id.sbt_one})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sbt_one:

                count = String.valueOf(Integer.valueOf(count) - 133);
                cscShow.setChangeNumber(count);
//
//                Intent ii = new Intent(this, LeftRightSlideActivity.class);
//                startActivity(ii);
//                overridePendingTransition(R.anim.out_to_left, R.anim.in_from_right);

                loginAuthentication();
                break;
        }
    }

    /**
     * 测试网络请求
     */
    public void loginAuthentication() {

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("loginMobile", "18676340124");
        paramMap.put("mobileCode", "123456");
        NetWorkStringRequest.getRequestInstance().AddNetWorkStringRequest(this, 1,
                Constant.POST_USER_LOGIN, paramMap, RequestMethod.POST, onNetWorkResponse);
    }

    //网络请求
    NetWorkStringRequest.OnNetWorkResponse onNetWorkResponse = new NetWorkStringRequest.OnNetWorkResponse() {
        @Override
        public void onSuccess(int what, Response<String> response) {
            JSONObject jsonResult = null;
            try {
                jsonResult = new JSONObject(response.get());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            switch (what) {
                case 1://登录
                    try {
                        // 如果成功
                        if (jsonResult != null && jsonResult.getString("code").equals(SysConfig.ERROR_CODE_SUCCESS)) {
                            final UserInfo loginUserInfo = JSON.parseObject(jsonResult.getJSONObject("data").getString("userInfo"), UserInfo.class);
                            if (loginUserInfo != null || !"".equals(loginUserInfo)) {//登录成功
                                showToast("请求成功");
                            } else {//登录失败
                                showToast(jsonResult.getString("info"));
                            }
                        } else {// 不成功
                            showToast(jsonResult.getString("info"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            showToast("网络错误");
        }


        @Override
        public void onResponseCodeError(int responseCode, int what, Response<String> response) {
            showToast("服务器异常");
        }
    };
}
