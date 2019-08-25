<template>
  <div>
    <h2 v-if="showMsg" style="font-size: 14px;"><p>请输入用户名称</p></h2>
    <h2 v-if="!showMsg && !isLoading && users.length == 0">没有找到相关用户！</h2>
    <h2 v-if="isLoading" style="font-size: 14px; color: green"><p>loading...</p></h2>
    <h2 v-if="errorMsg" style="font-size: 14px; color: green"><p>{{errorMsg}}</p></h2>
    <ul  class="todo-main">
      <li v-for="(user,index) in users" :key="index"
        @mouseenter='handleEnter(true,index)' @mouseleave='handleEnter(false,index)' :style="{background:user.bgColor}">
        <label>
          <img :src="user.img_url" style="width: 100px;">
          <span><a :href="user.html_url" target="_blank">{{user.name}}</a></span>
        </label>
      </li>
    </ul>
  </div>
</template>

<script>
    import Pubsub from 'pubsub-js'
    import axios from 'axios'
    export default {
        name: "SearchResult",
        data (){
            return {
                bgColor : 'white',
                users: [],
                isLoading: false,
                showMsg:  true,
                errorMsg: ''
            }
        },
        methods: {
            handleEnter(isEnter,index){
                if (isEnter){
                    this.users[index].bgColor = '#aaaaaa'
                }else {
                    this.users[index].bgColor = 'white'
                }
            },
            searchUsers(userName){
                this.errorMsg = ''
                this.isLoading = true
                this.showMsg = false
                this.users = []

                const url = `https://api.github.com/search/users?q=${userName}`
                axios.get(url).then(response => {
                    const result = response.data;
                    const  users = result.items.map(item => ({
                        name: item.login,
                        html_url: item.html_url,
                        img_url: item.avatar_url,
                        bgColor: 'white'
                    }))
                    this.users = users
                    this.isLoading = false;
                }).catch(error => {
                    this.isLoading = false
                    this.errorMsg = "请求错误"
                })
            }
        },
        mounted() {
            Pubsub.subscribe('searchUser', (msg,userName) => {
                this.searchUsers(userName)
            })
        }
    }
</script>

<style scoped>
  .todo-main {
    margin-left: 0px;
    border: 1px solid #ddd;
    border-radius: 2px;
    padding: 0px;
    width: 580px;
  }

  .todo-empty {
    height: 40px;
    line-height: 40px;
    border: 1px solid #ddd;
    border-radius: 2px;
    padding-left: 5px;
    margin-top: 10px;
  }

  li {
    list-style: none;
    height: 100px;
    line-height: 100px;
    padding: 0 5px;
    border-bottom: 1px solid #ddd;
  }

  li lable {
    float: left;
    cursor: pointer;
  }

  li label li input {
    vertical-align: middle;
    margin-right: 6px;
    position: relative;
    top: -1px;
  }

  li button {
    float: right;
    /*display: none;*/
    margin-top: 3px;
  }

  li:before {
    content: initial;
  }

  li:last-child {
    border-bottom: none;
  }

</style>
