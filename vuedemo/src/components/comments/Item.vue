<template>
  <div>
    <li> {{comment.name}} 说：   <a href="javascript:;" @click="del()">删除</a>
      <p>{{comment.content}}</p>
    </li>
  </div>
</template>

<script>
    export default {
        name: "Item",
        props: {
            comment: Object,
            deleteComment: Function,
            index: Number
        },
        methods: {
            del(){
                const {comment,index,deleteComment} = this
                if(window.confirm('确认删除'+comment.name+'的评论吗？')){
                    deleteComment(index)
                }
            }
        }
    }
</script>

<style scoped>
   li {
    min-height: 80px;
  }
  li a{
    margin-left: 220px;
  }
</style>
