// <script>
//     // 用于前端vue与websocket连接的脚本，暂存
//     // import HelloWorld from './components/HelloWorld.vue'
//
//     export default {
//     name: 'App',
//     components: {
//     // HelloWorld
// },
//     data() {
//     return{
//     userToken:''
// }
// },
//
//     created: function(){
//     this.initWebSocket();
// },
//
//     beforeUnmount: function () {
//     this.websock.close()
// },
//
//     methods:{
//     initWebSocket: function () {
//     this.websock = new WebSocket("ws://localhost:8080/websocket/zhanghc");
//     this.websock.onopen =this.websocketonopen;
//     this.websock.onerror = this.websocketonerror;
//     this.websock.onmessage = this.websocketonmessage;
//     this.websock.onclose = this.websocketclose;
// },
//     websocketonopen: function () {
//     console.log("websocket 连接成功");
// },
//     websocketonerror: function () {
//     console.log("websocket 连接发生错误");
// },
//     // 对websocket接收到的数据进行处理
//     websocketonmessage: function (e) {
//     var da = JSON.parse(e.data);
//     console.log(da.city)
//     console.log(da.latitude)
//     console.log(da.longitude)
// },
//     websocketclose: function () {
//     console.log("connection closed");
// }
// }
// }
// </script>