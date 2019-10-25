<template>
  <v-flex xs12 md12>
    <v-row>
      <v-col xs8 md8>
          <v-autocomplete
                  :items="items"
                  :loading="isLoading"
                  :search-input.sync="word"
                  label="書籍検索キーワード"
                  placeholder="Search..."
                  no-filter
                  hide-no-data
                  item-text="title"
                  prepend-inner-icon="mdi-database-search"
                  rounded
                  clearable
                  outlined
                  hide-selected
          >
          <template v-slot:item="data">
            <template>
              <v-list-item-content>
                <v-list-item-title v-html="data.item.title"></v-list-item-title>
              </v-list-item-content>
            </template>
          </template>
        </v-autocomplete>
        <v-select
          :items="targets"
          label="絞り込み検索"
          outlined
          rounded
          return-object
          v-model="selected"
        ></v-select>
        <book-details
          class="book-list"
          v-for="item in items"
          :key="item.id"
          :book="item"
        >
        </book-details>
      </v-col>
    </v-row>
  </v-flex>
</template>

<script>
import Book from "../model/Book"
import _ from "lodash"
import BookDetails from "./BookDetail"
export default {
  components: {BookDetails},
  data() {
    return {
      word: "",
      items: [],
      selected: "title",
      targets: ["title", "author"],
      isLoading: false
    }
  },
  watch: {
    word() {
      if (this.word) {
        this.debouncedGetResult()
        this.isLoading = true
      }
    }
  },
  created() {
    this.debouncedGetResult = _.debounce(this.getResult, 400)
  },
  methods: {
    getResult() {
      if (this.word.length !== 0) {
        this.$googleBookApi
          .getBooks(this.selected, this.word)
          .then(res => {
            this.items = res.data.items.map(item => {
              return new Book(item.volumeInfo)
            })
            this.isLoading = false
          })
          .catch(err => {
            this.isLoading = false
            console.log(err.response)
          })
      }
    }
  }
}
</script>

<style scoped>
.v-autocomplete__content.v-menu__content .v-card {
  max-height: 150px;
}
</style>
