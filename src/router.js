import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import(/* webpackChunkName: "home" */"./views/Home.vue")
    },
    {
      path: "/top",
      name: "top",
      component: () => import(/* webpackChunkName: "top" */"./views/Top.vue")
    },
    {
      path: "/account",
      name: "account",
      component: () => import(/* webpackChunkName: "account" */"./views/Account.vue")
    },
    {
      path: "/lesson",
      name: "lesson",
      component: () => import(/* webpackChunkName: "lesson" */"./views/Lesson.vue")
    },
    {
      path: "/favorite",
      name: "favorite",
      component: () => import(/* webpackChunkName: "lesson" */"./views/Favorite.vue")
    },
    {
      path: "*",
      redirect: "/"
    }
  ]
});
