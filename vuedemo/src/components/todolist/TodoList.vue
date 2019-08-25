<template>
  <ul class="todo-main">
    <todo-item v-for="(todo,index) in todos" :key="index" :index="index" :todo="todo"
          :remove-item="removeItem"/>
  </ul>
</template>

<script>
  import TodoItem from "./TodoItem";
    export default {
        name: "TodoList",

        props: {
            todos: Array,
            removeItem: Function
        },

        components: {
            TodoItem
        }
    }
</script>

<style scoped>
  .todo-main {
    margin-left: 0px;
    border: 1px solid #ddd;
    border-radius: 2px;
    padding: 0px;
  }

  .todo-empty {
    height: 40px;
    line-height: 40px;
    border: 1px solid #ddd;
    border-radius: 2px;
    padding-left: 5px;
    margin-top: 10px;
  }

</style>
