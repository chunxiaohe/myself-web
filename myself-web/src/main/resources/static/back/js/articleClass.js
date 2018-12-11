var vm = new Vue({
    el: '#app',
    data: {
        templateHTML: ''
    },
    mounted() {
        var that = this;
        that.$nextTick(function() {
            that._initTable();
        });
    },
    methods: {
        toggleSearchForm() {
            $('#searchForm').toggle();
        },
        _initTable() { // 初始化列表
            $("#jqGrid").jqGrid({
                url: "",
                datatype: "json",
                mtype: 'get',
                colModel: [{
                        label: 'id',
                        name: ''
                    }, {
                        label: '类型',
                        name: ''
                    }, {
                        label: '备注',
                        name: ''
                    }, {
                        label: '创建时间',
                        name: '',
                    }, {
                        label: '创建人',
                        name: ''
                    }, {
                        label: '更新时间',
                        name: ''
                    }, {
                        label: '更新人',
                        name: ''
                    }, {
                        label: '备注',
                        name: ''

                    },{
                        label:"启用",
                        name:''
                    }, {
                        label:"操作",
                        name:''
                    }
                ],
                viewrecords: true,
                height: 600,
                rownumbers: true,
                rowNum: 10,
                rowList: [10, 30, 50, 80, 100],
                jsonReader: { //   后台分页参数的名字。
                    root: "", // 表格数据
                    page: "", // 页码
                    total: "", // 总页数
                    records: "", // 总条数
                    repeatitems: false,
                },
                pager: "#jqGridPager",
                autowidth: true,
                hoverrows: true,
            });
            $("tbody").on('click','input[type=button]',function(){
                var orderId = $(this).attr('orderId');
                var operationType = $(this).attr('operationType');
                var agcUserId = $(this).attr('agcUserId');
                if(orderId != null && orderId != ''){
                    if(operationType==='10'){//审核
                        check(orderId);
                    }
                    if(operationType==='20'){//发货
                        var orderNo = $(this).attr('orderNo');
                        shipments(orderId,orderNo,agcUserId);
                    }
                }
            })
        },
        reset() {
            console.log('重置')
        },
        search() {
            console.log('查询')
            /*$("#jqGrid").setGridParam({
                datatype: 'json',
                page: 1
            }).jqGrid('setGridParam', {
                page: 1,
                postData: {

                }
            }).trigger("reloadGrid");*/
        },
        create(){
            console.log('新建')
        }
    }
});





