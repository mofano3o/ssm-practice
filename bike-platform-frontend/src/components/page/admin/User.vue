<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 用户管理
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
                <el-table-column prop="name" label="用户名"></el-table-column>
                <el-table-column prop="password" label="密码"></el-table-column>
                <el-table-column prop="point" label="认证">
                    <template slot-scope="props">
                        <img style="max-width: 50px" :src="`${props.row.imgUrl}`"/>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button type="text" size="small" @click="onAccept" v-if="scope.row.status === 0">认证通过</el-button>
                        <el-button type="text" size="small" @click="delJob">删除</el-button>
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
                <el-form-item label="名称" prop="name">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('editForm')">编辑</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

        <el-dialog title="添加" :visible.sync="addVisible" width="50%">
            <el-form ref="addForm" :model="form" label-width="80px" :rules="rules">
                <el-form-item label="名称" prop="name">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('addForm')">添加</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
    import { del, post, put, get } from '../../../api';
    import { mapGetters } from 'vuex';

    export default {
        name: 'User',
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
                form: {
                    id: '',
                    name: '',
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
            onAccept() {
                get(`/user/accept/${this.form.id}`).then(res => {
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
                post(`/user/list`, this.query).then(res => {
                    this.tableData = res.data.data
                    this.pageTotal = res.data.total
                })
            },
            add() {
                post(`/team/add`, this.form).then(res => {
                    this.$message.success('添加成功')
                    this.addVisible = false
                    this.getRecruitments()
                    this.$refs['addForm'].resetFields()
                })
            },
            edit() {
                put(`/team/update`, this.form).then(res => {
                    this.$message.success('修改成功')
                    this.editVisible = false
                    this.getRecruitments()
                    this.$refs['editForm'].resetFields()
                })
            },
            delJob() {
                del(`/user/${this.form.id}`).then(res => {
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
