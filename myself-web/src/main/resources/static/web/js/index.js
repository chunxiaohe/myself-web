var vm = new Vue({
	el:"#app",
	data:{
		menuList:[]
	},
	mounted(){
		var that = this;
		that.$nextTick(function(){
			that.getMenuList();
			that.openClick();
		});
	},
	methods:{
		getMenuList(){
			$.get("/menu/getMyselfMenuList",function(re){
				vm.menuList = re.data;
			});
		},
		openClick(){
			$(".menu").on('click','li',function(){
				//var url= this.data("url-data");
				//alert("url")
			});
		}
	}
})