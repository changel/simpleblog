<template>
  <div class="todo-header">
    <input type="text" placeholder="请输入任务名称，按回车键确认"
        v-model="title" @keyup.enter="add"/>
  </div>
</template>

<script>
    export default {
        name: "TodoHeader",

        props: {
            // addItem: Function
        },

        data(){
            return {
                title: '',
            }
        },

        methods: {
            add(){
                const title = this.title.trim()
                if(!title){
                    alert('请输入任务名称')
                    return
                }
                const todo = {
                    title: title ,
                    complete: false
                }
                this.$emit("addItem",todo)
                // this.addItem(todo)

                this.title = ''
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
