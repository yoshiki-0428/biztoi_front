<template>
    <v-bottom-navigation
        v-model="bottomNav"
        shift
        app
        dark
    >
        <div class="search-btn">
            <search-btn />
        </div>
        <v-btn icon v-for="item in menu" :key="item.icon" :to="item.link">
            <v-icon v-text="item.icon"></v-icon>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-btn>
    </v-bottom-navigation>
</template>

<script>
import SearchBtn from "./SearchBtn"
export default {
  components: {SearchBtn},
  data: function () {
    return {
      bottomNav: 4,
      menu: [
        {
          icon: "mdi-home",
          title: "Home",
          link: "/top"
        },
        {
          icon: "mdi-heart",
          title: "Favorite",
          link: "/favorite"
        },
        {
          icon: "mdi-account",
          title: "Account",
          link: "/account"
        }
      ],
    }
  },
}
</script>

<style scoped>
    div.search-btn{
        border-style: none;
        margin-top: 0.87rem;
        margin-right: 0.3rem;
    }
    div.search-btn:hover{
        box-shadow: grey;
    }
</style>


