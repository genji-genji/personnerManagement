<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- 1、导入包 -->
    <script src="./lib/vue-2.4.0.js"></script>
</head>

<body>
    <div id="app">
        <p>{{msg}}</p>
    </div>
    <script>
        var vm = new Vue({
            // el:表示当前我们new的这个Vue实例要控制页面上的哪个区域 
            el: '#app',
            // data: data属性中 存放的是el中药用到的数据
            // 这里的data就是MVVM中的M 专门用来保存每个页面的数据  不建议里面的数据用data这个名字 
            data: {
                msg: '欢迎学习vue' //通过Vue提供的指令，很方便的就能把数据渲染到页面上，不再手动操作dom元素
            }
        })
    </script>
</body>

</html>