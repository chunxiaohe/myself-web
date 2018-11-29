<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--common-->
    <link href="${staticRoot}/back/css/style.css" rel="stylesheet">
    <!-- 滚动css -->
    <link href="${staticRoot}/back/css/style_indexcontent_comment.css" rel="stylesheet">
</head>
<body>
<body style="background: #EFF0F4;">
      <div id="app">

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-md-6">
                    <!--statistics start-->
                    <div class="row state-overview">
                        <div class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel purple">
                                <div class="symbol">
                                    <i class="fa fa-male"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value">230</div>
                                    <div class="title">昨日访问量</div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel red">
                                <div class="symbol">
                                    <i class="fa fa-female"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value">3490</div>
                                    <div class="title">今日访问量</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row state-overview">
                        <div class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel blue">
                                <div class="symbol">
                                    <i class="fa fa-user"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value">200</div>
                                    <div class="title">本月访问量 </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel green">
                                <div class="symbol">
                                    <i class="fa fa-eye"></i>
                                </div>
                                <div class="state-value">
                                    <div class="value">390</div>
                                    <div class="title"> 总访问量</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--statistics end-->
                </div>
                <div class="col-md-6">
                    <!--more statistics box start-->
                    <div class="panel deep-purple-box">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-7 col-sm-7 col-xs-7">
                                    <div id="graph-donut" class="revenue-graph"></div>

                                </div>
                                <div class="col-md-5 col-sm-5 col-xs-5">
                                    <ul class="bar-legend">
                                        <li><span class="blue"></span> Open rate</li>
                                        <li><span class="green"></span> Click rate</li>
                                        <li><span class="purple"></span> Share rate</li>
                                        <li><span class="red"></span> Unsubscribed rate</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--more statistics box end-->
                </div>
            </div>
            <div class="row">
                <div class="col-md-8" style="width: 50%">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="row revenue-states">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <h4>近七日访问量对比分析</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div id="main-chart">
                                        <div id="visitCompare" class="main-chart" >
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8" style="width: 50%">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="row revenue-states">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <h4>最新评论</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div id="main-chart">
                                        <div id="visitCompareMap" class="main-chart" >
                                            <div class="recordList" style="top: 10px;width: 100%;height: 100%">
                                                <ul class="line">
                                                    <li style="margin-top: 0px; "><a title="getElementsByTagName的简写方式" href="http://mrthink.net/javascrip-simple-getelementsbytagname/">getElementsByTagName的简写方式</a> 2010年06月24日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="一个简单的鼠标划过切换效果" href="http://mrthink.net/script-mousechange-simple/">一个简单的鼠标划过切换效果</a> 2010年05月23日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="奇或偶数行高亮显示及鼠标划过高亮显示类" href="http://mrthink.net/javascript-tagnames-highlight/">奇或偶数行高亮显示及鼠标划过高亮显示类</a> 2010年05月05日 (5)</li>
                                                    <li style="margin-top: 0px; "><a title="一个简单的纵横向动画效果类" href="http://mrthink.net/javascrip-dom-slide-simple/">一个简单的纵横向动画效果类</a> 2010年05月02日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="document.getElementById的简写方式" href="http://mrthink.net/javascript-getbyid-simplewrite/">document.getElementById的简写方式</a> 2010年04月18日 (1)</li>
                                                    <li style="margin-top: 0px; "><a title="两种简单实现菜单高亮显示的JS类" href="http://mrthink.net/javascript-highlight-menu-twoway/">两种简单实现菜单高亮显示的JS类</a> 2010年04月17日 (10)</li>
                                                    <li style="margin-top: 0px; "><a title="简易的点击展开/关闭效果(原生JS版和JQ版)" href="http://mrthink.net/js-jq-click-openclose/">简易的点击展开/关闭效果(原生JS版和JQ版)</a> 2010年08月02日 (6)</li>
                                                    <li style="margin-top: 0px; "><a title="getElementsByTagName的简写方式" href="http://mrthink.net/javascrip-simple-getelementsbytagname/">getElementsByTagName的简写方式</a> 2010年06月24日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="一个简单的鼠标划过切换效果" href="http://mrthink.net/script-mousechange-simple/">一个简单的鼠标划过切换效果</a> 2010年05月23日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="奇或偶数行高亮显示及鼠标划过高亮显示类" href="http://mrthink.net/javascript-tagnames-highlight/">奇或偶数行高亮显示及鼠标划过高亮显示类</a> 2010年05月05日 (5)</li>
                                                    <li style="margin-top: 0px; "><a title="一个简单的纵横向动画效果类" href="http://mrthink.net/javascrip-dom-slide-simple/">一个简单的纵横向动画效果类</a> 2010年05月02日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="document.getElementById的简写方式" href="http://mrthink.net/javascript-getbyid-simplewrite/">document.getElementById的简写方式</a> 2010年04月18日 (1)</li>
                                                    <li style="margin-top: 0px; "><a title="两种简单实现菜单高亮显示的JS类" href="http://mrthink.net/javascript-highlight-menu-twoway/">两种简单实现菜单高亮显示的JS类</a> 2010年04月17日 (10)</li>
                                                    <li style="margin-top: 0px; "><a title="简易的点击展开/关闭效果(原生JS版和JQ版)" href="http://mrthink.net/js-jq-click-openclose/">简易的点击展开/关闭效果(原生JS版和JQ版)</a> 2010年08月02日 (6)</li>
                                                    <li style="margin-top: 0px; "><a title="getElementsByTagName的简写方式" href="http://mrthink.net/javascrip-simple-getelementsbytagname/">getElementsByTagName的简写方式</a> 2010年06月24日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="一个简单的鼠标划过切换效果" href="http://mrthink.net/script-mousechange-simple/">一个简单的鼠标划过切换效果</a> 2010年05月23日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="奇或偶数行高亮显示及鼠标划过高亮显示类" href="http://mrthink.net/javascript-tagnames-highlight/">奇或偶数行高亮显示及鼠标划过高亮显示类</a> 2010年05月05日 (5)</li>
                                                    <li style="margin-top: 0px; "><a title="一个简单的纵横向动画效果类" href="http://mrthink.net/javascrip-dom-slide-simple/">一个简单的纵横向动画效果类</a> 2010年05月02日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="document.getElementById的简写方式" href="http://mrthink.net/javascript-getbyid-simplewrite/">document.getElementById的简写方式</a> 2010年04月18日 (1)</li>
                                                    <li style="margin-top: 0px; "><a title="两种简单实现菜单高亮显示的JS类" href="http://mrthink.net/javascript-highlight-menu-twoway/">两种简单实现菜单高亮显示的JS类</a> 2010年04月17日 (10)</li>
                                                    <li style="margin-top: 0px; "><a title="简易的点击展开/关闭效果(原生JS版和JQ版)" href="http://mrthink.net/js-jq-click-openclose/">简易的点击展开/关闭效果(原生JS版和JQ版)</a> 2010年08月02日 (6)</li>
                                                    <li style="margin-top: 0px; "><a title="getElementsByTagName的简写方式" href="http://mrthink.net/javascrip-simple-getelementsbytagname/">getElementsByTagName的简写方式</a> 2010年06月24日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="一个简单的鼠标划过切换效果" href="http://mrthink.net/script-mousechange-simple/">一个简单的鼠标划过切换效果</a> 2010年05月23日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="奇或偶数行高亮显示及鼠标划过高亮显示类" href="http://mrthink.net/javascript-tagnames-highlight/">奇或偶数行高亮显示及鼠标划过高亮显示类</a> 2010年05月05日 (5)</li>
                                                    <li style="margin-top: 0px; "><a title="一个简单的纵横向动画效果类" href="http://mrthink.net/javascrip-dom-slide-simple/">一个简单的纵横向动画效果类</a> 2010年05月02日 (4)</li>
                                                    <li style="margin-top: 0px; "><a title="document.getElementById的简写方式" href="http://mrthink.net/javascript-getbyid-simplewrite/">document.getElementById的简写方式</a> 2010年04月18日 (1)</li>
                                                    <li style="margin-top: 0px; "><a title="两种简单实现菜单高亮显示的JS类" href="http://mrthink.net/javascript-highlight-menu-twoway/">两种简单实现菜单高亮显示的JS类</a> 2010年04月17日 (10)</li>
                                                    <li style="margin-top: 0px; "><a title="简易的点击展开/关闭效果(原生JS版和JQ版)" href="http://mrthink.net/js-jq-click-openclose/">简易的点击展开/关闭效果(原生JS版和JQ版)</a> 2010年08月02日 (6)</li>
                                                </ul>
                                            </div>


                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <div class="panel">
                        <div class="panel-body extra-pad">
                            <h4 class="pros-title">prospective <span>leads</span></h4>
                            <div class="row">
                                <div class="col-sm-4 col-xs-4">
                                    <div id="p-lead-1"></div>
                                    <p class="p-chart-title">Laptop</p>
                                </div>
                                <div class="col-sm-4 col-xs-4">
                                    <div id="p-lead-2"></div>
                                    <p class="p-chart-title">iPhone</p>
                                </div>
                                <div class="col-sm-4 col-xs-4">
                                    <div id="p-lead-3"></div>
                                    <p class="p-chart-title">iPad</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel">
                        <div class="panel-body extra-pad">
                            <div class="col-sm-6 col-xs-6">
                                <div class="v-title">Visits</div>
                                <div class="v-value">10,090</div>
                                <div id="visit-1"></div>
                                <div class="v-info">Pages/Visit</div>
                            </div>
                            <div class="col-sm-6 col-xs-6">
                                <div class="v-title">Unique Visitors</div>
                                <div class="v-value">8,173</div>
                                <div id="visit-2"></div>
                                <div class="v-info">Avg. Visit Duration</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">

                    <div class="panel green-box">
                        <div class="panel-body extra-pad">
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <div class="knob">
                                        <span class="chart" data-percent="79">
                                            <span class="percent">79% <span class="sm">New Visit</span></span>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="knob">
                                        <span class="chart" data-percent="56">
                                            <span class="percent">56% <span class="sm">Bounce rate</span></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="calendar-block ">
                                <div class="cal1">

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel">
                        <header class="panel-heading">
                            Todo List
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <ul class="to-do-list" id="sortable-todo">
                                <li class="clearfix">
                                    <span class="drag-marker">
                                    <i></i>
                                    </span>
                                    <div class="todo-check pull-left">
                                        <input type="checkbox" value="None" id="todo-check"/>
                                        <label for="todo-check"></label>
                                    </div>
                                    <p class="todo-title">
                                        Dashboard Design & Wiget placement
                                    </p>
                                    <div class="todo-actionlist pull-right clearfix">

                                        <a href="#" class="todo-remove"><i class="fa fa-times"></i></a>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <span class="drag-marker">
                                    <i></i>
                                    </span>
                                    <div class="todo-check pull-left">
                                        <input type="checkbox" value="None" id="todo-check1"/>
                                        <label for="todo-check1"></label>
                                    </div>
                                    <p class="todo-title">
                                        Wireframe prepare for new design
                                    </p>
                                    <div class="todo-actionlist pull-right clearfix">

                                        <a href="#" class="todo-remove"><i class="fa fa-times"></i></a>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <span class="drag-marker">
                                    <i></i>
                                    </span>
                                    <div class="todo-check pull-left">
                                        <input type="checkbox" value="None" id="todo-check2"/>
                                        <label for="todo-check2"></label>
                                    </div>
                                    <p class="todo-title">
                                        UI perfection testing for Mega Section
                                    </p>
                                    <div class="todo-actionlist pull-right clearfix">

                                        <a href="#" class="todo-remove"><i class="fa fa-times"></i></a>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <span class="drag-marker">
                                    <i></i>
                                    </span>
                                    <div class="todo-check pull-left">
                                        <input type="checkbox" value="None" id="todo-check3"/>
                                        <label for="todo-check3"></label>
                                    </div>
                                    <p class="todo-title">
                                        Wiget & Design placement
                                    </p>
                                    <div class="todo-actionlist pull-right clearfix">

                                        <a href="#" class="todo-remove"><i class="fa fa-times"></i></a>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <span class="drag-marker">
                                    <i></i>
                                    </span>
                                    <div class="todo-check pull-left">
                                        <input type="checkbox" value="None" id="todo-check4"/>
                                        <label for="todo-check4"></label>
                                    </div>
                                    <p class="todo-title">
                                        Development & Wiget placement
                                    </p>
                                    <div class="todo-actionlist pull-right clearfix">

                                        <a href="#" class="todo-remove"><i class="fa fa-times"></i></a>
                                    </div>
                                </li>

                            </ul>
                            <div class="row">
                                <div class="col-md-12">
                                    <form role="form" class="form-inline">
                                        <div class="form-group todo-entry">
                                            <input type="text" placeholder="Enter your ToDo List" class="form-control" style="width: 100%">
                                        </div>
                                        <button class="btn btn-primary pull-right" type="submit">+</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel blue-box twt-info">
                        <div class="panel-body">
                            <h3>19 Februay 2014</h3>

                            <p>AdminEx is new model of admin
                                dashboard <a href="#">http://t.co/3laCVziTw4</a>
                                4 days ago by John Doe</p>
                        </div>
                    </div>
                    <div class="panel">
                        <div class="panel-body">
                            <div class="media usr-info">
                                <a href="#" class="pull-left">
                                    <img class="thumb" src="${staticRoot}/common/image/user2.png" alt=""/>
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading">Mila Watson</h4>
                                    <span>Senior UI Designer</span>
                                    <p>I use to design websites and applications for the web.</p>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer custom-trq-footer">
                            <ul class="user-states">
                                <li>
                                    <i class="fa fa-heart"></i> 127
                                </li>
                                <li>
                                    <i class="fa fa-eye"></i> 853
                                </li>
                                <li>
                                    <i class="fa fa-user"></i> 311
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
      </div>

</body>
<!-- system js -->
<script type="text/javascript" src="${staticRoot}/common/js/echarts/echarts.js"></script>
<script type="text/javascript" src="${staticRoot}/common/js/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${staticRoot}/common/js/vue/vue.js"></script>
<script type="text/javascript" src="${staticRoot}/common/js/layui/layer.js"></script>


<!-- my js -->
<script type="text/javascript" src="${staticRoot}/back/js/indexcontent.js"></script>
<!-- 最新评论滚动播放的js -->
<script type="text/javascript" src="${staticRoot}/back/js/indexcontent_comment.js"></script>



</html>