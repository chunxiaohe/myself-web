<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="${staticRoot}/core/js/vue/vue.js" charset="utf-8"></script>
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>
<body>
<div id="app">
    <template >
        <el-button>默认按钮</el-button>
        <el-button type="primary">主要按钮</el-button>
        <el-button type="success">成功按钮</el-button>
        <el-button type="info">信息按钮</el-button>
        <el-button type="warning">警告按钮</el-button>
        <el-button type="danger">危险按钮</el-button>
        <el-input style="width: auto"></el-input>
        <el-input style="width: auto"></el-input>

        <template>
            <el-checkbox>备选项1</el-checkbox>
            <el-checkbox>备选项</el-checkbox>
        </template>
        <template>
            <el-checkbox>备选项1</el-checkbox>
            <el-checkbox>备选项</el-checkbox>
        </template>

        <template>
            <el-button :plain="true" @click="open" type="warning">打开消息提示</el-button>
            <el-button :plain="true" @click="openVn">VNode</el-button>
        </template>
        <el-form style="width: 50%">
            <el-form-item>
                <el-button>zhuyaoanni</el-button>
                <el-button>zhuyaoanni</el-button>
            </el-form-item>
            <el-form-item>
                <el-input value="输入框1"></el-input>
                <el-input value="输入框2"></el-input>
            </el-form-item>
        </el-form>
    </template>

</div>

</body>

<script>
    new Vue({
        el: '#app',
        methods: {
            open() {
                this.$message('这是一条消息提示');
            },
            openVn() {
                const h = this.$createElement;
                this.$message({
                    message: h('p', null, [
                        h('span', null, '内容可以是 '),
                        h('i', {style: 'color: teal'}, 'VNode')
                    ])
                });
            },
        }
    });
</script>

</html>