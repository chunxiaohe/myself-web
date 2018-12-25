<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加文章类型</title><#include '../../common/commonStyle.ftl'><#include '../../common/commonScript.ftl'>
    <style>
        label {
            font-weight: normal;
        }

        form {
            margin-top: 10px;
        }

        .form-group {
            margin: 15px 0;
        }
    </style>
</head>
<body>
<div class="container-fluid" id="app">
    <form id="addArticleClass">
        <div class="form-group">
            <label for="">类型名称</label>
            <input class="form-control" id="typeName" name="typeName" value="${(articleClass.typeName)!''}"/>
        </div>
        <div class="form-group">
            <label for="">是否启用</label>
            <select name="isUse" id="isUse" class="form-control">
                <option value="1">启用</option>
                <#if articleClass ??>
                    <#if (articleClass.isUse)==2>
                        <option value="2"  selected="selected">禁用</option>
                        <#else><option value="2">禁用</option>
                    </#if>
                    <#else><option value="2">禁用</option>
                </#if>
            </select>
        </div>
        <div class="form-group">
            <label for="">备注</label>
            <textarea class="form-control" rows="3" name="remark">${(articleClass.remark)!''}</textarea>
        </div>
    </form>
</div>
</div>
</body>
<script type="text/javascript" src="${staticRoot}/back/js/alert/addArticleClass.js"></script>
</html>