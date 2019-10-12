<template>
  <transition name="fade">
    <v-row justify="center" md12 xs12>
      <v-dialog v-model="dialog">
        <template v-slot:activator="{ on }">
          <v-btn icon v-on="on">
            <v-icon>mdi-book-search</v-icon>
          </v-btn>
        </template>
        <v-card height="5000px" md10 xs10>
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
