<template>
    <div id="chartColumn" style="width: 100%; height: 400px;">
    </div>
</template>

<script>
    export default {
        name: "chart",
        data(){
            return {
                chartColumn: null
            }
        },
        mounted() {
            this.drawLine();
        },
        methods: {
            drawLine(){
                this.chartColumn = this.$Echart.init(document.getElementById('chartColumn'));

                this.chartColumn.setOption({
                    title: { text: 'Column Chart' },
                    tooltip: {},
                    xAxis: {
                        type: 'category',
                        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: [820, 932, 901, 934, 1290, 1330, 1320],
                        type: 'line'
                    }]
                });
            }
        }
    }
</script>

<style scoped>

</style>
