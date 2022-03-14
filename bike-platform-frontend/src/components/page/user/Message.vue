<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 消息管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <el-table
                    :data="tableData"
                    border
                    class="table"
                    ref="multipleTable"
                    header-cell-class-name="table-header"
                    @cell-mouse-enter="clickOne"
            >
                <el-table-column prop="user" label="发送人"></el-table-column>
                <el-table-column prop="content" label="消息内容"></el-table-column>
                <el-table-column label="操作">
                     <template slot-scope="scope">
                       <el-button type="text" size="small" @click="showAddForm">发送消息</el-button>
                     </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                        background
                        layout="total, prev, pager, next"
                        :current-page="query.pageNumber"
                        :page-size="query.pageSize"
                        :total="pageTotal"
                        @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>
        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="50%">
            <el-form ref="editForm" :model="form" label-width="80px" :rules="rules">
                <el-form-item label="自行车信息" prop="title">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="日期时间">
                    <el-col :span="11">
                        <el-date-picker type="date"
                                        placeholder="选择日期"
                                        format="yyyy-MM-dd"
                                        value-format="yyyy-MM-dd hh:mm:ss"
                                        v-model="form.startAt"
                                        style="width: 100%;"></el-date-picker>
                    </el-col>
                    <el-col class="line" :span="2">-</el-col>
                    <el-col :span="11">
                        <el-date-picker type="date"
                                        placeholder="选择日期"
                                        format="yyyy-MM-dd"
                                        value-format="yyyy-MM-dd hh:mm:ss"
                                        v-model="form.endAt"
                                        style="width: 100%;"></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="有偿">
                    <el-checkbox v-model="form.needMoney" :true-label="1" :false-label="0"></el-checkbox>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('editForm')">编辑</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

        <el-dialog title="发送消息" :visible.sync="addVisible" width="50%">
            <el-form ref="addForm" :model="form" label-width="80px" :rules="rules">
                <el-form-item label="消息" prop="title">
                    <el-input v-model="content"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSendMessage">添加</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
    import { del, post, put, get } from '../../../api';
    import { mapGetters } from 'vuex';

    export default {
        name: 'Rent',
        created() {
            this.getRecruitments()
        },
        data() {
            return {
                query: {
                    pageNumber: 1,
                    pageSize: 10
                },
                tableData: [],
                pageTotal: 0,
                addVisible: false,
                editVisible: false,
                viewVisible: false,
                content: '',
                form: {
                    id: '',
                    rentId: '',
                    userId: '',
                },
                rules: {
                    name: [{required: true, message: '请输入名称', trigger: 'change'}],
                },
            };
        },
        computed: {
            ...mapGetters(['user'])
        },
        methods: {
            onCompleteOrder() {
                this.form.status = 1
                put(`/order/update`, this.form).then(res => {
                    this.getRecruitments()
                })
            },
            onSendMessage() {
                post('/message/add', {
                    userId: this.user.id,
                    targetId: this.query.userId+1,
                    content: this.content
                }).then(res => {
                    this.addVisible = false
                })
            },
            order() {
                post('/order/add', {
                    rentId: this.form.id,
                    userId: this.user.id
                }).then(res => {
                    this.$message('下单成功')
                    this.getRecruitments()
                })
            },
            change(value) {
            },
            showEditForm() {
                this.editVisible = true
            },
            showAddForm() {
                this.addVisible = true
            },
            showViewForm() {
                this.viewVisible = true
            },
            clear() {
                this.getRecruitments()
            },
            onSubmit() {
                this.getRecruitments()
            },
            submitForm(formName) {
                this.$refs[formName].validate(valid => {
                    if (valid) {
                        if (formName === 'addForm') {
                            this.add()
                        } else {
                            this.edit()
                        }
                    } else {
                        return false
                    }
                })
            },
            getRecruitments() {
                this.query.userId = this.user.id
                post(`/message/list`, this.query).then(res => {
                    this.tableData = res.data.data
                    this.pageTotal = res.data.total
                })
            },
            add() {
                this.form.userId = this.user.id
                post(`/rent/add`, this.form).then(res => {
                    this.$message.success('添加成功')
                    this.addVisible = false
                    this.getRecruitments()
                    this.$refs['addForm'].resetFields()
                })
            },
            edit() {
                put(`/rent/update`, this.form).then(res => {
                    this.$message.success('修改成功')
                    this.editVisible = false
                    this.getRecruitments()
                    this.$refs['editForm'].resetFields()
                })
            },
            delJob() {
                del(`/rent/${this.form.id}`).then(res => {
                    this.$message.success('删除成功')
                    this.getRecruitments()
                })
            },
            clickOne(row, column, event) {
                Object.assign(this.form, row)
            },
            handlePageChange(pageNo) {
                this.query.pageNo = pageNo
                this.getRecruitments()
            },
            onSuccess(res, file) {
                this.form.imgUrl = res.data
            }
        }
    };
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }
    .table {
        width: 100%;
        font-size: 14px;
    }
    .red {
        color: #ff0000;
    }
    .mr10 {
        margin-right: 10px;
    }
    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
</style>
