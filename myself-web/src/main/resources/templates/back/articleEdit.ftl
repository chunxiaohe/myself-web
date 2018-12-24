<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <#include '../common/commonStyle.ftl'>
    <#include '../common/commonScript.ftl'>
    <link rel="stylesheet" href="${staticRoot}/back/css/pageCommon.css">

</head>
<body style="background: #EFF0F4;height: 500px">
<div class="container-fluid" id="app">
    <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12" id="toolbar">
        <h3  style="width:20%;float: left " >
            <i class="fa fa-book" aria-hidden="true" ></i>&nbsp;文章名字
            <input class="form-control">
        </h3>
        <h3  style="width:20%; margin: 20px; float: left" >
            <i class="fa fa-keyboard-o" aria-hidden="true" ></i>&nbsp;关键字
            <input class="form-control">
        </h3>
        <h3  style="width:20%; margin: 20px; float: left" >
            <i class="fa fa-user-o" aria-hidden="true" ></i>&nbsp;创建人
            <input class="form-control" disabled="disabled">
        </h3>
        <h3  style="width:20%; margin: 20px; float: left" >
            <i class="fa fa-calendar-times-o" aria-hidden="true" ></i>&nbsp;创建日期
            <input disabled="disabled" class="form-control">
        </h3>
        <hr>

    </div>
    <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12" >
        <#--<button class="btn  btn-info" style="display: block; margin:10px 0;" @click="createSaleOrder">新增</button> -->
        <table id="jqGrid"></table>
        <div id="jqGridPager" ></div>
    </div>

</div>
<script src="${staticRoot}/back/js/article.js"></script>
</body>
</html>