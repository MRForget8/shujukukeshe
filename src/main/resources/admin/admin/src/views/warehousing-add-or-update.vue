<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
		<el-form-item label="货代公司" prop="forwardingCompany">
			<el-select v-model="dataForm.forwardingCompany" placeholder="请选择货代公司">
				<el-option
						v-for="item in forwardingList"
						:key="item.id"
						:label="item.forwardingCompany"
						:value="item.id">
				</el-option>
			</el-select>
		</el-form-item>
		<el-form-item label="仓库编号" prop="storeNumber">
			<el-input v-model="dataForm.storeNumber" placeholder="仓库编号"></el-input>
		</el-form-item>
		<el-form-item label="车牌号" prop="carNumber">
		  <el-input v-model="dataForm.carNumber" placeholder="车牌号"></el-input>
		</el-form-item>
		<el-form-item label="入库件数" prop="warehousingNum">
		  <el-input v-model="dataForm.warehousingNum" placeholder="入库件数"></el-input>
		</el-form-item>
		<el-form-item label="入库时间" prop="warehousingDate">
			<el-date-picker
				  v-model="dataForm.warehousingDate"
				  type="date"
				  placeholder="选择入库时间"
				  value-format="yyyy-MM-dd">
			</el-date-picker>
		</el-form-item>
		<el-form-item label="入库吨数" prop="warehousingTonnage">
		  <el-input v-model="dataForm.warehousingTonnage" placeholder="入库吨数"></el-input>
		</el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
		forwardingList: [],
        dataForm: {
          carNumber: '',
          warehousingNum: '',
          warehousingDate: '',
          warehousingTonnage: '',
					forwardingCompany: '',
					storeNumber: ''
        },
        dataRule: {
					storeNumber: [
						{ required: true, message: '仓库编号不能为空', trigger: 'blur' }
					],
          carNumber: [
            { required: true, message: '车牌号不能为空', trigger: 'blur' }
          ],
          warehousingNum: [
            { required: true, message: '入库件数不能为空', trigger: 'blur' }
          ],
          warehousingDate: [
            { required: true, message: '入库时间不能为空', trigger: 'blur' }
          ],
          warehousingTonnage: [
            { required: true, message: '入库吨数不能为空', trigger: 'blur' }
          ],
					forwardingCompany: [
						{ required: true, message: '货代公司不能为空', trigger: 'blur' }
					],
        }
      }
    },
	created() {
		this.getForwardingCompanyDataList()
	},
    methods: {
		getForwardingCompanyDataList () {
		  this.$http({
			url: '/forwardinginfo/list',
			method: 'get',
			params: {
			  'isSearchAll': true
			}
		  }).then(({data}) => {
			if (data && data.code === 0) {
			  this.forwardingList = data.page.list
			} else {
			  this.dataList = []
			  this.totalPage = 0
			}
			this.dataListLoading = false
		  })
		},
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: `/warehousing/info/${this.dataForm.id}`,
              method: 'get'
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.carNumber = data.warehousing.carNumber
                this.dataForm.warehousingNum = data.warehousing.warehousingNum
                this.dataForm.warehousingDate = data.warehousing.warehousingDate
                this.dataForm.warehousingTonnage = data.warehousing.warehousingTonnage
								this.dataForm.forwardingCompany = data.warehousing.forwardingCompanyId
								this.dataForm.storeNumber = data.warehousing.storeNumber
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: `/warehousing/${!this.dataForm.id ? 'save' : 'update'}`,
              method: 'post',
              data: {
                'forwardingCompanyId': this.dataForm.forwardingCompany,
                'carNumber': this.dataForm.carNumber,
                'warehousingNum': this.dataForm.warehousingNum,
                'warehousingDate': this.dataForm.warehousingDate,
                'warehousingTonnage': this.dataForm.warehousingTonnage,
                'storeNumber': this.dataForm.storeNumber,
              }
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
