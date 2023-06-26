<template>
	<div>
		<div ref="chart" style="width:100%;height:400px;"></div>
	</div>
</template>

<script>
import echarts from 'echarts'
	export default {
		data () {
			return {
				xAxisData: [],
				seriesData: []
			}
		},
		mounted() {
			this.getDataList()
		},
		created() {

		},
		methods: {
			// 柱状图
			initCharts(){
				// 创建 echarts 图表实例
				let chart = echarts.init(this.$refs.chart)

				// 配置项设置
				let option = {
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					title: {
						text: '吨储图'
					},
					legend: {
						data: ['吨数'],
						right: 10,
						top:12,
						textStyle: {
							color: "#fff"
						},
						itemWidth: 12,
						itemHeight: 10,
					},
					xAxis: {
						type: 'category',
						data: this.xAxisData
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						name: '吨数',
						type: 'bar',
						data: this.seriesData
					}]
				};

				// 使用刚指定的配置项和数据显示图表。
				chart.setOption(option);
			},
			getDataList () {
				this.$http({
					url: '/warehousing/getStorageFeeGroupStoreNumber',
					method: 'get',
					params: {}
				}).then(({data}) => {
					if (data && data.code === 0) {
						for (let key in data.data) {
							this.xAxisData.push(key)
							this.seriesData.push(data.data[key])
						}
						this.initCharts()
					} else {
						this.dataList = []
					}
				})
			}
		},
	}
</script>

<style>
</style>
