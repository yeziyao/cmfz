<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: '持明法洲App用户使用'
        },
        tooltip: {},
        legend: {
            data: ['男女比例']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: []
        }]
    });

    $(function () {
        /*$.getJSON("http://localhost:8989/user/query",function (data) {
            console.log(data);
            myChart.setOption({
                xAxis: {
                    data: data.sexes
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '数量',
                    data: data.counts
                }]
            });
        });*/
        $.post("http://localhost:8989/user/query", function (data) {
                console.log(data);
                myChart.setOption({
                    xAxis: {
                        data: data.sexes
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '数量',
                        data: data.counts
                    }]
                });
            },"json"
        );
    });


</script>