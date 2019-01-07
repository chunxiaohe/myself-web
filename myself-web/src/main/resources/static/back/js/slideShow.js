//上传的文件
var file;

var vm = new Vue({
    el: '#app',
    data: {},
    mounted() {
        var that = this;
        that.$nextTick(function () {
            that._initTable();
        });
    },
    methods: {
        _initTable() { // 初始化列表
            $("#jqGrid").jqGrid({
                url: createURL('/back/api/slideshow/list'),
                datatype: "json",
                mtype: 'get',
                colModel: [{
                    label: '图片地址',
                    name: 'address',
                    align: 'center',
                    sortable: false,
                }, {
                    label: '轮播顺序',
                    name: 'theOrder',
                    align: 'center',
                    sortable: false,
                    width: 40
                }, {
                    label: '创建人',
                    name: 'createName',
                    width: 40,
                    align: 'center',
                    sortable: false
                }, {
                    label: '创建时间',
                    name: 'createDate',
                    align: 'center',
                    width: 80,
                    sortable: false
                }, {
                    label: '更新人',
                    name: 'updateName',
                    width: 40,
                    align: 'center',
                    sortable: false
                }, {
                    label: '更新时间',
                    name: 'updateDate',
                    width: 80,
                    align: 'center',
                    sortable: false
                }, {
                    label: "备注",
                    name: 'remark',
                    align: 'center',
                    sortable: false,
                    width: 50
                }, {
                    label: '状态',
                    name: 'isUse',
                    width: 50,
                    align: 'center',
                    formatter: isUse,
                    sortable: false
                }, {
                    label: "操作",
                    name: '',
                    width: 100,
                    align: 'center',
                    sortable: false,
                    formatter: function (cellValue, options, cellObject) {
                        return "<input num='1' type='button'  @click='operate' class='btn btn-info' fileName='" + cellObject.fileName + "' ids='" + cellObject.id + "' value='查看'/>"
                            + "<input num='4' style='margin-left: 5px;' type='button'  @click='operate' class='btn btn-info' address='" + cellObject.address + "' ids='" + cellObject.id + "' value='编辑'/>"
                            + "<input num='2' style='margin-left: 5px;background-color: #ff0000' type='button'  @click='operate' class='btn btn-info' address='" + cellObject.address + "' ids='" + cellObject.id + "' value='删除'/>";
                    }
                }
                ],
                viewrecords: true,
                height: 480,
                rownumbers: true,
                rowNum: 10,
                rowList: [10, 30, 50, 80, 100],
                jsonReader: { //   后台分页参数的名字。
                    root: "records", // 表格数据
                    page: "page", // 页码
                    total: "total", // 总页数
                    records: "totalCount", // 总条数
                    repeatitems: false,
                },
                pager: "#jqGridPager",
                autowidth: true,
                hoverrows: true,
            });
            $("tbody").on('click', 'input[type=button]', function () {
                var id = $(this).attr('ids');
                var num = $(this).attr('num');
                if (num == 1) {
                    //查看
                    var fileName = $(this).attr('fileName');
                    showPic(fileName);
                } else if (num == 2) {
                    //删除
                    var address = $(this).attr('address');
                    deletePic(id, address);
                } else if (num == 3) {
                    //启用,禁用
                    var isUse = $(this).attr("isUse");
                    var type = $(this).attr("pay");
                    if (isUse == 1) {
                        layer.alert("确认禁用该图片?", {icon: 3, btn: ['确认', '取消']}, function (index) {
                            updatePayType(id, type, 2, index);
                        })
                    } else if (isUse == 2) {
                        layer.alert("确实启用该图片?", {icon: 3, btn: ['确认', '取消']}, function (index) {
                            updatePayType(id, type, 1, index);
                        })
                    } else {
                        layer.alert("操作异常!", {icon: 5})
                    }
                } else if (num === 4) {
                    //编辑
                } else {
                    layer.msg("操作异常", {icon: 5});
                }
            })
        },
        create() {
            layer.open({
                title: '上传轮播图',
                type: 2,
                content: createURL('/back/page/edit/slideshow'),
                area: ['30%', '52%'],
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var valided = document.getElementById($(layero).attr('id')).getElementsByTagName("iframe")[0].contentWindow.valid();
                    if (valided) {
                        var flag = document.getElementById($(layero).attr('id')).getElementsByTagName("iframe")[0].contentWindow.submitFile();
                        if (flag) {
                            setTimeout(function () {
                                layer.close(index);
                            }, 2000)
                            update();
                        }
                    } else {
                        layer.msg("基本信息不完整");
                    }
                }
            })
        }
    }
});

function isUse(cellValue, options, cellObject) {
    return cellObject.isUse == 1 ?
        "<input type='button' pay='" + cellObject.type + "' isUse='1' num='3' style='background-color: #00B83F'  class='btn btn-info' ids='" + cellObject.id + "' isUse='" + cellObject.isUse + "'  isUse='" + cellObject.isUse + "' value='启用'/> "
        : "<input type='button' pay='" + cellObject.type + "' isUse='2' num='3' style='background-color: #ff0000' class='btn btn-info' ids='" + cellObject.id + "' isUse='" + cellObject.isUse + "'  isUse='" + cellObject.isUse + "' value='禁用'/> ";
}

function update() {
    $("#jqGrid").setGridParam({
        datatype: 'json',
        page: 1
    }).jqGrid('setGridParam', {
        page: 1,
    }).trigger("reloadGrid");
}

//查看图片
function showPic(fileName) {
    var staticRoot = $('input[name="staticRoot"]').val();
    var imagePath = staticRoot + "/payType/" + fileName;
    //判断图片是否存在
    var flag = checkImg(imagePath);
    if (flag) {
        $('#payTypePic').attr('src', imagePath);
        layer.open({
            type: 1,
            title: false,
            closeBtn: 1,
            area: ['400px', '400px'],
            skin: 'layui-layer-nobg', // 没有背景色
            shadeClose: true,
            content: $('#payTypePic')
        });
    } else {
        layer.alert("查看的图片不存在", {icon: 5})
    }
}

//判断图片是否存在
function checkImg(imagePath) {
    var xmlHttp;
    //判断浏览器是否支持ActiveX控件
    if (window.ActiveXObject) {
        //支持-通过ActiveXObject的一个新实例来创建XMLHttpRequest对象
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    //不支持
    else if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest()
    }
    xmlHttp.open("Get", imagePath, false);
    xmlHttp.send();
    if (xmlHttp.status == 404) {
        return false;
    } else {
        return true;
    }
}

//删除图片
function deletePic(id, address) {
    layer.alert("删除不可恢复,确认删除?", {icon: 3, btn: ['确认', '取消']}, function (index) {
        $.get(createURL('/back/api/delete/payType'), {id: id, address: address}, function (re) {
            if (re.code == 200) {
                layer.msg(re.message, {icon: 1});
            } else if (re.code == 500) {
                layer.alert(re.message, {icon: 2});
            } else {
                layer.msg("操作异常", {icon: 2});
            }
            layer.close(index);
            update();
        })
    })
}

function updatePayType(id, type, isUse, index) {
    $.post(createURL('/back/api/update/payType'), {id: id, isUse: isUse, type: type}, function (re) {
        if (re.code == 200) {
            layer.msg(re.message, {icon: 1});
            update()
        } else if (re.code == 500) {
            layer.msg(re.message, {icon: 2})
        } else {
            layer.msg("操作异常", {icon: 2});
        }
        layer.close(index)
    })
}