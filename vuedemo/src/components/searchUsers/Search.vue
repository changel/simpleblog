<template>
  <div class="todo-header">
    <input type="text" placeholder="请输入用户名称，按回车键确认"
           v-model="userName" @keyup.enter="search"/>
  </div>
</template>

<script>
    import Pubsub from 'pubsub-js'
    export default {
        name: "Search",
        data (){
            return {
                userName: ''
            }
        },
        methods: {
            search (){
                if(!this.userName){
                    return;
                }
                Pubsub.publish('searchUser',this.userName)
            }
        }
    }
</script>

<style scoped>
  .todo-header input {
    width: 560px;
    height: 28px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
    padding: 4px 7px;
  }

  .todo-header input:focus {
    outline: none;
    border-color: rgba(82, 168, 238, 0.8);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 238, 0.6);
  }
</style>
