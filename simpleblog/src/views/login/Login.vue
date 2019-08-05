<template>
   <el-container>
     <el-main>
       {{msg}}
       <svg-icon icon-class="user" />
       <!--<el-form-item prop="username">-->
        <!--<span class="svg-container svg-container_login">-->
          <!--<svg-icon icon-class="user"></svg-icon>-->
        <!--</span>-->
         <!--<el-input name="username" type="text" v-model="loginForm.username" autoComplete="on" placeholder="用户名" autofocus></el-input>-->
       <!--</el-form-item>-->
     </el-main>
   </el-container>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      msg: '这是登陆页面'
    }
  }
}
</script>

<style scoped>

</style>
