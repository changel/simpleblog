<template>
  <div class="header">
    <p>Vue好不好用？</p>
    <Add :addComment="addComment"/>
    <List :comments="comments" :deleteComment="deleteComment"/>
  </div>
</template>

<script>
  import List from './List'
  import Add from './Add'
    export default {
        name: "Comments",
        data(){
            return {
                comments:[{
                    name: 'Ami',
                    content: "Vue is so easy!"
                }, {
                   name: 'Bod',
                   content: 'Vue is so so!'
                },{
                    name: 'Cat',
                    content: 'Vue is very good!'
                }]
            }
        },
        components: {
            List,
            Add
        },
        methods: {
          addComment(comment){
              this.comments.unshift(comment)
          },
          deleteComment(index){
              this.comments.splice(index,1)
          }
        }
    }
</script>

<style scoped>
  .header{
    min-height: 500px;
    width: 800px;
    /*border : solid 1px black;*/
  }
  .header p{
    height: 80px;
    background: cornsilk;
    text-align: center;
    padding-top: 30px;
    font-size: 20px;
    margin-top: 0px;
  }
</style>
