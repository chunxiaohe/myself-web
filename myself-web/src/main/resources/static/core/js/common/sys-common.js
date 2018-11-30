/**
 * ajax 请求
 * 
 * @param {Object} opt 请求配置项
 * 
 */
function commonAjax(opt) {
    //将loading效果展示到父层，以置灰整个页面，如何没有父层，parent对象就等于当前self对象
    var index = parent.layer.load(0, {
        time: 50 * 1000
    });
    var defaultOpt = {
        contentType :  "application/x-www-form-urlencoded",
        dataType : "json",
        traditional : false
    }
    $.extend(opt, defaultOpt);
    function fn() {}
    var successFn = opt.success || fn,
        errorFn = opt.error || fn;

    $.ajax({
        type: opt.method,
        url: opt.url,
        data: opt.data,
        dataType: opt.dataType,
        traditional: opt.traditional,
        contentType: opt.contentType,
        success: function(data) {
            parent.layer.close(index);
            successFn(data);
        },
        error: function() {
            parent.layer.close(index);
            errorFn();
        }
    });
}

/**
 * 日期格式化
 * 
 * @param {String} fmt  日期格式
 * @return 返回最终的日期格式
 */
Date.prototype.Format = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds()
            // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

//重写alert
window.alert = function(msg, callback){
    parent.layer.alert(msg,{skin: 'layui-layer-molv', closeBtn: 0}, function(index){
        parent.layer.close(index);
        if(typeof(callback) === "function"){
            callback("ok");
        }
    });
};
//重写confirm式样框
window.confirm = function(msg, callback){
    parent.layer.confirm(msg, {btn: ['确定','取消']},
        function(){//确定事件
            if(typeof(callback) === "function"){
                callback("ok");
            }
        });
};

//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';
$.jgrid.defaults.datatype = "json";
jQuery.extend($.jgrid.defaults, {
    datatype: "json",
    mtype: 'get',
    viewrecords: true,
    height: 600,
    rownumbers: true,
    rowNum: 10,
    rowList: [10, 30, 50, 80, 100],
    jsonReader: { //   后台分页参数的名字。
        root: "data.records", // 表格数据
        page: "data.current", // 页码
        total : "data.pages",
        records: "data.total"// 总条数
    },
    pager: "#jqGridPager",
    autowidth : true,
    hoverrows : true,
    multiselect : true,
    gridComplete : function(){
        //隐藏grid底部滚动条
        $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
    }
});

//选择一条记录
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
        alert("请选择一条记录");
        return ;
    }
    var selectedIDs = grid.getGridParam("selarrrow");
    if(selectedIDs.length > 1){
        alert("只能选择一条记录");
        return ;
    }
    return selectedIDs[0];
}

//选择多条记录
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
        alert("请选择一条记录");
        return ;
    }
    return grid.getGridParam("selarrrow");
}