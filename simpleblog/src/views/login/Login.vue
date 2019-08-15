<template>
    <div class="login-container">
   <el-container>
     <el-main>
       <el-form autoComplete="on" :model="loginForm" ref="loginForm" label-position="left" label-width="0px"
                class="card-box login-form">
         <div class="title-container">
           <h3 class="title">Simple Blog</h3>
           <div class="el-form-item__error login-error">{{ loginError }}</div>
         </div>
         <el-form-item prop="username">
        <span class="svg-container svg-container_login">
          <svg-icon icon-class="user"></svg-icon>
        </span>
           <el-input name="username" type="text" v-model="loginForm.username" autoComplete="on" placeholder="用户名" autofocus></el-input>
         </el-form-item>
         <el-form-item prop="password">
        <span class="svg-container svg-container_password">
          <svg-icon icon-class="password"></svg-icon>
        </span>
           <el-input name="password" :type="pwdType" v-model="loginForm.password"
                     autoComplete="off" placeholder="密码"></el-input>
         </el-form-item>
         <!--<el-row v-if="showCheckCode">
           <el-col :span="17">
             <el-form-item  prop="checkcode" style="width:150px">
            <span class="captcha">
               <el-input placeholder="验证码" v-model="loginForm.checkcode" @keydown.enter.native="preLoginHandler" @keyup.enter.native="handleLogin(true)"></el-input>
            </span>
             </el-form-item>
           </el-col>
           <el-col :span="7">
             <img src="" alt="" ref="captcha" width="100%" @click="getCode" class="captcha-img">
           </el-col>
         </el-row>-->
         <el-row v-if="showRememberMe" class="remember-me-container">
           <el-checkbox v-model="loginForm.isRememberMe">自动登录</el-checkbox>
         </el-row>
         <el-form-item>
           <el-button type="primary" style="width:100%;" :loading="loading" @click.native.prevent="handleLogin(false)">
             登  录
           </el-button>
         </el-form-item>
       </el-form>
     </el-main>
   </el-container>
  </div>
</template>
<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: '',
        checkcode: '',
        isRememberMe: false
      },
      preCheckcode: '',
      loading: false,
      pwdType: 'password',
      loginError: '',
      showCheckCode: false,
      showRememberMe: false
    }
  },
  methods: {
    handleLogin (needPreCheck) {
      // IE中，中文输入法输入验证码时，按enter键会直接触发keyup事件，而chrome做了优化，不会触发
      // 这里根据keydown与keyup的验证码输入框内容来进行判断，不一样说明是在用中文输入法
      // if (needPreCheck && this.preCheckcode !== this.loginForm.checkcode) {
      //   return
      // }
      if (this.loginForm.username.trim().length === 0 || this.loginForm.password.trim().length === 0) {
        this.loginError = '请输入用户名和密码'
        this.$message.error('请输入用户名和密码')
        return
      }
      if (this.showCheckCode && this.loginForm.checkcode.trim().length === 0) {
        this.loginError = '请输入验证码'
        return
      }
      if (this.loading === false) {
        this.loading = true
        this.$http.post('/blog/login', this.loginForm).then((result) => {
          this.loginError = ''
          if (result.status) {
            this.loginError = result.body.msg
            this.loading = false
          } else {
            this.loginError = result.body.msg
          }
          this.$router.push({path: '/'})
        }).catch((error) => {
          this.loginError = error.message
          this.getCode()
          setTimeout(() => {
            this.loading = false
          }, 1000)
        })
      }
    }
  }
}
</script>

<style scoped>

</style>
