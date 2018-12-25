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
    <!-- 富文本编辑器:wangEditor -->
    <script type="text/javascript" src="${staticRoot}/core/js/wangEditor/wangEditor.min.js" charset="utf-8"></script>
    <style type="text/css">
        .toolbar {
            border: 1px solid #ccc;
        }

        .text {
            border: 1px solid #ccc;
            height: 460px;
        }
    </style>
</head>
<body style="background: #EFF0F4;height: 500px">
<div class="container-fluid" id="app">
    <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12" id="toolbar">
        <h5 style="width:20%;float: left;margin: 10px ">
            <i class="fa fa-book" aria-hidden="true"></i>&nbsp;文章名字
            <input class="form-control" v-if="${type}==1" value="${(article.title)!''}">
            <input class="form-control" v-else>
        </h5>
        <h5 style="width:20%;float: left;margin: 10px ">
            <i class="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;文章分类
            <input class="form-control" v-if="${type}==1" value="${(article.title)!''}">
            <input class="form-control" v-else>
        </h5>
        <h5 style="width:20%; margin: 10px; float: left">
            <i class="fa fa-keyboard-o" aria-hidden="true"></i>&nbsp;关键字
            <input class="form-control" v-if="${type}==1" value="${(article.keyword)!''}">
            <input class="form-control" v-else>
        </h5>
        <h5 style="width:20%; margin: 10px; float: left">
            <i class="fa fa-user-o" aria-hidden="true"></i>&nbsp;创建人
            <input class="form-control" disabled="disabled" v-if="${type}==1" value="${(article.createName)!''}">
            <input class="form-control" disabled="disabled" v-else value="${(name)!''}">
        </h5>
        <h5 style="width:20%; margin: 10px; float: left">
            <i class="fa fa-calendar-times-o" aria-hidden="true"></i>&nbsp;创建日期
            <input disabled="disabled" class="form-control" v-if="${type}==1" value="${(article.createDate)!''}">
            <input disabled="disabled" class="form-control" v-else value="${(date)!''}">
        </h5>
        <hr>
    </div>
    <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <#--<button class="btn  btn-info" style="display: block; margin:10px 0;" @click="createSaleOrder">新增</button> -->
        <div id="toolbar" class="toolbar"></div>
        <div id="editor" class="text"> <!--可使用 min-height 实现编辑区域自动增加高度-->
            ${(article.content)!''}
        </div>
    </div>
</div>
<script src="${staticRoot}/back/js/articleEdit.js"></script>
</body>
</html>