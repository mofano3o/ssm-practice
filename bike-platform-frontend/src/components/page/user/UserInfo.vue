<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>个人信息</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px" :rules="rules">
                    <el-form-item label="用户名">
                        <el-input v-model="form.name"  style="width: 200px"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input v-model="form.password"  style="width: 200px"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm()">修改</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    import { mapGetters, mapMutations } from 'vuex';
    import { get, post, put } from '../../../api';

    export default {
        name: 'UserInfo',
        created() {
            this.getPersonInfo()
        },
        data() {
            return {
                form: {
                    id: '',
                    name: '',
                    password: ''
                },
                rules: {
                    name: [{required: true, message: '请输入用户名', trigger: 'change'}],
                    password: [{required: true, message: '请输入密码', trigger: 'change'}]
                }
            };
        },
        computed: {
            ...mapGetters(['user'])
        },
        methods: {
            submitForm() {
                this.$refs['form'].validate(valid => {
                    if (valid) {
                        this.form.id = this.user.id
                        put(`/user/update`, this.form).then(res => {
                            this.$message.success('修改成功')
                            res.data.type = this.user.type
                            this.login(res.data)
                        })
                    } else {
                        return false
                    }
                })
            },
            getPersonInfo() {
                get(`/user/${this.user.id}`).then(res => {
                    this.form = res.data
                    if (res.data.gender === 1) {
                        this.form.gender = '男'
                    } else {
                        this.form.gender = '女'
                    }
                })
            },
            ...mapMutations(['login'])
        }
    };
</script>

<style scoped>

</style>
