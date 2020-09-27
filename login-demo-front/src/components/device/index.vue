<template>
    <div>
        <el-row>
            <el-button  @click="dialogFormVisible = true">新增</el-button>
            <el-button  @click="dialogFormVisible = true">修改</el-button>
            <el-button type="danger">删除</el-button>
        </el-row>
        <el-table :data="deviceList"  v-loading="loading"
                  element-loading-text="拼命加载中"
                  element-loading-spinner="el-icon-loading"
                  element-loading-background="rgba(0, 0, 0, 0.8)"
                  stripe border ref="multipleTable" >
            <el-table-column
                    type="selection"
                    width="55">
            </el-table-column>
            <el-table-column v-if="false" prop="eventId">


            </el-table-column>
            <el-table-column
                    prop="deviceCode"
                    label="设备编号"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="deviceName"
                    label="设备名称"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="brand"
                    label="品牌">
            </el-table-column>

        </el-table>
        <div class="block">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="curPage"
                    :page-sizes="[5, 10, 15, 20]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total=total>
            </el-pagination>
        </div>

        <el-dialog title="新增" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="设备编号">
                    <el-input v-model="form.deviceCode" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="设备名称" >
                    <el-input v-model="form.deviceName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="品牌" >
                    <el-input v-model="form.brand" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false;insert()">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "Device",
        data(){
            return {
                deviceList:[

                ],
                dialogFormVisible: false,
                form: {
                    deviceCode: '',
                    deviceName: '',
                    brand: ''
                },
                loading: true,
                curPage:1,
                pageSize: 10,
                total:0,

            }
        },
        methods: {
            getList (){
                this.loading = true
                let data = {
                    pageSize: this.pageSize,
                    startIndex : this.curPage
                }
                console.log(data)
                this.$api.QUERY_DEVICEINFO_PAGE(data).then(res => {
                    this.loading = false
                    this.deviceList = res.rows;
                    this.total = res.total
                });
            },
            insert(){
                let data = {};
                data = this.form
                this.$api.INSERT_DEVICEINFO(
                    data
                ).then(res => {
                    if ('200' == res.code){
                        // 新增成功
                    }else {
                        // 新增失败
                        alert(res.msg)
                    }
                    alert(res.code)
                    this.getList()
                });
            },
            handleSizeChange(val) {
                this.pageSize = val;
                this.getList();
            },
            handleCurrentChange(val) {
                this.curPage = val;
                this.getList();
            }
        },
        created()  {
            this.getList();
        },
    }
</script>

<style scoped>

</style>
