package com.yitouwushui.studytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.spinner)
    Spinner spinner;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    String[] mItems = {"老黑", "大黑", "月见黑", "非洲黑", "酱油黑"};
    boolean isFirst = true;
    @Bind(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("main", String.valueOf((new Date().getTime())));
                if (!isFirst) {
                    Toast.makeText(MainActivity.this, mItems[position], Toast.LENGTH_SHORT).show();
                } else {
                    isFirst = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        webView.loadData(str, "text/html; charset=UTF-8", null);
    }

    String str = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
            "    <meta name=\"renderer\" content=\"webkit\" /><!--让360默认以极速方式渲染-->\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/><!--使用最新的文档模式，所以默认在IE9下是quirks模式，太难看-->\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" />\n" +
            "    <meta name=\"keywords\" content=\"java培训,asp.net培训,javaee培训,Android培训,安卓培训,在线教育,网上学编程\" />\n" +
            "    <meta name=\"description\" content=\"如鹏网，专注于大学生就业的在线学习品牌，让你足不出户学编程，不再为高学费埋单，在线学java培训,asp.net培训,javaee培训,Android培训,安卓培训\" />\n" +
            "\n" +
            "\n" +
            "<script src=\"http://libs.baidu.com/jquery/1.9.0/jquery.min.js\"></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    //如果百度JQuery CDN加载失败，则从 bootcss cdn加载\n" +
            "    if(!window.jQuery)\n" +
            "        document.write('<script type=\"text/javascript\" src=\"http://cdn.bootcss.com/jquery/1.9.0/jquery.min.js\"><'+'/script>');\n" +
            "</script>\n" +
            "<script src=\"/staticpages/js/jquery.cookie.js\"></script>\n" +
            "<script src=\"/JS/Common.js?20160723\"></script>\n" +
            "\n" +
            "<!-- Bootstrap core CSS -->\n" +
            "<link href=\"http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
            "<script src=\"http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\n" +
            "\n" +
            "<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n" +
            "<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n" +
            "<!--[if lt IE 9]>\n" +
            "    <script src=\"http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js\"></script>\n" +
            "    <script src=\"http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js\"></script>\n" +
            "<![endif]-->\n" +
            "\n" +
            "<title>此操作需要先登录 如鹏网 </title>\n" +
            "\n" +
            "<link href=\"/css/default-head.css\" rel=\"stylesheet\" />\n" +
            "<script src=\"/JS/head-default.js\"></script>\n" +
            "    </head>\n" +
            "<body>\n" +
            "    <!--[if lt IE 9]>\n" +
            "        <div id=\"tips\" style=\"Z-INDEX: 999999; POSITION: fixed; MIN-WIDTH: 800px; LINE-HEIGHT: 30px;  HEIGHT: 30px; TOP: 0px; RIGHT: 0px; LEFT: 0px;back\">\n" +
            "            <p style=\"TEXT-ALIGN: center;COLOR: #363636;FONT-SIZE: 12px;background-color: orange;\">本网站不支持IE6/7/8，请升级到IE9以上或使用Chrome、360浏览器等。珍惜生命，远离IE 6/7/8！&nbsp;&nbsp;<a style=\"font-size:16px;text-decoration : none\" onClick=\"document.getElementById('tips').style.display = 'none';alert('为消灭IE6/7/8做一点贡献，就是为你未来的程序员生涯少加一点儿班做善事！只要不升级，我还会回来的，我就是这么倔强！');\" href=\"#\">[关闭提示]</a></p>\n" +
            "        </div>\n" +
            "    <![endif]-->\n" +
            "    <!--登陆注册部分-->    \n" +
            "    <div class=\"nav-bar container-fluid\">\n" +
            "        <div class=\"container center\">\n" +
            "            <div class=\"fr\">\n" +
            "                <ul class=\"nav-list\" id=\"ulLogin\">\n" +
            "                    <li class=\"f12\" id=\"liUserCenterAlert\" style=\"display:none;\">\n" +
            "                        <a href=\"/Users/Index\">\n" +
            "                            <span style=\"color:red\">●</span>\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li class=\"f12\" id=\"liUserName\" style=\"display:none;\">\n" +
            "                        <a href=\"/Users/Index\">\n" +
            "                            <span id=\"userName\"></span>\n" +
            "                            <!--<img id=\"avatar\" src=\"http://static.rupeng.com/static/imgs/tx.png\" class=\"tx\">-->\n" +
            "                        </a>\n" +
            "                    </li>\n" +
            "                    <li id=\"liQuit\" class=\"f12\" style=\"display:none;\"><a href=\"javascript:LoginOut();\">退出</a></li>\n" +
            "                </ul>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>    \n" +
            "    <!--主体-->\n" +
            "    <!--logo-->\n" +
            "    <div class=\"container-full logo-slogan\">\n" +
            "        <div class=\"container center logo-box\">\n" +
            "            <div class=\"fl logo\">\n" +
            "                <a href=\"/\" title=\"如鹏网\">\n" +
            "                    <img alt=\"如鹏网\" src=\"/imgs/new/logo.png\">\n" +
            "                </a>\n" +
            "            </div>\n" +
            "            <div class=\"fl slogan .mobile-hide\">\n" +
            "                <h1 class=\"f16\">专注于大学生就业的在线教育</h1>\n" +
            "            </div>\n" +
            "            <a href=\"javascript:;\" id=\"btn-menu\" class=\"btn-menu mobile-show fr\">菜单</a>\n" +
            "            <nav id=\"nav-list\" class=\"logo-nav fr\">\n" +
            "                <ul class=\"nav nav-pills\">\n" +
            "                    <li><a class=\"f16\" href=\"/index.shtml\" title=\"首页\">首页</a></li>\n" +
            "                    <li><a class=\"f16\" href=\"/News/10/165.shtml\" title=\"0元学\">“0元学”</a></li>\n" +
            "                    <li><a class=\"f16\" href=\"/News/13/list_1.shtml\" title=\"就业喜报\">就业喜报</a></li>\n" +
            "                    <li><a class=\"f16\" href=\"/aboutus.shtml\" title=\"关于如鹏\">关于如鹏</a></li>\n" +
            "                    <li><a class=\"f16\" href=\"/wholearning.shtml\" title=\"他们正在学\">他们正在学</a></li>\n" +
            "                </ul>\n" +
            "            </nav>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <!--#include file=\"/editable/topmarquee.html\"-->\n" +
            "\n" +
            "\n" +
            "<section>\n" +
            "    \n" +
            "<div class=\"jumbotron  mainContent\">\n" +
            "    <div class=\"container pmb-container \">\n" +
            "    您需要先登录，才能继续操作。<a href=\"/Login/Login\">点击此处前往登录</a>\n" +
            "    </div>\n" +
            "</div>\n" +
            "</section>\n" +
            "<div class=\"footer\">\n" +
            "    <div class=\"top container-fluid\">\n" +
            "        <div class=\"container center\">\n" +
            "            <div class=\"left-box fl\">\n" +
            "                <ul>\n" +
            "                    <li>\n" +
            "                        <a href=\"/joinus.shtml\" title=\"加入我们\">加入我们</a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a href=\"/contactus.shtml\" title=\"联系我们\">联系我们</a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a href=\"/payment.shtml\" title=\"付款方式\">付款方式</a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a href=\"/serviceterm.shtml\" title=\"服务条款\">服务条款</a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a href=\"/copyright.shtml\" title=\"版权声明\">版权声明</a>\n" +
            "                    </li>\n" +
            "                    <li>\n" +
            "                        <a href=\"/friendsLink.shtml\" title=\"友情链接\">友情链接</a>\n" +
            "                    </li>\n" +
            "                </ul>\n" +
            "                <p>\n" +
            "                    <span>热线电话：010-67877100</span>\n" +
            "                    <span>24小时热线：15910679760</span>\n" +
            "                </p>\n" +
            "            </div>\n" +
            "            <div class=\"right-box fr\">\n" +
            "                <div class=\"qr fl\">\n" +
            "                    <img src=\"/imgs/new/rqcode.png\" />\n" +
            "                    <p class=\"f14\">杨老师微信</p>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"bottom container-fluid\">\n" +
            "        <div class=\"container center\">\n" +
            "            <p class=\"f12\">®北京如鹏信息科技有限公司2008-2016 \n" +
            "            <a href=\"http://www.miitbeian.gov.cn/\" target=\"_blank\">京ICP备14048059号-2</a> \n" +
            "<script type=\"text/javascript\">var cnzz_protocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");document.write(unescape(\"%3Cspan id='cnzz_stat_icon_1045968'%3E%3C/span%3E%3Cscript src='\" + cnzz_protocol + \"s5.cnzz.com/stat.php%3Fid%3D1045968%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E\"));</script>\n" +
            "            </p>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "\n" +
            "<script src=\"/JS/Component.js\"></script>\n" +
            "\n" +
            "<!--BootStrap的Model对话框，data-backdrop=\"static\"  的意思是点击背景不关闭对话框，防止给用户带来操作麻烦-->\n" +
            "<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\" data-backdrop=\"static\">\n" +
            "    <div class=\"modal-dialog\">\n" +
            "        <div class=\"modal-content\">\n" +
            "            <div class=\"modal-header\">\n" +
            "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>\n" +
            "                <h4 class=\"modal-title\" id=\"myModalLabel\">温馨提示</h4>\n" +
            "            </div>\n" +
            "            <div class=\"modal-body\">\n" +
            "\n" +
            "            </div>\n" +
            "            <div class=\"modal-footer\">\n" +
            "                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<!--弹出窗-->\n" +
            "<div class=\"modal fade\" id=\"divModal\" tabindex=\"-1\" role=\"dialog\" data-backdrop=\"static\">\n" +
            "    <div class=\"modal-dialog\">\n" +
            "        <div class=\"modal-content\">\n" +
            "            <div class=\"modal-header\">\n" +
            "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>\n" +
            "                <h4 class=\"modal-title\" id=\"myModalTitle\"></h4>\n" +
            "            </div>\n" +
            "            <div class=\"modal-body\" id=\"divContent\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<div style=\"display:none\">\n" +
            "    <audio id=\"chatAudio\" controls=\"controls\">\n" +
            "        <source src=\"/JS/im/chat/notify.ogg\" type=\"audio/mpeg\">\n" +
            "    </audio>\n" +
            "</div>\n" +
            "\n";


}
