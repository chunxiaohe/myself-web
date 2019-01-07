<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加支付类型</title><#include '../../common/commonStyle.ftl'><#include '../../common/commonScript.ftl'>
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

        .a-upload  input {
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
<body>
<div class="container-fluid" id="app">
    <form id="addPayType">
        <div class='form-group' id='uploadFile'>
            <label for=''>选择图片</label>
            <input disabled='disabled' value="${(slideshow.realName)!''}" id="fileName"  name="fileName" class='form-control' style='width: 80%'>
            <a class='a-upload'>
                <input type='file' name='file' id='file'>上传图片
            </a>
        </div>
        <div class='form-group'>
            <label for=''>轮播顺序</label>
            <input class='form-control' name="theOrder" value="${(slideshow.theOrder)!''}">
        </div>
        <div class='form-group'>
            <label for=''>备注</label>
            <textarea class='form-control' rows='3' name='remark'>${(slideshow.remark)!''}</textarea>
        </div>

    </form>
</div>
</div>
</body>
<script type="text/javascript" src="${staticRoot}/back/js/alert/editSlideshow.js"></script>
</html>