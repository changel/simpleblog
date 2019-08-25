<template>
  <li @mouseenter='handleEnter(true)' @mouseleave='handleEnter(false)' :style="{background:bgColor}">
    <label>
      <input type="checkbox" v-model="todo.complete">
      <span>{{todo.title}}</span>
    </label>
    <button class="btn btn-danger" v-show="isShow" @click="del">删除</button>
  </li>
</template>

<script>
    export default {
        name: "TodoItem",

        props: {
            todo: Object,
            index: Number,
            removeItem: Function
        },

        data(){
            return {
                isShow: false,
                bgColor: 'white'
            }
        },

        methods: {
            handleEnter(isEnter){
                if(isEnter){
                    this.isShow = true
                    this.bgColor = '#aaaaaa'
                }else{
                    this.isShow = false
                    this.bgColor = 'white'
                }
            },

            del(){
                const {todo,index,removeItem} = this
                if(window.confirm(`确认删除${todo.title}的任务吗`)){
                    removeItem(index)
                }
            }
        }
    }
</script>

<style scoped>
  li {
    list-style: none;
    height: 36px;
    line-height: 36px;
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
