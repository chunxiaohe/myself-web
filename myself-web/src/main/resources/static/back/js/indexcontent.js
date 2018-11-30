var vm = new Vue({
    el:"#app",
    data:{
        IP:'',
        city:''
    },
    mounted(){
        var that = this;
        that.$nextTick(function () {
            //初始前七日访问量的对比
            that._initVisitCompare();
        });
    },
    methods:{
        _initVisitCompare(){
            visitCompare();
            visitCompareMap();
        }
    }
});

//7日访问对比分析
function visitCompare(){
    var date = new Date();
    //前一天
    var data = [6,5,4,3,2,1,0];
    var dataTime = [];
    for (var num of data) {
        dataTime.push(new Date(date.getTime()-num*24*60*60*1000).getDate())
    }

    var visitCompare =  echarts.init( $("#visitCompare")[0]);
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['访问量']
        },
        xAxis: [
            {
                type: 'category',
                data: dataTime,
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '访问量/(人次)',
            }
        ],
        series: [
            {
                name:'访问量',
                type:'bar',
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6 ]
            }
        ]
    };
    visitCompare.setOption(option);
}

//访问地理分布
function visitCompareMap(){
    //var visitCompare =  echarts.init( $("#visitCompareMap")[0]);


}



