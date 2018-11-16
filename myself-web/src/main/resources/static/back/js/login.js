var vm = new Vue({
    el: "#app",
    data: {
        picName: '',
        randomNum: '',
        pic: '',
    },
    mounted() {
        var that = this;
        that.$nextTick(function () {
            //生成验证码
            that._getSecurityCode();
            //展示提示信息
            that._verify();
            //更新验证码
            that._updateSecurityCode();

        })
    },
    methods: {
        _verify() {
            var reg = new RegExp("(^|&)errorMsg=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) {
                var msg = decodeURI(r[2]);
                layer.msg(msg, {icon: 2, time: 2000});
            }
        },
        _getSecurityCode() {
            var picName = $("input[name='picName']").val();
            $.get("/back/login/createCode", {"picName":picName},function (re) {
            console.log(re);
                if (re.code == 200) {
                    var staticRoot = $("#staticRoot").val();
                    vm.picName = re.data[0].picName;
                    vm.pic = staticRoot + "/codeImage/" + re.data[0].picName;
                    vm.randomNum = re.data[0].randomNum;
                }
            })
        },
        _updateSecurityCode(){
            var that = this;
            $(".login-wrap").on('click',"img",function () {
                that._getSecurityCode();
            })
        }
    }
})

//表单提交验证
function check(){
    var username = $("input[name='username']").val();
    var password = $("input[name='password']").val();
    var code = $("input[name='code']").val();
    var picName = $("input[name='picName']").val();
    if(username.trim()==="" || username===null){
        layer.msg("用户名不能为空", {icon: 2, time: 2000})
        return false;
    }
    if(password.trim()==="" || password===null){
        layer.msg("密码不能为空", {icon: 2, time: 2000})
        return false;
    }
    if(code.trim()==="" || code===null){
        layer.msg("验证码不能为空", {icon: 2, time: 2000})
        return false;
    }
    var flag = false;
    //校验验证码
    $.ajaxSettings.async=false;//设置ajax为同步提交
    $.post("/back/login/checkCode",{"code":code,"picName":picName},function(re){
        if(re.code==200){
            flag = true;
        }else if(re.code==500){
            layer.msg(re.message,{icon:2,time:2000});
            flag =  false;
        }
    })
    return flag;
}