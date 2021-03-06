var vm = new Vue({
    el: '#app',
    data: {
        templateHTML: ''
    },
    mounted() {
        var that = this;
        that.$nextTick(function () {
            that._initTable();
        });
    },
    methods: {
        toggleSearchForm() {
            $('#searchForm').toggle();
        },
        _initTable() { // 初始化列表
            $("#jqGrid").jqGrid({
                url: createURL('back/api/articleClass/list'),
                datatype: "json",
                mtype: 'get',
                colModel: [{
                    label: '分类名称',
                    name: 'typeName',
                    align: 'center',
                    sortable: false,
                    editable: true,
                }, {
                    label: '创建人',
                    name: 'createName',
                    width: 60,
                    align: 'center',
                    sortable: false
                }, {
                    label: '创建时间',
                    name: 'createDate',
                    align: 'center',
                    width: 110,
                    sortable: false
                }, {
                    label: '更新人',
                    name: 'updateName',
                    width: 60,
                    align: 'center',
                    sortable: false
                }, {
                    label: '更新时间',
                    name: 'updateDate',
                    width: 110,
                    align: 'center',
                    sortable: false
                }, {
                    label: "备注",
                    name: 'remark',
                    align: 'center',
                    sortable: false,
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
                        return "<input type='button' num='1' @click='update' class='btn btn-info' ids='" + cellObject.id + "' value='编辑'/> "
                            + "<input type='button' num='2' @click='operate' class='btn btn-info' ids='" + cellObject.id + "' value='删除'/> ";
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
                var num = $(this).attr('num');
                var id = $(this).attr('ids');
                if (num == 1) {//编辑
                    layer.open({
                        title: '编辑文章分类',
                        type: 2,
                        content: createURL("/back/page/addArticleClass?id="+id),
                        area: ['30%', '52%'],
                        btn: ['确定', '取消'],
                        yes: function (index, layero) {
                            var valided = document.getElementById($(layero).attr('id')).getElementsByTagName('iframe')[0].contentWindow.valid();
                            if (valided) {
                                var flag = document.getElementById($(layero).attr('id')).getElementsByTagName('iframe')[0].contentWindow.submitData(1,id);
                                if (flag) {
                                    setTimeout(function () {
                                        layer.close(index);
                                    }, 2000);
                                    update();
                                }
                            } else {
                                layer.msg("基本属性不完整");
                            }
                        }
                    })
                } else if (num == 2) {
                    layer.alert("删除不可恢复,确认删除?", {icon: 3, btn: ['确认', '取消']}, function (index) {
                        $.get(createURL('/back/api/articleClass/delete'), {id: id}, function (re) {
                            if (re.code == 200) {
                                layer.msg(re.message, {icon: 1});
                            }else if(re.code==500){
                                layer.alert(re.message,{icon:2});
                            } else {
                                layer.msg('操作异常', {icon: 2});
                            }
                            layer.close(index);
                            update();
                        })
                    })
                } else if (num == 3) {
                    var isUse = $(this).attr('isUse');
                    if (isUse == 1) {
                        layer.alert("确认禁用该文章分类?", {icon: 3, btn: ['确认', '取消']}, function (index) {
                            updateIsUse(id, 2, index);
                        })
                    } else if (isUse == 2) {
                        layer.alert("确实启用该文章分类?", {icon: 3, btn: ['确认', '取消']}, function (index) {
                            updateIsUse(id, 1, index);
                        })
                    } else {
                        layer.alert("操作异常!", {icon: 5})
                    }
                } else {
                    layer.alert("操作异常!", {icon: 5})
                }
            })
        },
        reset() {
            $("#typeName").val('');
            $("#isUse").val('');
            update();
        },
        search() {
            var typeName = $('#typeName').val();
            var isUse = $('#isUse').val();
            $("#jqGrid").setGridParam({
                datatype: 'json',
                page: 1
            }).jqGrid('setGridParam', {
                page: 1,
                postData: {
                    typeName: typeName,
                    isUse: isUse == 0 ? null : isUse
                }
            }).trigger("reloadGrid");
        },
        create() {
            layer.open({
                title: '新增文章分类',
                type: 2,
                content: createURL("/back/page/addArticleClass?id="),
                area: ['30%', '52%'],
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var valided = document.getElementById($(layero).attr('id')).getElementsByTagName('iframe')[0].contentWindow.valid();
                    if (valided) {
                        var flag = document.getElementById($(layero).attr('id')).getElementsByTagName('iframe')[0].contentWindow.submitData(2);
                        if (flag) {
                            setTimeout(function () {
                                layer.close(index);
                            }, 2000);
                            update();
                        }
                    } else {
                        layer.msg("基本属性不完整");
                    }
                }
            })
        }
    }
});

function isUse(cellValue, options, cellObject) {

    return cellObject.isUse == 1 ?
        "<input type='button' num='3' style='background-color: #00B83F'  class='btn btn-info' ids='" + cellObject.id + "' isUse='" + cellObject.isUse + "' value='启用'/> "
        : "<input type='button' num='3' style='background-color: #ff0000' class='btn btn-info' ids='" + cellObject.id + "' isUse='" + cellObject.isUse + "' value='禁用'/> ";
}

function updateIsUse(id, isUse, index) {
    $.get(createURL('/back/api/articleClass/update'), {id: id, isUse: isUse}, function (re) {
        if (re.code == 200 && isUse == 1) {
            layer.msg("启用成功", {icon: 1});
            layer.close(index);
            $("#jqGrid").trigger("reloadGrid");
        } else if (re.code = 200 && isUse == 2) {
            layer.msg("禁用成功", {icon: 1});
            layer.close(index);
            $("#jqGrid").trigger("reloadGrid");
        } else if (re.code == 500) {
            layer.alert(re.message, {icon: 2});
        } else {
            layer.msg("操作参数异常", {iocn: 2});
        }
    })
}

function update() {
    $("#jqGrid").setGridParam({
        datatype: 'json',
        page: 1
    }).jqGrid('setGridParam', {
        page: 1,
        postData: {
            typeName: null,
            isUse: null
        }
    }).trigger("reloadGrid");
}


