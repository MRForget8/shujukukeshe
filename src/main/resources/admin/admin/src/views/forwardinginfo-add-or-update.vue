<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="货代公司" prop="forwardingCompany">
      <el-input v-model="dataForm.forwardingCompany" placeholder="货代公司"></el-input>
    </el-form-item>
    <el-form-item label="公司代码" prop="companyCode">
      <el-input v-model="dataForm.companyCode" placeholder="公司代码"></el-input>
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
          
forwardingCompany: '',
          companyCode: ''
        },
        dataRule: {
          
forwardingCompany: [
            { required: true, message: '货代公司不能为空', trigger: 'blur' }
          ],
          companyCode: [
            { required: true, message: '公司代码不能为空', trigger: 'blur' }
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
              url: `/forwardinginfo/info/${this.dataForm.id}`,
              method: 'get'
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.forwardingCompany = data.forwardingInfo.forwardingCompany
                this.dataForm.companyCode = data.forwardingInfo.companyCode
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
              url: `/forwardinginfo/${!this.dataForm.id ? 'save' : 'update'}`,
              method: 'post',
              data: {
                'id': this.dataForm.id || undefined,
                'forwardingCompany': this.dataForm.forwardingCompany,
                'companyCode': this.dataForm.companyCode
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
