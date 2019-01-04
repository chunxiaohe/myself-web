<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8">
    <title>支付方式</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <#include '../common/commonStyle.ftl'>
    <#include '../common/commonScript.ftl'>
    <link rel="stylesheet" href="${staticRoot}/back/css/pageCommon.css">

    <style>
        .btn-info{
            margin-top: 23px;
        }
        .col-lg-3{
            width:20% ;
        }

    </style>
</head>
<body style="background: #EFF0F4;height: 500px">
<input type="hidden" name="staticRoot" value="${staticRoot}">
<input type="hidden" name="imagePath" value="${imagePath}">
<div class="container-fluid" id="app">

        <div class="form-group col-sm-3 col-md-3 col-lg-3">
            <button class="btn btn-info" @click="create"> <i class="fa fa-plus" aria-hidden="true"></i>&nbsp;新增</button>
        </div>
    <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12" >
        <#--<button class="btn  btn-info" style="display: block; margin:10px 0;" @click="createSaleOrder">新增</button> -->
        <table id="jqGrid"></table>
        <div id="jqGridPager" ></div>
    </div>
    <img style="display: none;width: 100%;height: 100%" id="payTypePic" src="">
</div>
<script src="${staticRoot}/back/js/payType.js"></script>
</body>
</html>