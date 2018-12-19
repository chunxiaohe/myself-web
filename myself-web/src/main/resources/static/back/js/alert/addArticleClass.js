$(function () {
    $("#addArticleClass").bootstrapValidator({
        fields: {
            typeName: {
                validators: {
                    notEmpty: {
                        message: '文章类型不能为空'
                    }
                }
            }
        }
    })
})

function valid() {
    //调用表单验证
    $("#addArticleClass").data("bootstrapValidator").validate();
    //获取验证结果(true/fasle)
    var valid = $("#addArticleClass").data("bootstrapValidator").isValid();
    $("#addArticleClass").on('moussdown', function () {
        if (!valid) {
            //重置表单
            $("#addArticleClass").data("bootstrapValidator").resetForm();
        }
    })
    return valid;
}

function submitData() {
    var flag = false;
    var articleClass = getArticleClass();
    $.get(createURL('/back/api/insert/articleClass'), articleClass, function (re) {
        if (re.code === 200) {
            layer.msg(re.message, {icon: 1});
            flag = true;
        } else if (re.code === 500) {
            layer.msg(re.message, {icon: 2});
        } else {
            layer.msg("系统异常", {icon: 2});
        }
    })
}

function getArticleClass() {
    var articleClass = {};
    articleClass.typeName = $("input[name='typeName']").val();
    articleClass.isUse = $("select[name='isUse']").val();
    articleClass.remark = $("textarea[name='remark']").val();
    return articleClass;
}
