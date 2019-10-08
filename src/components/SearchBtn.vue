<template>
  <transition name="fade">
    <v-row justify="center">
      <v-dialog v-model="dialog" fullscreen v-scroll>
        <template v-slot:activator="{ on }">
          <v-btn icon v-on="on">
            <v-icon>mdi-book-search</v-icon>
          </v-btn>
        </template>
        <v-card>
          <v-btn icon color="black" @click="dialog = false">
            <v-icon>mdi-close</v-icon>
          </v-btn>
          <books-search />
        </v-card>
      </v-dialog>
    </v-row>
  </transition>
</template>

<script>
import BooksSearch from "./BooksSearch";
export default {
  components: { BooksSearch },
  data() {
    return {
      dialog: false
    };
  }
};
</script>
