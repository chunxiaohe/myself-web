var vm = new Vue({
    el:"#app",
    data:{
        treeData:[],
        currentPage:"/back/page/index/content",
        IP:'',
        city:''
    },
    mounted(){
        var that = this;
        that.$nextTick(function () {
            //菜单加载
            $.get("/menu/getMyselfMenuList",function (re) {
                if(re.code==200 && re.data.length>0){
                    that.treeData = re.data;
                }
            });
            //当前登录用户的IP以及城市
            vm.IP = returnCitySN['cip'];
            vm.city = returnCitySN['cname']
            //点击展开子菜单/更新样式
            that.showsubmenu();
        })
    },
    methods:{
        showsubmenu(){
            var that = this;
            $(".left-side-inner").on('click','.menu-list a',function(){
                if($(this).parent().siblings().hasClass("nav-active")){
                    $(this).parent().siblings().removeClass("nav-active");
                }
                if($(this).parent().hasClass("nav-active")){
                    $(this).parent().removeClass("nav-active");
                }else{
                    $(this).parent().addClass("nav-active");
                }
            })
            $(".left-side-inner").on('click','.sub-menu-list li',function(){
                $(".custom-nav").find("li").removeClass("active");
                if($(this).siblings().hasClass("active")){
                    $(this).siblings().removeClass("active")
                }
                $(this).addClass("active");
                //页面切换
                vm.currentPage = $(this).attr("data");
            })
            //显示用户操作
            $("#operation").click(function () {
                $("#operation_list").toggle();
            })
        }
    }

})


