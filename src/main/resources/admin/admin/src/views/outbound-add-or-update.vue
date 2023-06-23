<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="仓库编号" prop="storeNumber">
      <el-input v-model="dataForm.storeNumber" placeholder="仓库编号"></el-input>
    </el-form-item>
    <el-form-item label="出库件数" prop="outboundNum">
      <el-input v-model="dataForm.outboundNum" placeholder="出库件数"></el-input>
    </el-form-item>
    <el-form-item label="出库时间" prop="outboundDate">
		<el-date-picker
		      v-model="dataForm.outboundDate"
		      type="date"
		      placeholder="选择出库时间" 
			  value-format="yyyy-MM-dd">
		</el-date-picker>
    </el-form-item>
    <el-form-item label="出库吨数" prop="outboundTonnage">
      <el-input v-model="dataForm.outboundTonnage" placeholder="出库吨数"></el-input>
    </el-form-item>
    <el-form-item label="堆存费" prop="storageFee">
      <el-input v-model="dataForm.storageFee" placeholder="堆存费"></el-input>
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
        dataForm: {
          id: 0,
          storeNumber: '',
          outboundNum: '',
          outboundDate: '',
          outboundTonnage: '',
          storageFee: ''
        },
        dataRule: {
          storeNumber: [
            { required: true, message: '仓库编号不能为空', trigger: 'blur' }
          ],
          outboundNum: [
            { required: true, message: '出库件数不能为空', trigger: 'blur' }
          ],
          outboundDate: [
            { required: true, message: '出库时间不能为空', trigger: 'blur' }
          ],
          outboundTonnage: [
            { required: true, message: '出库吨数不能为空', trigger: 'blur' }
          ],
          storageFee: [
            { required: true, message: '堆存费不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: `/outbound/info/${this.dataForm.id}`,
              method: 'get'
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.storeNumber = data.outbound.storeNumber
                this.dataForm.outboundNum = data.outbound.outboundNum
                this.dataForm.outboundDate = data.outbound.outboundDate
                this.dataForm.outboundTonnage = data.outbound.outboundTonnage
                this.dataForm.storageFee = data.outbound.storageFee
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
              url: `/outbound/${!this.dataForm.id ? 'save' : 'update'}`,
              method: 'post',
              data: {
                'id': this.dataForm.id || undefined,
                'storeNumber': this.dataForm.storeNumber,
                'outboundNum': this.dataForm.outboundNum,
                'outboundDate': this.dataForm.outboundDate,
                'outboundTonnage': this.dataForm.outboundTonnage,
                'storageFee': this.dataForm.storageFee
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
