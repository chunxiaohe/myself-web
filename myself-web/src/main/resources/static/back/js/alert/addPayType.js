//上传的文件
var file;
$(function () {
    $('#file').on('change', function () {
        //验证文件的格式
        file = $("#file")[0].files;
        if (file[0].type.indexOf("image/") == -1) {
            layer.msg('请选择图片上传', {icon: 2});
            $("#file").val('');
            $("input[name='fileName']").val('');
        } else {
            $("input[name='fileName']").val(file[0].name);
        }
    })

    //图片 表单验证
    $("#addPayType").bootstrapValidator({
        fields:{
            file:{
                validators:{
                    notEmpty:{
                        message:'请选择需要上传的图片'
                    }
                }
            }
        }
    })
})

function valid() {
    //调用表单验证
    $('#addPayType').data("bootstrapValidator").validate();
    //调取验证结果
    var valided =  $("#addPayType").data("bootstrapValidator").isValid();
    return valided;
}

function submitFile() {
    var flag = false;
    var type =  $("select[name='type']").val();
    var remark  = $("textarea[name='remark']").val();
    var data = new FormData();
    data.append("file",file[0]);
    data.append("type",type);
    data.append("remark",remark);
    $.ajax({
        url:createURL('back/api/upload/payType'),
        type:'post',
        data:data,
        contentType:false,//必须
        processData:false,//用于对data参数进行序列化处理 这里必须false
        cache: false,//上传文件无需缓存
        async: false,
        success:function(re){
            if(re.code==200){
                layer.msg(re.message,{icon:1});
                flag =  true;
            } else if(re.code==500){
                layer.msg(re.message,{icon:2});
            }else{
                layer.msg("系统异常",{icon:2});
            }
        }
    })
    return flag;
}