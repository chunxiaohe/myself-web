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
<div class="container-fluid" id="app">
    <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12" id="toolbar">
        <h3  style="width:100%; cursor:pointer;" @click="toggleSearchForm">查询条件&nbsp;<i class="fa fa-filter" aria-hidden="true" ></i></h3>
        <hr>
        <form v-on:submit.prevent id="searchForm">
            <div class="col-sm-3 col-md-3 col-lg-3 mb10">
                <div class="form-group">
                    <label for="">类型名称</label>
                    <input  class="form-control" id="typeName" >
                </div>
            </div>
            <div class="col-sm-3 col-md-3 col-lg-3 mb10">
                <div class="form-group">
                    <label for="">类型状态</label>
                    <select name="isUse" id="isUse" class="form-control">
                        <option value="0"></option>
                        <option value="1">启用</option>
                        <option value="2">禁用</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-sm-3 col-md-3 col-lg-3">
                <button class="btn  btn-info" @click="search"><i class="fa fa-search" aria-hidden="true"></i>&nbsp;查询</button>
                <button class="btn btn-info" @click="reset"> <i class="fa fa-refresh" aria-hidden="true"></i>&nbsp;重置</button>
                <button class="btn btn-info" @click="create"> <i class="fa fa-plus" aria-hidden="true"></i>&nbsp;新增</button>
            </div>
        </form>
    </div>
    <div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12" >
        <#--<button class="btn  btn-info" style="display: block; margin:10px 0;" @click="createSaleOrder">新增</button> -->
        <table id="jqGrid"></table>
        <div id="jqGridPager" ></div>
    </div>

</div>
<script src="${staticRoot}/back/js/articleClass.js"></script>
</body>
</html>