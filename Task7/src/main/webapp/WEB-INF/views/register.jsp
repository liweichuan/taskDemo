<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--//引入依赖，jstl标签库--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
         isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<title>登录成功页面</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>task14-1</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/task14.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/task14-chen.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css">

</head>

<body>
<header>
    <div class="header-top pd15">
        <div class="service">客服热线：010-594-78634</div>
        <div class="micrologo" >
            <%--                这里用来放头像  之后存在数据库        --%>
            <img src="${pageContext.request.contextPath}/static/image/picture.jpg" alt="">

            <a style="margin: 10px;white-space: nowrap;display: inline-block;font-size: 15px"   class="message-color" href="${pageContext.request.contextPath}/user/login/0">登录</a>

            <a style="margin: 10px;white-space: nowrap;display: inline-block;font-size: 15px"   class="message-color"  href="${pageContext.request.contextPath}/user/register/0">注册</a>

            <a  style="margin: 10px;white-space: nowrap;display: inline-block;font-size: 15px"  class="message-color"  href="${pageContext.request.contextPath}/user/loginOut">退出</a>
            <img src="${pageContext.request.contextPath}/static/image/task08header01.png" alt="">
            <img src="${pageContext.request.contextPath}/static/image/task08header02.png" alt="">
            <img src="${pageContext.request.contextPath}/static/image/task08header03.png" alt="">
        </div>
    </div>


    <div class="header-bottom">
        <input type="checkbox" class="header-button">


        <div class="header-nav">
            <div class="guide">
                <a href="">首页</a>
                <div class="guide1"></div>
            </div>
            <div class="guide">
                <a href="">职业</a>
                <div class="guide1"></div>
            </div>
            <div class="guide">
                <a href="">推荐</a>
                <div class="guide1"></div>
            </div>
            <div class="guide">
                <a href="">关于</a>
                <div class="guide1"></div>
            </div>
        </div>
    </div>
</header>

<center>
    <div class="container-fluid" style="font-size: 10px">
        <div class="row cb-slideshow-text-container ">
            <div class="tm-content col-xl-6 col-sm-8 col-xs-8 ml-auto section">
                <header class="mb-5"><h1>注册界面</h1></header>


                <form action="${pageContext.request.contextPath}/user/register" method="post" class="subscribe-form">
                    <div class="row form-section">
                        <table>
                            <tr>
                                <td>用户名：</td>
                                <td><label>
                                    <input type="text" name="username" />
                                </label>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td><label>
                                    <input type="password" name="password" />
                                </label>
                                </td>
                            </tr>
                            <tr>
                                <td>再次输入密码：</td>
                                <td><label>
                                    <input type="password" name="password" />
                                </label>
                                </td>
                            </tr>
                            <tr>
                                <td>验证码：</td>
                                <td><label>
                                    <input type="text" name="message" />
                                </label>
                                </td>
                                <td>
                                    <div align="center">
                                        <input type="submit" value="验证码" href="${pageContext.request.contextPath}/user/message" style="color:#BC8F8F">
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="2">
                                    <br>
                                    <div align="center">
                                        <input type="submit" value="注册" style="color:#BC8F8F">
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </div>
</center>


<footer class="">
    <div class="footer-tp pd15">
        <div class="footer-tp-le">
            <div class="footer-tp-le-tp">技能树&nbsp;—&nbsp;改变你我</div>
            <div class="footer-tp-le-bt">
                <a href="http://www.jnshu.com/material/us">关于我们</a> 丨<a
                    href="http://www.jnshu.com/material/contact">联系我们</a>丨
                <a href="http://www.jnshu.com/partner">合作企业</a>
            </div>
        </div>
        <div class="footer-tp-mid">
            <div class="footer-tp-mid-tp">旗下网站</div>
            <div class="footer-tp-mid-bt">
                    <span class="">
                        <a href="http://www.caochuanyun.com/"> 草船云孵化器</a> </span>
                <span class="">
                        <a href="http://www.jnshu.com/home">最强IT特训营</a></span>

                <span class="">
                        <a href="http://game.ptteng.com/">葡萄藤轻游戏</a></span>
                <span class="">
                        <a href="http://wiki.ptteng.com/">桌游精灵</a>
                    </span>

            </div>

        </div>
        <div class="footer-tp-ri">
            <div class="footer-tp-ri-text"> 微信公众平台</div>
            <img class="footer-tp-ri-img" src="${pageContext.request.contextPath}/static/image/task08footer01.png" alt="">
        </div>
    </div>

    <div class="footer-bt">
        Copyright&reg;2015技能树 &nbsp; www.jnshu.com &nbsp;&nbsp;All &nbspRights&nbsp;Reserved丨京ICP备13005880号
    </div>
</footer>
</body>
</html>


