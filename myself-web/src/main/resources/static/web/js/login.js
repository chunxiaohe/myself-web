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
            $.get("/login/createCode", {"picName":picName},function (re) {
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

