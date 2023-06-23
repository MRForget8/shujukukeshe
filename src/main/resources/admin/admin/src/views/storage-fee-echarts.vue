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
					text: '港口堆存费表'
				},
				legend: {
					data: ['费用'],
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
					name: '费用',
					type: 'bar',
					data: this.seriesData
				}]
			};

			// 使用刚指定的配置项和数据显示图表。
			chart.setOption(option);
		},
		getDataList () {
			this.$http({
				url: '/outbound/list',
				method: 'get',
				params: {
					'isSearchAll': true
				}
			}).then(({data}) => {
				if (data && data.code === 0) {
					let dataList = data.page.list
					dataList.forEach( item => {
						this.xAxisData.push(item.storeNumber)
						this.seriesData.push(item.storageFee)
					})
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
