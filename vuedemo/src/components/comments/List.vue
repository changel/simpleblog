<template>
  <div class="right">
    <ul>
      <Item v-for="(comment,index) in comments" :key="index" :comment="comment" :deleteComment="deleteComment" :index="index"></Item>
      <p v-show="comments.length==0">暂无评论！</p>
    </ul>
  </div>
</template>

<script>
    import Item from "./Item";
    export default {
        name: "List",
        components: {Item},
        props: ['comments','deleteComment']
    }
</script>

<style scoped>
  .right{
    margin-left: 400px;
    width: 400px;
    border: solid 1px ;
    min-height: 400px;
  }

</style>
