
$(function () {
    $("#page").click(function () {
        $.get("page/background",function (re) {
            $("#pageContent").empty();
            $("#pageContent").append(re);
        });
    });
    $("#page2").click(function () {
        $.get("page2/background",function (re) {
            $("#pageContent").empty();
            $("#pageContent").append(re);
        });
    });
});