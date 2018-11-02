<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords" content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${staticRoot}/templateForPage/images/travel.png" type="image/png">

    <title>Travel</title>

    <!--common-->
    <link href="${staticRoot}/templateForPage/css/style.css" rel="stylesheet">
    <link href="${staticRoot}/templateForPage/css/style-responsive.css" rel="stylesheet">
    <style >
        .m-r-b{
            position: fixed;
            left: 240px;
            top: 24px;

            width: 100%;
            height: 100%;
            margin-top: 24px;
        }
        #pageContent{
            /*margin-left: 240px;
            background: #eff0f4;
            min-height: 850px;
            top: 600px;
            width: 100%;*/
            width: 100%;
            height: 800px;

        }
    </style>
</head>

<body class="sticky-header">
<div id="app">
<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side" >
        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="/"><img src="${staticRoot}/templateForPage/images/logo.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->

        <div class="left-side-inner">
            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li class=""><a href="/"><i class="fa fa-home"></i> <span>主页</span></a></li>
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
        <a class="toggle-btn"><i class="fa fa-bars"></i></a>
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
                        <img src="${staticRoot}/templateForPage/images/photos/user-avatar.png" alt="" />
                        ${username}
                        <span class="caret"></span>
                    </a>
                    <ul id="operation_list" class="dropdown-menu dropdown-menu-usermenu pull-right">
                        <li><a href="#"><i class="fa fa-user"></i>  Profile</a></li>
                        <li><a href="#"><i class="fa fa-cog"></i>  Settings</a></li>
                        <li><a href="/sys/loginOut"><i class="fa fa-sign-out"></i>退出登录</a></li>
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
<script type="text/javascript" src="${staticRoot}/web/util/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${staticRoot}/web/util/vue/vue.js"></script>

<!-- my js -->
<script type="text/javascript" src="${staticRoot}/web/js/index.js"></script>
</body>
</html>
