<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">后台管理系统</div>
            <el-form :model="form" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="name">
                    <el-input v-model="form.name" placeholder="用户名">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                            type="password"
                            placeholder="密码"
                            v-model="form.password"
                            @keyup.enter.native="submitForm()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item label="角色" label-width="50px" prop="type">
                    <el-select v-model="form.type">
                        <el-option :value="0" label="管理员"></el-option>
                        <el-option :value="1" label="用户"></el-option>
                    </el-select>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="onRegister()">注册</el-button>
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
    import {post} from '../../api';
    import {mapMutations} from 'vuex'
    export default {
        data: function() {
            return {
                form: {
                    name: '',
                    password: '',
                    type: ''
                },
                rules: {
                    name: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                    password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
                    type: [{ required: true, message: '请选择角色', trigger: 'blur' }]
                }
            };
        },
        methods: {
            onRegister() {
                this.$router.push('/register')
            },
            submitForm() {
                this.$refs.login.validate(valid => {
                    if (valid) {
                        post('/user/login', this.form).then(res => {
                            this.login(res.data)
                            this.$message.success('登录成功');
                            this.$router.push('/dashboard').catch(err => {
                                console.log(err);
                            })
                        })
                    } else {
                        return false;
                    }
                });
            },

            ...mapMutations(['login'])
        }
    };
</script>

<style scoped>
    .login-wrap {
        position: relative;
        width: 100%;
        height: 100%;
        background-image: url(../../assets/img/login-bg.jpg);
        background-size: 100%;
    }

    .ms-title {
        width: 100%;
        line-height: 50px;
        text-align: center;
        font-size: 20px;
        color: #fff;
        border-bottom: 1px solid #ddd;
    }

    .ms-login {
        position: absolute;
        left: 50%;
        top: 50%;
        width: 350px;
        margin: -190px 0 0 -175px;
        border-radius: 5px;
        background: rgba(255, 255, 255, 0.3);
        overflow: hidden;
    }

    .ms-content {
        padding: 30px 30px;
    }

    .login-btn {
        text-align: center;
    }
</style>
