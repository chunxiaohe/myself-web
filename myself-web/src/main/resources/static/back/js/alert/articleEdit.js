var editor;
var file;
var vm = new Vue({
    el: '#app',
    data: {
        articleId: ''
    },
    mounted() {
        var that = this;
        that.$nextTick(function () {
            //初始化富文本编辑器
            that._initWangEditor();
            that.checkPreview();
        });
    },
    methods: {
        _initWangEditor() {
            var E = window.wangEditor;
            //var face = new Array();
            editor = new E('#toolbar', '#editor');
            //显示本地上传图片的tab
            editor.customConfig.uploadImgShowBase64 = true;  // 使用 base64 保存图片
            //editor.customConfig.uploadImgServer = '';
            // 隐藏“网络图片”tab
            editor.customConfig.showLinkImg = false
            //初始化表情(新浪微博表情)
            editor.customConfig.emotions = [
                {
                    // tab 的标题
                    title: '新浪微博',
                    // type -> 'emoji' / 'image'
                    type: 'image',
                    // content -> 数组
                    content: [
                        {
                            alt: "[草泥马]",
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7a/shenshou_thumb.gif"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/60/horse2_thumb.gif",
                            alt: "[神马]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/fuyun_thumb.gif",
                            alt: "[浮云]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c9/geili_thumb.gif",
                            alt: "[给力]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f2/wg_thumb.gif",
                            alt: "[围观]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/vw_thumb.gif",
                            alt: "[威武]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6e/panda_thumb.gif",
                            alt: "[熊猫]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/81/rabbit_thumb.gif",
                            alt: "[兔子]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/otm_thumb.gif",
                            alt: "[奥特曼]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/15/j_thumb.gif",
                            alt: "[囧]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/89/hufen_thumb.gif",
                            alt: "[互粉]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c4/liwu_thumb.gif",
                            alt: "[礼物]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/ac/smilea_thumb.gif",
                            alt: "[呵呵]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/0b/tootha_thumb.gif",
                            alt: "[嘻嘻]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6a/laugh.gif",
                            alt: "[哈哈]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/14/tza_thumb.gif",
                            alt: "[可爱]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/af/kl_thumb.gif",
                            alt: "[可怜]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a0/kbsa_thumb.gif",
                            alt: "[挖鼻屎]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f4/cj_thumb.gif",
                            alt: "[吃惊]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6e/shamea_thumb.gif",
                            alt: "[害羞]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c3/zy_thumb.gif",
                            alt: "[挤眼]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/29/bz_thumb.gif",
                            alt: "[闭嘴]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/71/bs2_thumb.gif",
                            alt: "[鄙视]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/lovea_thumb.gif",
                            alt: "[爱你]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/9d/sada_thumb.gif",
                            alt: "[泪]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/19/heia_thumb.gif",
                            alt: "[偷笑]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/8f/qq_thumb.gif",
                            alt: "[亲亲]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/b6/sb_thumb.gif",
                            alt: "[生病]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/mb_thumb.gif",
                            alt: "[太开心]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/17/ldln_thumb.gif",
                            alt: "[懒得理你]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/98/yhh_thumb.gif",
                            alt: "[右哼哼]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/zhh_thumb.gif",
                            alt: "[左哼哼]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a6/x_thumb.gif",
                            alt: "[嘘]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/af/cry.gif",
                            alt: "[衰]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/73/wq_thumb.gif",
                            alt: "[委屈]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/9e/t_thumb.gif",
                            alt: "[吐]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f3/k_thumb.gif",
                            alt: "[打哈欠]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/27/bba_thumb.gif",
                            alt: "[抱抱]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7c/angrya_thumb.gif",
                            alt: "[怒]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/5c/yw_thumb.gif",
                            alt: "[疑问]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/a5/cza_thumb.gif",
                            alt: "[馋嘴]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/88_thumb.gif",
                            alt: "[拜拜]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/e9/sk_thumb.gif",
                            alt: "[思考]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/24/sweata_thumb.gif",
                            alt: "[汗]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7f/sleepya_thumb.gif",
                            alt: "[困]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6b/sleepa_thumb.gif",
                            alt: "[睡觉]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/90/money_thumb.gif",
                            alt: "[钱]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/0c/sw_thumb.gif",
                            alt: "[失望]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/cool_thumb.gif",
                            alt: "[酷]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/8c/hsa_thumb.gif",
                            alt: "[花心]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/49/hatea_thumb.gif",
                            alt: "[哼]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/36/gza_thumb.gif",
                            alt: "[鼓掌]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d9/dizzya_thumb.gif",
                            alt: "[晕]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/1a/bs_thumb.gif",
                            alt: "[悲伤]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/62/crazya_thumb.gif",
                            alt: "[抓狂]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/91/h_thumb.gif",
                            alt: "[黑线]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6d/yx_thumb.gif",
                            alt: "[阴险]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/89/nm_thumb.gif",
                            alt: "[怒骂]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/hearta_thumb.gif",
                            alt: "[心]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/ea/unheart.gif",
                            alt: "[伤心]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/58/pig.gif",
                            alt: "[猪头]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d6/ok_thumb.gif",
                            alt: "[ok]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d9/ye_thumb.gif",
                            alt: "[耶]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d8/good_thumb.gif",
                            alt: "[good]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c7/no_thumb.gif",
                            alt: "[不要]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d0/z2_thumb.gif",
                            alt: "[赞]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/40/come_thumb.gif",
                            alt: "[来]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d8/sad_thumb.gif",
                            alt: "[弱]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/91/lazu_thumb.gif",
                            alt: "[蜡烛]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/6a/cake.gif",
                            alt: "[蛋糕]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/d3/clock_thumb.gif",
                            alt: "[钟]"
                        }, {
                            src: "http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/1b/m_thumb.gif",
                            alt: "[话筒]"
                        }
                    ]
                }
            ]

            editor.create();
        },
        lookPreview() {
            console.log()
            var fileName = $("input[name='fileName']").val();
            if (fileName === "") {
                layer.alert("您查看的预览图片不存在", {icon: 5})
            } else {
                var updateDate = $("#updateDate").val();
                var staticRoot = $("input[name='staticRoot']").val();
                var dirPr = updateDate.substring(0, 10);
                //判断图片是否存在
                var imagePath = staticRoot + "/preview/" + dirPr + "/" + fileName;
                var flag = checkImg(imagePath);
                if (flag) {
                    $('#previewPic').attr('src', imagePath);
                    layer.open({
                        type: 1,
                        title: false,
                        closeBtn: 1,
                        area: ['400px', '400px'],
                        skin: 'layui-layer-nobg', // 没有背景色
                        shadeClose: true,
                        content: $('#previewPic')
                    });
                } else {
                    layer.alert("服务器上不存在您查看的预览图,请重新上传提交再进行查看!", {icon: 5})
                }
            }
        },
        checkPreview() {
            $('#file').on('change', function () {
                //验证文件的格式
                file = $("#file")[0].files;
                if (file[0].type.indexOf("image/") == -1) {
                    layer.msg('请选择图片上传', {icon: 2});
                    var previewName = $("#previewName").val();
                    console.log(previewName);
                    if (previewName === '') {
                        $("#file").val('');
                    } else {
                        $("#file").val(previewName);
                    }
                    $("input[name='fileName']").val('');
                } else {
                    $("input[name='fileName']").val(file[0].name);
                }
            })
        }
    }
})

