var vm = new Vue({
    el:"#app",
    data:{
        treeData:[]
    },
    mounted(){
        var that = this;
        that.$nextTick(function () {
            //菜单加载
            $.get("/menu/getMyselfMenuList",function (re) {
                console.log(re.data);
                if(re.code==200 && re.data.length>0){
                    that.treeData = re.data;
                }
            });
            //点击展开子菜单/样式
            that.showsubmenu();
        })
    },
    methods:{
        showsubmenu(){
            $(".left-side-inner").on('click','li',function(){
                if($(this).siblings().hasClass("nav-active")){
                    $(this).siblings().removeClass("nav-active");
                }
                if($(this).hasClass("nav-active")){
                    $(this).removeClass("nav-active")
                }else{
                    $(this).addClass("nav-active");
                }

            })
        }
    }

})


