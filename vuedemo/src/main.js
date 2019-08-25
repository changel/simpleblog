import Vue from 'vue'
import Comments from './components/comments/Comments'
import App from './App'
import Todo from "./components/todolist/Todo";
import SearchUsers from "./components/searchUsers/SearchUsers";
import './components/todolist/base.css'

// new Vue({
//   el:  '#app',
//   components: {App},
//   template: "<App/>"
// })

// 点评demo
// new Vue({
//   el:  '#app',
//   components: {Comments},
//   template: "<Comments/>"
// })

// 待办事宜demo
// new Vue({
//   el:  '#app',
//   components: {Todo},
//   template: "<Todo/>"
// })

// 查询用户
  new Vue ({
    el:   '#app',
    components: {SearchUsers},
    template: '<SearchUsers/>'
  })