/**
 * 数据提交
 */
function submitDate() {
    var data = getSArticle();
    if (data != null) {
        var formData = new FormData();
        /*if (file != null){
            formData.append("file",file);
            formData.append("article",article);
        } else {
            formData.append("article",article);
        }*/
        $.ajax({
            url:createURL('/back/api/article/insert'),
            type:'post',
            data:data,
            contentType:false,//必须
            processData:false,//用于对data参数进行序列化处理 这里必须false
            cache: false,//上传文件无需缓存
            async: false,
            traditional:true,
            success:function (re) {
                if (re.code == 200) {
                    vm.articleId = re.data[0];
                    layer.msg(re.message, {icon: 1})
                } else if (re.code == 500) {
                    layer.alert(re.message, {icon: 1})
                } else {
                    layer.alert("系统异常");
                }
            }
        })

    }
}

/**
 * 数据获取
 */
function getSArticle() {
    let flag = true;
    let formData = new FormData();
    let id = $("input[name='title']").attr("articleId");
    let title = $("input[name='title']").val();
    let articleClassId = $("select[name='articleClassId']").val();
    let keyword = $("input[name='keyword']").val();
    let createBy = $("input[name='createBy']").attr("createBy");
    let createDate = $("input[name='createDate']").val();
    let previewName = $("#previewName").val();
    let content = editor.txt.html();
    let text = editor.txt.text();
    if (title == null || title.trim() === '') {
        layer.alert("文章名不能为空", {src: 2});
        flag = false;
    }
    if (text == null || text.trim() === '') {
        layer.alert("文章内容不能为空");
        flag = false;
    }
    if (flag) {
        formData.append("id",id);
        formData.append("title",title);
        formData.append("articleClassId",articleClassId);
        formData.append("keyword",keyword);
        formData.append("createBy",createBy);
        formData.append("createDate",createDate);
        formData.append("previewName",previewName);
        formData.append("content",content);
        if(typeof (file) !== "undefined"){
            formData.append("file",file[0]);
        }else{
            formData.append("file",'');
        }
        return formData;
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