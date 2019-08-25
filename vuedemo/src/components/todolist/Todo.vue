<template>
  <div id="root">
    <div class="todo-container">
      <div class="todo-wrap">
<!--        <todo-header :add-item="addItem" />-->
        <todo-header @addItem="addItem" />
<!--        <todo-header ref="header"/>-->
        <TodoList :todos="todos" :remove-item="removeItem"/>
        <todo-footer :todos="todos" :select-all-todos="selectAllTodos" :remove-all-completed-todos="removeAllCompletedTodos"/>
      </div>
    </div>
  </div>
</template>

<script>
  import TodoHeader from "./TodoHeader";
  import TodoList from "./TodoList";
  import TodoFooter from "./TodoFooter";
    export default {
        name: "Todo",

        data(){
          return {
              todos: JSON.parse(window.localStorage.getItem("todos_key") || '[]')
          }
        },

        methods:{
            addItem(todo){
                this.todos.unshift(todo)
            },
            removeItem(index){
              this.todos.splice(index,1)
            },
            selectAllTodos(check){
                this.todos.forEach(todo => todo.complete = check)
            },
            removeAllCompletedTodos(){
                this.todos = this.todos.filter(todo => !todo.complete)
            }
        },
        mounted() {
            this.$refs.header.$on("addItem",this.addItem)
        },

        watch: {
            todos: {
                deep: true,
                handler: function (val) {
                    window.localStorage.setItem("todos_key",JSON.stringify(val))
                }
            }
        },

        components: {
            TodoHeader,
            TodoList,
            TodoFooter
        }
    }
</script>

<style scoped>
  .todo-container {
    width: 600px;
    margin: 0 auto;
  }

  .todo-container .todo-wrap {
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }
</style>
