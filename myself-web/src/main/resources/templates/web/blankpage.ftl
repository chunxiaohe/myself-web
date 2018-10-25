<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>Flot Charts</title>

    <link href="${staticRoot}/templateForPage/css/style.css" rel="stylesheet">
    <link href="${staticRoot}/templateForPage/css/style-responsive.css" rel="stylesheet">
</head>

<body class="sticky-header">

<section>
    <!-- main content start-->
    <div class="main-content" >
        <!-- page heading start-->
        <div class="page-heading">
            <h3>
                Flot Charts
            </h3>
            <ul class="breadcrumb">
                <li>
                    <a href="#">Charts</a>
                </li>
                <li class="active"> Flot Charts </li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Area Chart
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="visitors-chart">
                                <div id="visitors-container" style="width: 100%;height:300px; text-align: center; margin:0 auto;">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Real Time Chart
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="reatltime-chart">
                                <div id="reatltime-chartContainer" style="width:100%;height:300px; text-align: center; margin:0 auto;">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            Pie Chart
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="pie-chart" class="pie-chart">
                                <div id="pie-chartContainer" style="width: 100%;height:400px; text-align: left;">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            Donut Chart
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="pie-chart-donut" class="pie-chart">
                                <div id="pie-donutContainer" style="width: 100%;height:400px; text-align: left;">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Combined Chart
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="combine-chart">
                                <div id="legendcontainer26" class="legend-block">
                                </div>
                                <div id="combine-chartContainer" style="width: 100%;height:300px; text-align: center; margin:0 auto;">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Toggle Chart
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="toggle-chart">
                                <div class="clearfix">
                                    <form class="form-horizontal pull-left chart-control">
                                        <div class="control-group">
                                            <label class="control-label">Chart Type :</label>
                                            <div class="series-list">
                                                <label class="checkbox inline">
                                                    <input id="chartType1" checked name="ct" type="radio" value="line"/>
                                                    Line Chart</label>
                                                <label class="checkbox inline">
                                                    <input id="chartType2" name="ct" type="radio" value="bar"/>
                                                    Bar Chart </label>
                                            </div>
                                        </div>
                                    </form>
                                    <form class="form-horizontal chart-control pull-right chart-control">
                                        <div class="control-group ">
                                            <label class="control-label"> Toggle series :</label>
                                            <div class="series-list">
                                                <label class="checkbox inline">
                                                    <input type="checkbox" id="cbdata1" checked>
                                                    data1</label>
                                                <label class="checkbox inline">
                                                    <input type="checkbox" id="cbdata2" checked>
                                                    data2 </label>
                                                <label class="checkbox inline">
                                                    <input type="checkbox" id="cbdata3" checked>
                                                    data3 </label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div id="legendPlaceholder20">
                                </div>
                                <div id="toggle-chartContainer" style="width: 100%;height:300px; text-align: left;">
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer>
            2014 &copy; AdminEx by ThemeBucket
        </footer>
        <!--footer section end-->


    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="${staticRoot}/templateForPage/js/jquery-1.10.2.min.js"></script>
<script src="${staticRoot}/templateForPage/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${staticRoot}/templateForPage/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${staticRoot}/templateForPage/js/bootstrap.min.js"></script>
<script src="${staticRoot}/templateForPage/js/modernizr.min.js"></script>
<script src="${staticRoot}/templateForPage/js/jquery.nicescroll.js"></script>

<!-- jQuery Flot Chart-->
<script src="${staticRoot}/templateForPage/js/flot-chart/jquery.flot.js"></script>
<script src="${staticRoot}/templateForPage/js/flot-chart/jquery.flot.tooltip.js"></script>
<script src="${staticRoot}/templateForPage/js/flot-chart/jquery.flot.resize.js"></script>
<script src="${staticRoot}/templateForPage/js/flot-chart/jquery.flot.pie.resize.js"></script>
<script src="${staticRoot}/templateForPage/js/flot-chart/jquery.flot.selection.js"></script>
<script src="${staticRoot}/templateForPage/js/flot-chart/jquery.flot.stack.js"></script>
<script src="${staticRoot}/templateForPage/js/flot-chart/jquery.flot.time.js"></script>
<script src="${staticRoot}/templateForPage/js/flot.chart.init.js"></script>

<!--common scripts for all pages-->
<script src="${staticRoot}/templateForPage/js/scripts.js"></script>

</body>
</html>
