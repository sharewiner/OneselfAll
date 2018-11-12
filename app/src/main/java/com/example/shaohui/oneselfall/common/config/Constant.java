package com.example.shaohui.oneselfall.common.config;

/**
 * 标题: 网络请求路径
 */
public class Constant {
    /**
     * 本地地址
     */
//    public static final String IP_ADDRESS = "http://192.168.1.97:8080/";
//    public static final String IP_ADDRESS = "http://192.168.1.70:8080/";
//    public static final String IP_ADDRESS = "http://192.168.1.42:8080/";
//    public static final String IP_ADDRESS = "http://192.168.1.73:8080/";
    /**
     * 服务器地址
     */
    public static final String IP_ADDRESS = "http://mxx.91cwj.com:8081/";
    //测试服
//    public static final String IP_ADDRESS = "http://mxx.91cwj.com:9001/";
    public static final String SERVER_HOST_ADDRESS = IP_ADDRESS + "easily_chewujiang_app";

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
    public static final String POST_USER_LOGIN = SERVER_HOST_ADDRESS + "/user/login";


}
