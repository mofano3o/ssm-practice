<template>
    <div class="main">
        <div class="container register">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px" :rules="rules">
                    <el-form-item label="用户名" prop="name">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input v-model="form.password"></el-input>
                    </el-form-item>
                    <el-form-item label="上传图片">
                        <el-upload
                                ref="upload"
                                :action="`http://localhost:8080/upload`"
                                :on-success="onSuccess">
                            <el-button size="small" type="primary">点击上传</el-button>
                        </el-upload>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm()">注册</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    import { post } from '../../api';

    export default {
        name: 'teacher-register',
        created() {

        },
        data() {
            return {
                form: {
                    name: '',
                    password: ''
                },
                rules: {
                    password: [{required: true, message: '请输入密码', trigger: 'change'}],
                    name: [{required: true, message: '请输入用户名', trigger: 'change'}],
                },
            };
        },
        methods: {
            submitForm() {
                this.$refs['form'].validate(valid => {
                    if (valid) {
                        post('/user/add', this.form).then(res => {
                            this.$message.success('注册成功')
                            this.$router.push('/login')
                        })
                    } else {
                        return false
                    }
                })
            },
            onSuccess(res, file) {
                this.form.imgUrl = res.data
            },
        }
    };
</script>

<style>
    .main {
        position: relative;
        width: 100%;
        height: 100%;
        background-image: url(../../assets/img/login-bg.jpg);
        background-size: 100%;
    }
    .register {
        position: absolute;
        left: 50%;
        top: 30%;
        width: 550px;
        margin: -150px 0 500px -275px;
        border-radius: 5px;
        background: rgba(255, 255, 255, 0.3);
        overflow: hidden;
    }
    .register .el-input__inner {
        width: 400px
    }
</style>
