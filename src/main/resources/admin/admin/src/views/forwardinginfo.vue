<template>
    <div class="mod-config">
        <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
            <el-form-item>
                <el-input v-model="dataForm.key" placeholder="公司名称" clearable></el-input>
            </el-form-item>
            <el-form-item>
                <el-button @click="getDataList()">查询</el-button>
                <el-button type="primary" @click="addOrUpdateHandle()">新增</el-button>
                <el-button @click="getDataList()">刷新</el-button>
            </el-form-item>
        </el-form>

        <el-dialog title="入库信息" :visible.sync="warehousingDialogTableVisible">
            <el-table :data="warehousingData" v-loading="commonDataListLoading">
                <el-table-column
                    prop="carNumber"
                    header-align="center"
                    align="center"
                    label="车牌号">
                </el-table-column>
                <el-table-column
                    prop="warehousingNum"
                    header-align="center"
                    align="center"
                    label="入库件数">
                </el-table-column>
                <el-table-column
                    prop="warehousingDate"
                    header-align="center"
                    align="center"
                    label="入库时间">
                </el-table-column>
                <el-table-column
                    prop="warehousingTonnage"
                    header-align="center"
                    align="center"
                    label="入库吨数">
                </el-table-column>
            </el-table>
            <p style="padding: 10px">
                <span
                    style="color: blue;font-size: 15px;">
                    入库总吨数: {{warehousingTonnageSum}} 吨
                </span>
            </p>
        </el-dialog>

        <el-dialog title="出库信息" :visible.sync="outboundDialogTableVisible">
            <el-table :data="outboundData" v-loading="commonDataListLoading">
                <el-table-column
                    prop="outboundNum"
                    header-align="center"
                    align="center"
                    label="出库件数">
                </el-table-column>
                <el-table-column
                    prop="outboundDate"
                    header-align="center"
                    align="center"
                    label="出库时间">
                </el-table-column>
                <el-table-column
                    prop="outboundTonnage"
                    header-align="center"
                    align="center"
                    label="出库吨数">
                </el-table-column>
                <el-table-column
                    prop="storageFee"
                    header-align="center"
                    align="center"
                    label="堆存费">
                </el-table-column>
            </el-table>
            <p style="padding: 10px">
                <span
                    style="color: blue;font-size: 15px;">
                    出库总吨数: {{outboundTonnageSum}} 吨&nbsp;
                </span>
                <span
                    style="color: blue;font-size: 15px;">
                    总费用: {{outboundSumFee}} 元
                </span>
            </p>
        </el-dialog>
        <el-table
                :data="dataList"
                border
                v-loading="dataListLoading"
                @selection-change="selectionChangeHandle"
                style="width: 100%;">
            <el-table-column
                    prop="forwardingCompany"
                    header-align="center"
                    align="center"
                    label="货代公司">
            </el-table-column>
            <el-table-column
                    prop="companyCode"
                    header-align="center"
                    align="center"
                    label="公司代码">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    header-align="center"
                    align="center"
                    label="操作">
                <template slot-scope="scope">
                    <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
                    <el-button type="text" size="small" @click="getOutboundData(scope.row.id)">查看出库信息
                    </el-button>
                    <el-button type="text" size="small" @click="getWarehousingData(scope.row.id)">查看入库信息
                    </el-button>
                    <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                @size-change="sizeChangeHandle"
                @current-change="currentChangeHandle"
                :current-page="pageIndex"
                :page-sizes="[10, 20, 50, 100]"
                :page-size="pageSize"
                :total="totalPage"
                layout="total, sizes, prev, pager, next, jumper">
        </el-pagination>
        <!-- 弹窗, 新增 / 修改 -->
        <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
    </div>
</template>

<script>
import AddOrUpdate from './forwardinginfo-add-or-update'
import warehousing from "./warehousing.vue";
import outbound from "./outbound.vue";

export default {
    computed: {
        outbound() {
            return outbound
        },
        warehousing() {
            return warehousing
        }
    },
    data() {
        return {
            dataForm: {
                key: ''
            },
            dataList: [],
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            dataListLoading: false,
            dataListSelections: [],
            addOrUpdateVisible: false,

            commonDataListLoading: false,
            outboundDialogTableVisible: false,
            warehousingDialogTableVisible: false,

            outboundData: [],
            warehousingData: [],
            warehousingTonnageSum: 0,
            outboundTonnageSum: 0,
            outboundSumFee: 0
        }
    },
    components: {
        AddOrUpdate
    },
    created() {
        this.getDataList()
    },
    methods: {
        getWarehousingData(id) {
            this.warehousingDialogTableVisible = true
            this.commonDataListLoading = true
            this.$http({
                url: '/warehousing/list',
                method: 'get',
                params: {
                    'isSearchAll': true,
                    'key': id
                }
            }).then(({data}) => {
                if (data && data.code === 0) {
                    this.warehousingData = data.page.list
                    this.warehousingTonnageSum = 0
                    this.warehousingData.forEach(item => {
                        this.warehousingTonnageSum += item.warehousingTonnage
                    })
                } else {
                    this.warehousingData = []
                }
                this.commonDataListLoading = false
            })
        },
        getOutboundData(id) {
            this.outboundDialogTableVisible = true
            this.commonDataListLoading = true
            this.$http({
                url: '/outbound/list',
                method: 'get',
                params: {
                    'isSearchAll': true,
                    'key': id
                }
            }).then(({data}) => {
                if (data && data.code === 0) {
                    this.outboundData = data.page.list
                    this.outboundSumFee = 0
                    this.outboundTonnageSum = 0
                    this.outboundData.forEach(item => {
                        this.outboundSumFee += item.storageFee
                        this.outboundTonnageSum += item.outboundTonnage
                    })
                } else {
                    this.outboundData = []
                }
                this.commonDataListLoading = false
            })
        },
        // 获取数据列表
        getDataList() {
            this.dataListLoading = true
            this.$http({
                url: '/forwardinginfo/list',
                method: 'get',
                params: {
                    'page': this.pageIndex,
                    'limit': this.pageSize,
                    'key': this.dataForm.key
                }
            }).then(({data}) => {
                if (data && data.code === 0) {
                    this.dataList = data.page.list
                    this.totalPage = data.page.total
                } else {
                    this.dataList = []
                    this.totalPage = 0
                }
                this.dataListLoading = false
            })
        },
        // 每页数
        sizeChangeHandle(val) {
            this.pageSize = val
            this.pageIndex = 1
            this.getDataList()
        },
        // 当前页
        currentChangeHandle(val) {
            this.pageIndex = val
            this.getDataList()
        },
        // 多选
        selectionChangeHandle(val) {
            this.dataListSelections = val
        },
        // 新增 / 修改
        addOrUpdateHandle(id) {
            this.addOrUpdateVisible = true
            this.$nextTick(() => {
                this.$refs.addOrUpdate.init(id)
            })
        },
        // 删除
        deleteHandle(id) {
            var ids = id ? [id] : this.dataListSelections.map(item => {
                return item.id
            })
            this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$http({
                    url: '/forwardinginfo/delete',
                    method: 'post',
                    data: ids
                }).then(({data}) => {
                    if (data && data.code === 0) {
                        this.$message({
                            message: '操作成功',
                            type: 'success',
                            duration: 1500,
                            onClose: () => {
                                this.getDataList()
                            }
                        })
                    } else {
                        this.$message.error(data.msg)
                    }
                })
            })
        }
    }
}
</script>
