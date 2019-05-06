<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${staticRoot}/back/image/login.png" type="image/png">

    <title>Travel</title>

    <link href="${staticRoot}/back/css/style.css" rel="stylesheet">

</head>

<body class="login-body">
<input type="hidden" value="${staticRoot}" id="staticRoot">
<input type="hidden" value="${webRoot}" id="webRoot">
<div class="container" id="app">

    <form class="form-signin" method="post" action="/back/login/submit" onsubmit="return check()">

        <div class="form-signin-heading text-center">
            <#--<h1 class="sign-title">Sign In</h1>-->
            <img src="${staticRoot}/back/image/travel.png" alt=""/>
        </div>
        <div class="login-wrap">
            <input type="text" name="username" class="form-control" placeholder="用户名" autofocus>
            <input type="password" name="password" class="form-control" placeholder="密码">
            <input type="text" name="code" class="form-control" placeholder="验证码" style="float: left">
            <img :src="validataCodepath" @click="updateCode" style="cursor: pointer;text-align: center;margin-left: 40px;">
            <button class="btn btn-lg btn-login btn-block" type="submit">
                <i class="fa fa-check"></i>
            </button>

            <div class="registration">
                没有账号?
                <a class="" href="registration.html">
                    注册
                </a>
            </div>
            <#--<label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
                <span class="pull-right">
                    <a data-toggle="modal" href="#myModal"> Forgot Password?</a>

                </span>
            </label>-->

        </div>

        <!-- Modal -->
        <#--<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Forgot Password ?</h4>
                    </div>
                    <div class="modal-body">
                        <p>Enter your e-mail address below to reset your password.</p>
                        <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                        <button class="btn btn-primary" type="button">Submit</button>
                    </div>
                </div>
            </div>
        </div>-->
        <!-- modal -->

    </form>

</div>
</body>
<script type="text/javascript" src="${staticRoot}/core/js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${staticRoot}/core/js/layer/layer.js"></script>
<script type="text/javascript" src="${staticRoot}/core/js/vue/vue.js"></script>

<script type="text/javascript" src="${staticRoot}/back/js/login.js"></script>
</html>
