var vm = new Vue({
        el: '#app',
        data: {
            articleClassList: []
        },
        mounted() {
            var that = this;
            that.$nextTick(function () {
                //初始化富文本编辑器
                that._initWangEditor();
            });
        },
        methods: {
            _initWangEditor(){
                var E = window.wangEditor;
                var editor = new E('#toolbar','#editor');
                // 或者 var editor = new E( document.getElementById('editor') )
                editor.create();
            }

        }
    })

