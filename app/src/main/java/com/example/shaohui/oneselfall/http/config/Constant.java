package com.example.shaohui.oneselfall.http.config;

import static com.example.shaohui.oneselfall.http.config.SysConfig.SERVER_HOST_ADDRESS;

/**
 * 标题: 网络请求路径
 */
public class Constant {
    /**
     * ip地址
     */
    public static final String IP_ADDRESS = SERVER_HOST_ADDRESS;
    /**
     * 上传图片服务器路径 SysConfig.IP_ADDRESS = http://cwj.jingxishenghuo.cn:8081/
     */
    public static final String UPLOAD_IMAGE_SERVER_PATH = "http://mxx.91cwj.com:8081/" + "img_upload/image_upload";
    /**
     * 上传头像服务器路径
     */
//    public static final String UPLOAD_USER_ICON_SERVER_PATH = SysConfig.IP_ADDRESS + "img_upload/user_icon_upload";
    public static final String UPLOAD_USER_ICON_SERVER_PATH = "http://mxx.91cwj.com:8081/" + "img_upload/user_icon_upload";

    //-------------------------------------------登录---------------------------------------------
    //登录
    public static final String POST_USER_LOGIN = IP_ADDRESS + "/user/login";


}
