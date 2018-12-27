var editor;
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
        }
    }
})

/**
 * 数据提交
 */
function submitDate() {
    var article = getSArticle();
    if (article != null) {
        $.ajax.async=false;
        $.post(createURL('/back/api/article/insert'), article, function (re) {
            if (re.code == 200) {
                vm.articleId = re.data[0];
                layer.msg(re.message, {icon: 1})
            } else if (re.code == 500) {
                layer.alert(re.message, {icon: 1})
            } else {
                layer.alert("系统异常");
            }
        });
    }
}

/**
 * 数据获取
 */
function getSArticle() {
    var article = {};
    var flag = true;
    article.id = $("input[name='title']").attr("articleId");
    article.title = $("input[name='title']").val();
    article.articleClassId = $("select[name='articleClassId']").val();
    article.keyword = $("input[name='keyword']").val();
    article.createBy = $("input[name='createBy']").attr("createBy");
    article.createDate = $("input[name='createDate']").val();
    article.content = editor.txt.html();
    var text = editor.txt.text();
    if (article.title == null || article.title.trim() === '') {
        layer.alert("文章名不能为空", {src: 2});
        flag = false;
    }
    if (text == null || text.trim() === '') {
        layer.alert("文章内容不能为空");
        flag = false;
    }
    if (flag) {
        return article;
    }
}
