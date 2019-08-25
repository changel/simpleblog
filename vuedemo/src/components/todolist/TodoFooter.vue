<template>
  <div class="todo-footer" v-show="todos.length">
    <label>
      <input type="checkbox" v-model="isAllCheck"/>
    </label>
    <span>
            <span>已完成{{completedSize}}</span> / {{todos.length}}全部
            </span>
    <button class="btn btn-danger" @click="removeAllCompletedTodos" v-show="completedSize">清楚已完成任务</button>
  </div>
</template>

<script>
    export default {
        name: "TodoFooter",

        props: {
            todos: Array,
            selectAllTodos: Function,
            removeAllCompletedTodos: Function
        },

        computed: {
            completedSize(){
                return this.todos.reduce((preCount,todo) => preCount + (todo.complete ? 1 : 0) ,0)
            },
            isAllCheck: {
                get(){
                    return this.completedSize === this.todos.length && this.todos.length > 0
                },

                set(check){
                    this.selectAllTodos(check)
                }
            }
        }
    }
</script>

<style scoped>
  .todo-footer {
    height: 40px;
    line-height: 40px;
    padding-left: 6px;
    margin-top: 5px;
  }

  .todo-footer label {
    display: inline-block;
    margin-right: 20px;
    cursor: pointer;
  }

  .todo-footer label input {
    position: relative;
    top: -1px;
    vertical-align: middle;
    margin-right: 5px;
  }

  .todo-footer button {
    float: right;
    margin-top: 5px;
  }

</style>
