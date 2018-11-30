/**
 * ajax 请求
 * 
 * @param {Object} opt 请求配置项
 * 
 */
function loadData(opt) {
    //将loading效果展示到父层，以置灰整个页面，如何没有父层，parent对象就等于当前self对象
    var index = parent.layer.load(0, {
        time: 50*1000
    });

    function fn() {}
    var url = opt.url || "",
        method = opt.type || 'GET',
        datas = opt.data || null;
    var contentType = opt.contentType || "application/x-www-form-urlencoded";
    var dataType = opt.dataType || "json",
        traditional = opt.traditional !== false;
    var successFn = opt.success || fn,
        errorFn = opt.error || fn;

    $.ajax({
        type: method,
        url: url,
        async: true,
        data: datas,
        dataType: dataType,
        traditional: traditional,
        contentType: contentType,
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