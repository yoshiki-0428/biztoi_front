<template>
  <v-app>
    <v-app-bar app>
      <div>
        <search-btn />
      </div>
      <v-toolbar-title>
        <router-link to="/">
          Biztoi
        </router-link>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="hidden-md-and-down">
        <v-btn text v-for="item in menu" :key="item.icon" :to="item.link">
          <v-list-item-icon>
            <v-icon v-text="item.icon"></v-icon>
          </v-list-item-icon>
          {{ item.title }}
        </v-btn>
      </v-toolbar-items>
      <v-menu>
        <template v-slot:activator="{ on }">
          <v-btn text icon class="hidden-md-and-up" v-on="on">
            <v-app-bar-nav-icon></v-app-bar-nav-icon>
          </v-btn>
        </template>
        <v-list>
          <v-list-item v-for="item in menu" :key="item.icon" :to="item.link">
            <v-list-item-icon>
              <v-icon v-text="item.icon"></v-icon>
            </v-list-item-icon>
            <v-list-item-title>
              {{ item.title }}
            </v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-app-bar>
  </v-app>
</template>

<script>
import SearchBtn from "./SearchBtn";
export default {
  components: { SearchBtn },
  data: function() {
    return {
      menu: [
        {
          icon: "mdi-tooltip-text",
          title: "ABOUT",
          link: "/about"
        },
        {
          icon: "mdi-book-open-page-variant",
          title: "LESSON",
          link: "/lesson"
        },
        {
          icon: "mdi-account-card-details",
          title: "ACCOUNT",
          link: "/account"
        }
      ],
    };
  }
};
</script>

<style scoped>
li {
  list-style: none;
}
</style>
