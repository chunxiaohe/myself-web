<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords" content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${staticRoot}/back/image/travel.png" type="image/png">

    <title>Travel</title>

    <!--common-->
    <link href="${staticRoot}/back/css/style.css" rel="stylesheet">

</head>

<body class="sticky-header">
<div id="app">
<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side" >
        <!--logo and iconic logo start-->
        <div class="logo">
            <img src="${staticRoot}/back/image/logo.png" alt="">
        </div>
        <!--logo and iconic logo end-->

        <div class="left-side-inner">
            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li class=""><a href="/back/page/index"><i class="fa fa-home"></i> <span>主页</span></a></li>
                <li class="menu-list " v-for="menu in treeData" style="cursor: pointer">
                    <a ><i :class=" menu.icon"></i><span>{{menu.name}}</span></a>
                    <ul class="sub-menu-list" >
                        <li v-for="submenu in menu.nodes" :data="submenu.url" style="cursor: pointer">
                            <a ><i :class="submenu.icon"></i> {{submenu.name}}</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!--sidebar nav end-->

        </div>
    </div>
    <!-- left side end-->

    <!-- header section start-->
    <div class="header-section">
        <!--toggle button start-->
            <div>
                <i class="fa fa-bars ip-city"></i>
            </div>
            <div class="ip-city"  >
                <li >{{city}} &nbsp;</li>
                <li > {{IP}}</li>
            </div>
        <!--toggle button end-->
        <!--notification menu start -->
        <div class="menu-right">
            <ul class="notification-menu">
                <li>
                    <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                        <i class="fa fa-bell-o"></i>
                        <span class="badge">4</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-head pull-right">
                        <h5 class="title">Notifications</h5>
                    </div>
                </li>
                <li id="operation">
                    <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <img src="${staticRoot}/back/image/user-avatar.png" alt="" />
                        ${username}
                        <span class="caret"></span>
                    </a>
                    <ul id="operation_list" class="dropdown-menu dropdown-menu-usermenu pull-right">
                        <li><a href="#"><i class="fa fa-user"></i>  Profile</a></li>
                        <li><a href="/blog/page/index"><i class="fa fa-book"></i>  博客首页</a></li>
                        <li><a href="/back/login/loginOut"><i class="fa fa-sign-out"></i>退出登录</a></li>
                    </ul>
                </li>

            </ul>
        </div>
        <!--notification menu end -->

    </div>
    <!-- header section end-->

    <!-- main content start-->
    <div class="m-r-b">
       <iframe :src="currentPage" frameborder="0" id="pageContent">
        </iframe>
    </div>

    <!-- main content end-->
</section>
</div>

<!-- system js -->
<script type="text/javascript" src="${staticRoot}/core/js/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${staticRoot}/core/js/vue/vue.js"></script>
<!-- 获取当前登录用户的ip以及所在城市 -->
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>

<!-- my js -->
<script type="text/javascript" src="${staticRoot}/back/js/index.js"></script>
</body>
</html>
