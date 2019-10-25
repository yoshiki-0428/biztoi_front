<template>
  <v-app>
    <v-content>
      <v-container>
        <v-layout>
          <v-flex xs12>
            <v-content>
              <transition>
                <router-view />
              </transition>
            </v-content>
            <main-footer />
          <footer-menu />
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import FooterMenu from "./components/FooterMenu"
import MainFooter from "./components/MainFooter"

export default {
  name: "App",
  components: {
    MainFooter,
    FooterMenu
  }
}
</script>

<style>
.v-application--wrap {
  min-height: 0px;
}
.layout {
  padding-top: -1rem;
}

</style>
