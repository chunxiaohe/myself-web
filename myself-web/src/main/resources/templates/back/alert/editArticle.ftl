<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>文章编辑</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <#include '../../common/commonStyle.ftl'>
    <#include '../../common/commonScript.ftl'>
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

        .a-upload {
            float: right;
            margin-top: -34px;
            height: 34px;
            padding: 4px 10px;
            line-height: 20px;
            position: relative;
            cursor: pointer;
            color: #fff3fe;
            background: #199a45;
            border: 1px solid #199a45;
            border-radius: 4px;
            overflow: hidden;
            display: inline-block;
            *display: inline;
            *zoom: 1
        }

        .a-upload input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
            filter: alpha(opacity=0);
            cursor: pointer;


        }

        .a-upload button {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
            filter: alpha(opacity=0);
            cursor: pointer;
        }

        .a-upload:hover {
            color: #444;
            background: #eee;
            border-color: #ccc;
            text-decoration: none
        }
    </style>
</head>
<body style="background: #EFF0F4;height: 500px">
<input type="hidden" value="${imagePath}" name = "imagePath">
<input type="hidden" value="${(article.createDate)!''}" id="createDate" >
<input type="hidden" value="${(article.previewName)!''}" id="previewName" >
<div class="container-fluid" id="app">
    <form id="articleForm">
        <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12" id="toolbar">
            <h5 style="width:20%;float: left;margin: 10px ">
                <i class="fa fa-book" aria-hidden="true"></i>&nbsp;文章名字
                <input class="form-control" <#if article.id??> articleId = "${article.id}" <#else>:articleId="articleId"</#if>
                       name="title" value="${(article.title)!''}">
            </h5>
            <h5 style="width:20%;float: left;margin: 10px ">
                <i class="fa fa-pie-chart" aria-hidden="true"></i>&nbsp;文章分类
                <select class="form-control" name="articleClassId">
                    <#list articleClass as aClass>
                        <option value="${aClass.id}" <#if article.articleClassId??>
                        <#if aClass.id == article.articleClassId>selected="selected"</#if>
                    </#if>
                        <#if aClass.isUse==2>style="color: red" </#if> >${(aClass.typeName)!''}</option>
                    </#list>
                </select>
            </h5>
            <h5 style="width:20%; margin: 10px; float: left">
                <i class="fa fa-keyboard-o" aria-hidden="true"></i>&nbsp;关键字
                <input class="form-control" name="keyword" value="${(article.keyword)!''}">
            </h5>
            <h5 style="width:10%; margin: 10px; float: left">
                <i class="fa fa-user-o" aria-hidden="true"></i>&nbsp;创建人
                <input class="form-control" name="createBy" createBy="${article.createBy}" disabled="disabled"
                       value="${(article.createName)!''}">
            </h5>
            <h5 style="width:14%; margin: 10px; float: left">
                <i class="fa fa-calendar-times-o" aria-hidden="true"></i>&nbsp;创建日期
                <input disabled="disabled" name="createDate" class="form-control" value="${(article.createDate)!''}">
            </h5>
            <h5 style="width:24%; margin: 10px; float: left">
                <i class="fa fa-file-image-o" aria-hidden="true"></i>&nbsp;预览图
                <#--<input  name="createDate" class="form-control" value="">-->
                <input disabled='disabled' id="fileName" name="fileName" class='form-control'
                       value="${(article.realName)!''}" style='width: 60%;margin-left: 51px'>
                <a class='a-upload' style="float: left" @click="lookPreview">
                    <input type="button" name='look'>查看
                </a>
                <a class='a-upload'>
                    <input type='file' name='file' id='file'>上传
                </a>
            </h5>
            <hr>
        </div>
        <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <#--<button class="btn  btn-info" style="display: block; margin:10px 0;" @click="createSaleOrder">新增</button> -->
            <div id="toolbar" class="toolbar"></div>
            <div id="editor" name="content" class="text"> <!--可使用 min-height 实现编辑区域自动增加高度-->
                <p>${(article.content)!''}</p>
            </div>
        </div>
    </form>
    <img style="display: none;width: 100%;height: 100%" id="previewPic" src="">
</div>
<script src="${staticRoot}/back/js/alert/editArticle.js"></script>
</body>
</html>