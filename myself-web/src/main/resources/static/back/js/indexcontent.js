// 基于准备好的dom，初始化echarts实例
/*var myChart = echarts.init($("#demo1")[0]);
var data1 = [70, 62, 56, 85, 85, 85];
var data2 = [10,20,15,30,18,22];
var max = Math.max.apply(null,data1);
var arr = [];
for (var i=0;i<data1.length;i++){
    if(max===data1[i]){
        var a = i;
        arr.push(a++);
    }
}
var data =[];
for(var i=0;i<arr.length;i++){
    data.push({name:'最高销量',value:max,xAxis:arr[i],yAxis:max});
}
// 指定图表的配置项和数据
var option = {
    title: {
        text: 'ECharts Demo1',
        textStyle:{
            color:"red"
        },
        subtext:'第二标题',
        subtextStyle:{
            color:'red',
            fontSize:'60px'
        }
    },
    backgroundColor: '#ACAEA0',
    tooltip: {
        trigger:'axis',
        axisPointer:{
            type:'cross'
        },
        backgroundColor: 'white',
        textStyle:{
            color:'black'
        }
    },
    grid: {
        left: '3%',
        right: '6%',
        bottom: '3%',
        containLabel: true
    },
    legend: {
        data:['销量','金额']
    },
    xAxis: {
        boundaryGap:false,
        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
    },
    yAxis: {},
    series: [{
        name:'销量',
        type: 'line',
        data: data1,
        markLine:{
            data:[{type:'average',name:'平均值'}]
        },
        markPoint:{
            data:data
        }
    }, {
        name:'金额',
        type:"line",
        data:data2,
        //areaStyle:{}
    }]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);*/


var vm = new Vue({
    el:"#app",
    data:{
        IP:'',
        city:''
    },
    mounted(){
        var that = this;
        that.$nextTick(function () {
            //初始化城市和IP

        });
    },
    methods:{
    }
});
