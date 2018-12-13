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
    var articleClass = getArticleClass();
    $.get(createURL(''),articleClass,function (re) {
        
    })
}

function getArticleClass(){
    var articleClass = {};
    articleClass.typeName = $("input[name='typeName']").val();
    articleClass.isUse = $("input[name='isUse']").val();
    articleClass.remark = $("input[name='remark']").val();
    return articleClass;
}
