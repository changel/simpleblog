<template>
  <div id="root">
    <div class="todo-container">
      <div class="todo-wrap">
        <search/>
        <search-result/>
      </div>
    </div>
  </div>
</template>

<script>
  import Search from "./Search";
  import SearchResult from "./SearchResult";
    export default {
        name: "SearchUsers",
        components: {SearchResult, Search}
    }
</script>

<style scoped>

</style>
