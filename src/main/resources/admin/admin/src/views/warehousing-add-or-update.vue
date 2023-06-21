<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="车牌号" prop="carNumber">
      <el-input v-model="dataForm.carNumber" placeholder="车牌号"></el-input>
    </el-form-item>
    <el-form-item label="入库件数" prop="warehousingNum">
      <el-input v-model="dataForm.warehousingNum" placeholder="入库件数"></el-input>
    </el-form-item>
    <el-form-item label="入库时间" prop="warehousingDate">
      <el-input v-model="dataForm.warehousingDate" placeholder="入库时间"></el-input>
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
        dataForm: {
          id: 0,
          carNumber: '',
          warehousingNum: '',
          warehousingDate: '',
          warehousingTonnage: ''
        },
        dataRule: {
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
              url: this.$http.adornUrl(`/generator/warehousing/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.carNumber = data.warehousing.carNumber
                this.dataForm.warehousingNum = data.warehousing.warehousingNum
                this.dataForm.warehousingDate = data.warehousing.warehousingDate
                this.dataForm.warehousingTonnage = data.warehousing.warehousingTonnage
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
              url: this.$http.adornUrl(`/generator/warehousing/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'carNumber': this.dataForm.carNumber,
                'warehousingNum': this.dataForm.warehousingNum,
                'warehousingDate': this.dataForm.warehousingDate,
                'warehousingTonnage': this.dataForm.warehousingTonnage
              })
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
