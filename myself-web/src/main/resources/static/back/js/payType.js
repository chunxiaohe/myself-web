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
                url: createURL('/back/api/payType/list'),
                datatype: "json",
                mtype: 'get',
                colModel: [{
                    label: '图片地址',
                    name: 'address',
                    align: 'center',
                    sortable: false,
                }, {
                    label: '类型',
                    name: 'type',
                    align: 'center',
                    width: 50,
                    sortable: false,
                    formatter:function (cellValue,options,cellObject) {
                        return cellObject.type==1 ? '微信':'支付宝'
                    }
                }, {
                    label: '创建时间',
                    name: 'createDate',
                    align: 'center',
                    width: 110,
                    sortable: false
                }, {
                    label: '创建人',
                    name: 'createBy',
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
                    label: '更新人',
                    name: 'updateBy',
                    width: 60,
                    align: 'center',
                    sortable: false
                }, {
                    label: "备注",
                    name: 'remark',
                    align: 'center',
                    sortable: false,
                }, {
                    label: "操作",
                    name: '',
                    width: 100,
                    align: 'center',
                    sortable: false,
                    formatter: function (cellValue, options, cellObject) {
                        return "<input type='button'  @click='operate' class='btn btn-info' ids='" + cellObject.id + "' value='查看'/>"
                                +"<input style='margin-left: 5px;background-color: #ff0000' type='button'  @click='operate' class='btn btn-info' ids='" + cellObject.id + "' value='删除'/>";
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
                layer.alert("删除不可恢复,确认删除?", {icon: 3, btn: ['确认', '取消']}, function (index) {
                    $.get(createURL('/back/api/delete/payType'), {id: id}, function (re) {
                        if (re.code == 200) {
                            layer.msg(re.message, {icon: 1});
                        } else {
                            layer.msg('操作异常', {icon: 2});
                        }
                        layer.close(index);
                        update();
                    })
                })
            })
        },
        create() {
            layer.open({
                title: '上传支付二维码',
                content: teamplateHtml,
                area: ['30%', '52%'],
                btn: ['确定', '取消'],
                yes: function (index, layero) {

                }
            })
        }
    }
});

function update() {
    $("#jqGrid").setGridParam({
        datatype: 'json',
        page: 1
    }).jqGrid('setGridParam', {
        page: 1,
    }).trigger("reloadGrid");
}

var teamplateHtml =" <div class='form-group'>"
    +"<label for=''>选择图片</label>"
    +"<input class='form-control' style='width: 80%'>"
    +"<a  class='a-upload '>" +
    "    <input  type='file' name='' id=''>上传图片" +
    "</a>"
    +"</div>"
    +"<div class='form-group'>"
    +"<label for=''>支付方式</label>"
    +"<select name='isUse' id='isUse' class='form-control'>"
    +"<option value='1' >微信</option>"
    +"<option value='2'>支付宝</option>"
    +"</select>"
    +"</div>"
    +"<div class='form-group'>"
    +"<label for=''>备注</label>"
    +"<textarea class='form-control' rows='3' name='remark' ></textarea>"
    +"</div>"

$(function () {
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
                //请求异常回调
            }
        });
    });
})