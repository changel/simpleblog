<template>
  <div class="addDiv">
    <table>
      <tr>
        <td>
          <label>用户：</label>
        </td>
        <td class="inputTd">
          <input type="text" v-model="name" @keyup.enter="add">
        </td>
      </tr>
      <tr>
        <td>
          <lable>评论：</lable>
        </td>
        <td  class="inputTd">
          <textarea rows="5" v-model="content" @keyup.enter="add"/>
        </td>
      </tr>
      <tr>
        <td  colspan="2">
          <button @click="add">提交</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
    export default {
        name: "Add",
        data(){
            return {
                name: '',
                content: ''
            }
        },
        methods: {
            add(){
                const name = this.name.trim()
                const content = this.content.trim()
                if(!name || !content){
                    alert('用户或者评论为空！')
                    return;
                }
                const comment = {
                    name,
                    content
                }
                this.addComment(comment)

                this.name = ''
                this.content = ''
            }
        },
        props: {
            addComment: {
                type: Function,
                required: true
            }
        }
    }
</script>

<style scoped>
  .addDiv{
    border: solid 1px black;
    width: 350px;
    height: 400px;
    float: left;
  }
  .addDiv td{
    text-align: center;
  }
  .addDiv input{
    width: 100px;
    margin-top: 20px;
  }
  .addDiv textarea{
    width: 250px;
    margin-top: 20px;
  }

  .addDiv button{
    width: 80px;
    height: 30px;
    font-size: 15px;
    background: lightgray;
  }

  .inputTd{
    text-align: left!important;
  }
</style>
