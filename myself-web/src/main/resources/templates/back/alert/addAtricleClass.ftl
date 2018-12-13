<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>审核</title><#include '../../common/commonStyle.ftl'><#include '../../common/commonScript.ftl'>
  <style>
  label {
  	font-weight:normal;
  }
  form {
  	margin-top:10px;
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
	        <input class="form-control" id="typeName" name="typeName" value=""/>
	    </div>
	    <div class="form-group">
	        <label for="">是否启用</label>
            <select name="isUse" id="isUse" class="form-control">
                <option value="1" selected="selected">启用</option>
                <option value="2">禁用</option>
            </select>
	    </div>
	    <div class="form-group">
	        <label for="">备注</label>
            <textarea class="form-control" rows="3" ></textarea>
        </div>
    </form>
  </div>
  </div>
</body>
<script type="text/javascript" src="${staticRoot}/back/js/alert/addArticleClass.js"></script>
</html>