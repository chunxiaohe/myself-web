$(function () {
    var reg = new RegExp("(^|&)errorMsg=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if(r != null){
        console.log(decodeURI(r[2]));
        var msg = decodeURI(r[2]);
        layer.msg(msg,{icon:2,time:2000});
    }
})