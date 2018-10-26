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
                if(re.code==200 && re.data.length>0){
                    that.treeData = re.data;
                }
            });
            //点击展开子菜单/更新样式
            that.showsubmenu();
        })
    },
    methods:{
        showsubmenu(){
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
            })
        }
    }

})


