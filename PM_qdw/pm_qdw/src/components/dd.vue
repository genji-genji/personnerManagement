<form id="main" v-cloak>
 
    <h1>Services</h1>
 
    <ul>
 
        <!-- 循环输出 services 数组, 设置选项点击后的样式 -->
 
        <li v-for="service in services" v-on:click="toggleActive(service)" v-bind:class="{ 'active': service.active}">
 
            <!-- 显示订单中的服务名，价格
                 Vue.js 定义了货币过滤器，用于格式化价格 -->
 
            {{service.name}} <span>{{service.price | currency}}</span>
 
        </li>
    </ul>
 
    <div class="total">
 
        <!-- 计算所有服务的价格，并格式化货币 -->
 
        Total: <span>{{total() | currency}}</span>
        
    </div>
 
</form>
<script>
 
// 自定义过滤器 "currency". 
Vue.filter('currency', function (value) {
    return '$' + value.toFixed(2);
});
 
var demo = new Vue({
    el: '#main',
    data: {
        // 定义模型属性 the model properties. The view will loop
        // 视图将循环输出数组的数据
        services: [
            {
                name: 'Web Development',
                price: 300,
                active:true
            },{
                name: 'Design',
                price: 400,
                active:false
            },{
                name: 'Integration',
                price: 250,
                active:false
            },{
                name: 'Training',
                price: 220,
                active:false
            }
        ]
    },
    methods: {
        toggleActive: function(s){
            s.active = !s.active;
        },
        total: function(){
 
            var total = 0;
 
            this.services.forEach(function(s){
                if (s.active){
                    total+= s.price;
                }
            });
 
           return total;
        }
    }
});
    
</script>