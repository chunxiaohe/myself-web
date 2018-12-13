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
            console.log("1111111111111")
            $("#jqGrid").jqGrid({
                url: createURL('back/api/list/articleClass'),
                datatype: "json",
                mtype: 'get',
                colModel: [{
                        label: 'id',
                        name: 'id'
                    }, {
                        label: '分类名称',
                        name: 'typeName'
                    }, {
                        label: '创建时间',
                        name: 'createDate',
                    }, {
                        label: '创建人',
                        name: 'createBy'
                    }, {
                        label: '更新时间',
                        name: 'updateDate'
                    }, {
                        label: '更新人',
                        name: 'updateBy'
                    }, {
                        label: '启用',
                        name: 'isUse'

                    },{
                        label:"备注",
                        name:'remark'
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
            layer.open({
                title:'新增文章分类',
                type:2,
                content:createURL("/back/page/addArticleClass"),
                area:['30%','52%'],
                btn:['确定','取消'],
                yes:function(index,layero){
                    var valided = document.getElementById($(layero).attr('id')).getElementsByTagName('iframe')[0].contentWindow.valid();
                    if(valided){
                        document.getElementById($(layero).attr('id')).getElementsByTagName('iframe')[0].contentWindow.submitData(index);
                    }else{
                        layer.msg("基本属性不完整,请按要求填写!",{icon:2});
                    }
                }
            })
        }
    }
});





